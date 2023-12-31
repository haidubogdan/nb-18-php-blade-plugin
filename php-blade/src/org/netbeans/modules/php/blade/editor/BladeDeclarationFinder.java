package org.netbeans.modules.php.blade.editor;

import java.util.Arrays;
import java.util.List;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.Element;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.Token;
import org.netbeans.api.lexer.TokenHierarchy;
import org.netbeans.api.lexer.TokenId;
import org.netbeans.api.lexer.TokenSequence;
import org.netbeans.api.project.FileOwnerQuery;
import org.netbeans.api.project.Project;
import org.netbeans.modules.csl.api.DeclarationFinder;
import org.netbeans.modules.csl.api.OffsetRange;
import org.netbeans.modules.csl.spi.ParserResult;
import org.netbeans.editor.BaseDocument;
import org.netbeans.modules.csl.api.ElementHandle;
import org.netbeans.modules.csl.api.HtmlFormatter;
import org.netbeans.modules.php.blade.csl.elements.CustomDirectiveElement;
import org.netbeans.modules.php.blade.csl.elements.NamedElement;
import org.netbeans.modules.php.blade.csl.elements.PathElement;
import org.netbeans.modules.php.blade.csl.elements.StackIdElement;
import org.netbeans.modules.php.blade.csl.elements.YieldIdElement;
import org.netbeans.modules.php.blade.editor.compiler.BladePhpCompiler;
import org.netbeans.modules.php.blade.editor.completion.PhpTypeCompletionProvider;
import org.netbeans.modules.php.blade.editor.directives.CustomDirectives;
import org.netbeans.modules.php.blade.editor.indexing.BladeIndex;
import org.netbeans.modules.php.blade.editor.indexing.QueryUtils;
import org.netbeans.modules.php.blade.editor.lexer.BladeLexerUtils;
import org.netbeans.modules.php.blade.editor.parser.BladeParserResult;
import org.netbeans.modules.php.blade.editor.parser.BladeParserResult.Reference;
import org.netbeans.modules.php.blade.editor.parser.ParsingUtils;
import org.netbeans.modules.php.blade.editor.path.PathUtils;
import org.netbeans.modules.php.blade.editor.phpCsl.PhpTypeDeclarationProvider;
import org.netbeans.modules.php.blade.syntax.antlr4.v10.BladeAntlrLexer;
import org.netbeans.spi.lexer.antlr4.AntlrTokenSequence;
import org.openide.filesystems.FileObject;
import static org.netbeans.modules.php.blade.syntax.antlr4.v10.BladeAntlrLexer.*;
import org.netbeans.modules.php.blade.syntax.antlr4.v10.BladeAntlrUtils;
import org.netbeans.modules.php.editor.lexer.PHPTokenId;
import org.netbeans.spi.editor.completion.CompletionItem;
import org.netbeans.spi.editor.completion.support.CompletionUtilities;
import org.openide.filesystems.FileUtil;

/**
 * focuses mainly on string inputs
 *
 *
 * @author bhaidu
 */
public class BladeDeclarationFinder implements DeclarationFinder {

    //not used for the moment
    static enum DeclarationType {
        BLADE_PATH, SECTION, USE, HAS_SECTION, PHP, CUSTOM_DIRECTIVE, NONE
    }

