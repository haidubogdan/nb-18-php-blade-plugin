
package org.netbeans.modules.php.blade.editor.refactoring;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.swing.text.BadLocationException;
import javax.swing.text.Position;
import javax.swing.text.StyledDocument;
import org.netbeans.api.editor.document.LineDocument;
import org.netbeans.api.editor.document.LineDocumentUtils;
import org.netbeans.modules.csl.api.OffsetRange;
import org.netbeans.modules.php.blade.editor.BladeLanguage;
import org.netbeans.modules.php.blade.editor.indexing.BladeIndex;
import org.netbeans.modules.php.blade.editor.parser.BladeParser;
import org.netbeans.modules.php.blade.editor.parser.BladeParserResult;
import org.netbeans.modules.php.blade.editor.parser.BladeParserResult.Reference;

import org.netbeans.modules.refactoring.api.AbstractRefactoring;
import org.netbeans.modules.refactoring.api.Problem;
import org.netbeans.modules.refactoring.api.WhereUsedQuery;
import org.netbeans.modules.refactoring.spi.RefactoringElementsBag;
import org.netbeans.modules.refactoring.spi.RefactoringPlugin;
import org.netbeans.modules.refactoring.spi.RefactoringPluginFactory;
import org.netbeans.modules.refactoring.spi.SimpleRefactoringElementImplementation;
import org.openide.cookies.EditorCookie;
import org.openide.filesystems.FileObject;
import org.openide.text.CloneableEditorSupport;
import org.openide.text.PositionBounds;
import org.openide.util.Exceptions;
import org.openide.util.Lookup;
import org.openide.util.NbBundle;
import org.openide.util.lookup.ServiceProvider;

/**
 *
 * @author bogdan
 */
public class Usage {

    private static final class WhereUsedRefactoringPlugin implements RefactoringPlugin {

        private final WhereUsedQuery query;
        private final SymbolInformation indexedReference;
        private final AtomicBoolean cancel = new AtomicBoolean();

        public WhereUsedRefactoringPlugin(WhereUsedQuery query, SymbolInformation symbolInformation) {
            this.query = query;
            this.indexedReference = symbolInformation;
        }

        @Override
        public Problem preCheck() {
            return null;
        }

        @Override
        public Problem checkParameters() {
            return null;
        }

        @Override
        public Problem fastCheckParameters() {
            return null;
        }

        @Override
        public void cancelRequest() {
            cancel.set(true);
        }

