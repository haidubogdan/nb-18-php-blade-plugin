package org.netbeans.modules.php.blade.editor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.text.AbstractDocument;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.Element;
import org.antlr.v4.runtime.CharStreams;
import org.netbeans.api.lexer.Token;
import org.netbeans.api.lexer.TokenHierarchy;
import org.netbeans.api.lexer.TokenSequence;
import org.netbeans.modules.csl.api.DeclarationFinder;
import org.netbeans.modules.csl.api.OffsetRange;
import org.netbeans.modules.csl.spi.ParserResult;
import org.netbeans.api.editor.document.LineDocumentUtils;
import org.netbeans.editor.BaseDocument;
import org.netbeans.modules.csl.api.ElementHandle;
import org.netbeans.modules.csl.api.ElementKind;
import org.netbeans.modules.csl.api.HtmlFormatter;
import org.netbeans.modules.csl.api.Modifier;
import org.netbeans.modules.php.blade.csl.elements.PathElement;
import org.netbeans.modules.php.blade.csl.elements.YieldIdElement;
import org.netbeans.modules.php.blade.editor.indexing.BladeIndex;
import org.netbeans.modules.php.blade.editor.indexing.QueryUtils;
import org.netbeans.modules.php.blade.editor.parser.BladeParserResult;
import org.netbeans.modules.php.blade.editor.parser.BladeParserResult.Reference;
import org.netbeans.modules.php.blade.editor.path.PathUtils;
import org.netbeans.modules.php.blade.syntax.antlr4.v10.BladeAntlrLexer;
import org.netbeans.spi.lexer.antlr4.AntlrTokenSequence;
import org.openide.filesystems.FileObject;
import static org.netbeans.modules.php.blade.syntax.antlr4.v10.BladeAntlrLexer.*;
import org.netbeans.modules.php.blade.syntax.antlr4.v10.BladeAntlrUtils;
import org.openide.util.Exceptions;

/**
 *
 * @author bhaidu
 */
public class BladeDeclarationFinder implements DeclarationFinder {

    static enum DeclarationType {
        BLADE_PATH, SECTION, PHP, NONE
    }

    @Override
    public OffsetRange getReferenceSpan(Document document, int caretOffset) {
        BaseDocument baseDoc = (BaseDocument) document;

        baseDoc.readLock();
        AntlrTokenSequence tokens = null;
        OffsetRange offsetRange = OffsetRange.NONE;
        int lineOffset = caretOffset;
        try {
            Element lineElement = baseDoc.getParagraphElement(caretOffset);
            int start = lineElement.getStartOffset();
            lineOffset = caretOffset - start;
            try {
                int end = lineElement.getEndOffset();
                String text = baseDoc.getText(start, end - start);
                tokens = new AntlrTokenSequence(new BladeAntlrLexer(CharStreams.fromString(text)));
            } catch (BadLocationException ex) {
                //Exceptions.printStackTrace(ex);
            }

        } finally {
            baseDoc.readUnlock();
        }

        if (tokens == null || tokens.isEmpty()) {
            return offsetRange;
        }
        tokens.seekTo(lineOffset);

        if (tokens.hasNext()) {
            if (!tokens.hasPrevious()) {
                return offsetRange;
            }

            org.antlr.v4.runtime.Token nt = tokens.next().get();

            if (nt.getType() == BL_PARAM_STRING) {
                List<Integer> tokensMatch = Arrays.asList(new Integer[]{D_EXTENDS, D_INCLUDE, D_SECTION});
                List<Integer> tokensStop = Arrays.asList(new Integer[]{HTML});
                org.antlr.v4.runtime.Token matchedToken = BladeAntlrUtils.findBackward(tokens, tokensMatch, tokensStop);
                int offsetCorrection = caretOffset - lineOffset;
                if (matchedToken != null) {
                    offsetRange = new OffsetRange(nt.getStartIndex() + offsetCorrection, nt.getStopIndex() + offsetCorrection + 1);
                }
            }
        }
        return offsetRange;
    }

    @Override
    public DeclarationLocation findDeclaration(ParserResult info, int caretOffset) {
        BladeParserResult parserResult = (BladeParserResult) info;

        Reference reference = parserResult.findReferenceForDeclaration(caretOffset);

        if (reference == null) {
            return DeclarationLocation.NONE;
        }

        FileObject currentFile = parserResult.getFileObject();

        switch (reference.type) {
            case EXTENDS:
            case INCLUDE:
                String bladePath = reference.name;
                FileObject includedFile = PathUtils.findFileObjectForBladePath(currentFile, bladePath);

                if (includedFile == null) {
                    return DeclarationLocation.NONE;
                }

                PathElement elHandle = new PathElement(reference.name, includedFile);
                DeclarationLocation dln = new DeclarationFinder.DeclarationLocation(includedFile, 0, elHandle);

                dln.addAlternative(new AlternativeLocationImpl(dln));
                return dln;
            case SECTION:
                String yieldId = reference.name;
                List<BladeIndex.IndexedReference> yields = QueryUtils.getYieldReferences(yieldId, currentFile);
                if (yields == null) {
                    return DeclarationLocation.NONE;
                }

                DeclarationLocation dlyield = DeclarationLocation.NONE;

                for (BladeIndex.IndexedReference yieldReference : yields) {
                    String yieldReferenceId = yieldReference.getReference().name;
                    YieldIdElement yieldIdHandle = new YieldIdElement(yieldReferenceId, yieldReference.getOriginFile());
                    int startOccurence = yieldReference.getReference().defOffset.getStart();
                    dlyield = new DeclarationFinder.DeclarationLocation(yieldReference.getOriginFile(), startOccurence, yieldIdHandle);
                    dlyield.addAlternative(new AlternativeLocationImpl(dlyield));
                }

                return dlyield;

        }

        return DeclarationLocation.NONE;
    }

    private static class AlternativeLocationImpl implements AlternativeLocation {

        private final DeclarationLocation location;

        public AlternativeLocationImpl(DeclarationLocation location) {
            this.location = location;
        }

        @Override
        public ElementHandle getElement() {
            return getLocation().getElement();
        }

        @Override
        public String getDisplayHtml(HtmlFormatter formatter) {
            return getLocation().toString();
        }

        @Override
        public DeclarationFinder.DeclarationLocation getLocation() {
            return location;
        }

        @Override
        public int compareTo(DeclarationFinder.AlternativeLocation o) {
            return 0;
        }

    }
}