    @Override
    public OffsetRange getReferenceSpan(Document document, int caretOffset) {
        BaseDocument baseDoc = (BaseDocument) document;

        baseDoc.readLock();
        AntlrTokenSequence tokens = null;
        TokenHierarchy<Document> th;
        TokenSequence<? extends PHPTokenId> tsPhp = null;
        org.netbeans.api.lexer.Token<?> tokenPhp = null;
        OffsetRange offsetRange = OffsetRange.NONE;
        int lineOffset = caretOffset;
        try {
            th = TokenHierarchy.get(document);
            tsPhp = BladeLexerUtils.getPhpTokenSequence(th, caretOffset);

            //we are in php context
            if (tsPhp != null) {
                tokenPhp = tsPhp.token();
                String name = tokenPhp.id().name();
                int x = 1;
            }

            if (tokenPhp == null || tokenPhp.id().equals(PHPTokenId.PHP_CONSTANT_ENCAPSED_STRING)) {
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
            }
        } finally {
            baseDoc.readUnlock();
        }

        if (tokens == null || tokens.isEmpty()) {
            return getPhpReferenceSpan(tsPhp, tokenPhp);
        }

        tokens.seekTo(lineOffset);

        if (tokens.hasNext()) {
            org.antlr.v4.runtime.Token nt = tokens.next().get();

            if (nt.getType() == D_CUSTOM) {
                int offsetCorrection = caretOffset - lineOffset;
                return new OffsetRange(nt.getStartIndex() + offsetCorrection, nt.getStopIndex() + offsetCorrection + 1);
            }

            //we will skip constant encapsed string and give priority to directives
            OffsetRange phpSpanRange = getPhpReferenceSpan(tsPhp, tokenPhp);
            if (!phpSpanRange.isEmpty()){
                return phpSpanRange;
            }
            
            if (!tokens.hasPrevious()) {
                return offsetRange;
            }

            if (nt.getType() == BL_PARAM_STRING) {
                List<Integer> tokensMatch = Arrays.asList(new Integer[]{
                    D_EXTENDS, D_INCLUDE, D_EACH, D_SECTION, D_HAS_SECTION, D_PUSH, D_USE
                });
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
                List<FileObject> includedFiles = PathUtils.findFileObjectsForBladePath(currentFile, bladePath);

                if (includedFiles.isEmpty()) {
                    return DeclarationLocation.NONE;
                }

                DeclarationLocation dln = DeclarationLocation.NONE;

                for (FileObject includedFile : includedFiles) {
                    PathElement elHandle = new PathElement(reference.name, includedFile);
                    dln = new DeclarationFinder.DeclarationLocation(includedFile, 0, elHandle);
                    dln.addAlternative(new AlternativeLocationImpl(dln));
                }
                return dln;
            case SECTION:
            case HAS_SECTION:
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
            case PUSH:
                String stackId = reference.name;
                List<BladeIndex.IndexedReference> stacks = QueryUtils.getStacksReferences(stackId, currentFile);

                if (stacks == null) {
                    return DeclarationLocation.NONE;
                }

                DeclarationLocation dlstack = DeclarationLocation.NONE;

                for (BladeIndex.IndexedReference stackReference : stacks) {
                    String stackReferenceId = stackReference.getReference().name;
                    StackIdElement yieldIdHandle = new StackIdElement(stackReferenceId, stackReference.getOriginFile());
                    int startOccurence = stackReference.getReference().defOffset.getStart();
                    dlstack = new DeclarationFinder.DeclarationLocation(stackReference.getOriginFile(), startOccurence, yieldIdHandle);
                    dlstack.addAlternative(new AlternativeLocationImpl(dlstack));
                }

                return dlstack;
            case CUSTOM_DIRECTIVE:
                String directiveNameFound = reference.name;
                Project project = FileOwnerQuery.getOwner(currentFile);

                DeclarationLocation dlcustomDirective = DeclarationLocation.NONE;

                CustomDirectives.getInstance(project).filterAction(new CustomDirectives.FilterCallbackDeclaration(dlcustomDirective) {
                    @Override
                    public void filterDirectiveName(String directiveName, FileObject file) {
                        if (directiveName.equals(directiveNameFound)) {
                            CustomDirectiveElement customDirectiveHandle = new CustomDirectiveElement(directiveNameFound, file);
                            DeclarationFinder.DeclarationLocation newLoc = new DeclarationFinder.DeclarationLocation(file, 0, customDirectiveHandle);
                            this.location.addAlternative(new AlternativeLocationImpl(newLoc));
                        }
                    }
                });

                if (!dlcustomDirective.getAlternativeLocations().isEmpty()) {
                    for (AlternativeLocation loc : dlcustomDirective.getAlternativeLocations()) {
                        dlcustomDirective = loc.getLocation();
                    }
                }
                return dlcustomDirective;
            case PHP_INLINE:
            case PHP_BLADE:
                DeclarationLocation locations;
                FileObject fo = parserResult.getSnapshot().getSource().getFileObject();
                 locations = PhpTypeDeclarationProvider.getInstance()
                         .getItems(fo, parserResult.getPhpParserResult(), caretOffset);
                
                return locations;
        }

        return DeclarationLocation.NONE;
    }

    private OffsetRange getPhpReferenceSpan(TokenSequence<? extends PHPTokenId> tsPhp, org.netbeans.api.lexer.Token<?> tokenPhp) {
        if (tsPhp != null && tokenPhp != null && !tokenPhp.id().equals(PHPTokenId.PHP_CONSTANT_ENCAPSED_STRING)) {
            TokenId phpId = tokenPhp.id();
            if (phpId.equals(PHPTokenId.PHP_STRING) || phpId.equals(PHPTokenId.PHP_VARIABLE)) {
                return new OffsetRange(tsPhp.offset(), tsPhp.offset() + tokenPhp.length());
            }
        }
        
        return OffsetRange.NONE;
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
    
    public static class BladeAlternativeLocation implements AlternativeLocation {

        private ElementHandle modelElement;
        private DeclarationLocation declaration;

        public BladeAlternativeLocation(ElementHandle modelElement, DeclarationLocation declaration) {
            this.modelElement = modelElement;
            this.declaration = declaration;
        }

        @Override
        public ElementHandle getElement() {
            return modelElement;
        }

        @Override
        public String getDisplayHtml(HtmlFormatter formatter) {
            formatter.reset();
            //ElementKind ek = modelElement.getKind();
            formatter.appendText(modelElement.getName());

            if (declaration.getFileObject() != null) {
                formatter.appendText(" in ");
                formatter.appendText(FileUtil.getFileDisplayName(declaration.getFileObject()));
            }

            return formatter.getText();
        }

        @Override
        public DeclarationLocation getLocation() {
            return declaration;
        }

        @Override
        public int compareTo(AlternativeLocation o) {
            BladeAlternativeLocation i = (BladeAlternativeLocation) o;
            return this.modelElement.getName().compareTo(i.modelElement.getName());
        }

        @Override
        public int hashCode() {
            int hash = 5;
            hash = 89 * hash + (this.modelElement != null ? this.modelElement.hashCode() : 0);
            hash = 89 * hash + (this.declaration != null ? this.declaration.hashCode() : 0);
            return hash;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final BladeAlternativeLocation other = (BladeAlternativeLocation) obj;
            if (this.modelElement != other.modelElement && (this.modelElement == null || !this.modelElement.equals(other.modelElement))) {
                return false;
            }
            if (this.declaration != other.declaration && (this.declaration == null || !this.declaration.equals(other.declaration))) {
                return false;
            }
            return true;
        }
    }
}