        @Override
        public Problem prepare(RefactoringElementsBag refactoringElements) {
            try {
                String name = this.indexedReference.getName().replace(".blade", "");
                FileObject sourceFO = this.indexedReference.getSourceFile();
                Map<FileObject, Set<FileObject>> includes = new HashMap<>();

                if (BladeLanguage.MIME_TYPE.equals(sourceFO.getMIMEType())) {
                    FileObject parent = sourceFO.getParent();
                    for (FileObject cf : parent.getChildren()) {
                        if (cancel.get()) {
                            throw new CancellationException();
                        }
                        if (BladeLanguage.MIME_TYPE.equals(cf.getMIMEType())) {
                            BladeParserResult result = BladeParser.getParserResult(cf);
                            int x = 1;
                            result.includeFilePaths.forEach(s -> {
                                FileObject referencedFO = parent.getFileObject(s + ".blade.php");
                                if (referencedFO != null) {
                                    includes.computeIfAbsent(cf, cd2 -> new HashSet<>())
                                            .add(referencedFO);
                                }
                            });
                        }
                    }
                }

                List<FileObject> toScan = new ArrayList<>();
                Set<FileObject> scannedFileObjects = new HashSet<>();

                toScan.add(sourceFO);

                while (!toScan.isEmpty()) {
                    if (cancel.get()) {
                        throw new CancellationException();
                    }

                    FileObject fo = toScan.remove(0);
                    if (scannedFileObjects.contains(fo)) {
                        continue;
                    }
                    scannedFileObjects.add(fo);

                    BladeParserResult result = BladeParser.getParserResult(fo);

                    Reference ref = result.references.get(name);

                    TreeSet<OffsetRange> ranges = new TreeSet<>();

                    if (ref != null) {
                        if (ref.defOffset != null) {
                            ranges.add(ref.defOffset);
                        }
                    }
                    ranges.addAll(result.getOccurrences(name));

                    for (OffsetRange or : ranges) {
                        PositionBounds bounds;
                        try {
                            CloneableEditorSupport es = fo.getLookup().lookup(CloneableEditorSupport.class);
                            EditorCookie ec = fo.getLookup().lookup(EditorCookie.class);
                            StyledDocument doc = ec.openDocument();
                            LineDocument ldoc = (LineDocument) doc;

                            int rowStart = LineDocumentUtils.getLineStart(ldoc, or.getStart());
                            int rowEnd = LineDocumentUtils.getLineEnd(ldoc, or.getEnd());

                            bounds = new PositionBounds(
                                    es.createPositionRef(or.getStart(), Position.Bias.Forward),
                                    es.createPositionRef(or.getEnd(), Position.Bias.Forward)
                            );

                            String lineText = doc.getText(rowStart, rowEnd - rowStart);
                            String annotatedLine
                                    = lineText.substring(0, or.getStart() - rowStart)
                                    + "<strong>"
                                    + lineText.substring(or.getStart() - rowStart, or.getEnd() - rowStart)
                                    + "</strong>"
                                    + lineText.substring(or.getEnd() - rowStart);
                            refactoringElements.add(query, new BladeRefactoringElementImpl(annotatedLine, fo, bounds));
                        } catch (BadLocationException | IOException ex) {
                            Exceptions.printStackTrace(ex);
                            bounds = null;
                        }
                    }

                    toScan.addAll(includes.getOrDefault(fo, Collections.emptySet()));

                    for (Entry<FileObject, Set<FileObject>> e : includes.entrySet()) {
                        if (e.getValue().contains(fo)) {
                            toScan.add(e.getKey());
                        }
                    }
                }

                return null;
            } catch (CancellationException ex) {
                return new Problem(false, "Cancelled");
            }
        }

    }

    @ServiceProvider(service = RefactoringPluginFactory.class)
    public static class FactoryImpl implements RefactoringPluginFactory {

        @Override
        public RefactoringPlugin createInstance(AbstractRefactoring refactoring) {
            if (refactoring instanceof WhereUsedQuery) {
                WhereUsedQuery q = (WhereUsedQuery) refactoring;
                SymbolInformation symbolInformation = q.getRefactoringSource().lookup(SymbolInformation.class);
                if (symbolInformation != null) {
                    return new WhereUsedRefactoringPlugin(q, symbolInformation);
                }
            }
            return null;
        }

    }

    public static class BladeRefactoringElementImpl extends SimpleRefactoringElementImplementation {

        private final String annotatedLine;
        private final FileObject file;
        private final PositionBounds bounds;

        public BladeRefactoringElementImpl(String annotatedLine, FileObject file, PositionBounds bounds) {
            this.annotatedLine = annotatedLine;
            this.file = file;
            this.bounds = bounds;
        }

        @Override
        public String getText() {
            return "Element usage";
        }

        @Override
        public String getDisplayText() {
            return annotatedLine;
        }

        @Override
        public void performChange() {
            // Currently the BladeRefactoringElementImpl is only used for the
            // WhereUsedRefactoring, which is not doing changes
            throw new UnsupportedOperationException();
        }

        @Override
        public Lookup getLookup() {
            return Lookup.EMPTY;
        }

        @Override
        public FileObject getParentFile() {
            return file;
        }

        @Override
        public PositionBounds getPosition() {
            return bounds;
        }
    }
}
