package org.netbeans.modules.php.blade.editor;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.Element;
import org.antlr.v4.runtime.CharStreams;
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
import org.netbeans.modules.php.blade.csl.elements.ElementType;
import org.netbeans.modules.php.blade.csl.elements.NamedElement;
import org.netbeans.modules.php.blade.csl.elements.PathElement;
import org.netbeans.modules.php.blade.csl.elements.PhpFunctionElement;
import org.netbeans.modules.php.blade.editor.directives.CustomDirectives;
import org.netbeans.modules.php.blade.editor.indexing.BladeIndex;
import org.netbeans.modules.php.blade.editor.indexing.PhpIndexFunctionResult;
import org.netbeans.modules.php.blade.editor.indexing.PhpIndexResult;
import org.netbeans.modules.php.blade.editor.indexing.PhpIndexUtils;
import org.netbeans.modules.php.blade.editor.indexing.QueryUtils;
import org.netbeans.modules.php.blade.editor.parser.BladeParserResult;
import org.netbeans.modules.php.blade.editor.parser.BladeParserResult.Reference;
import static org.netbeans.modules.php.blade.editor.parser.BladeParserResult.ReferenceType.PHP_FUNCTION;
import org.netbeans.modules.php.blade.editor.path.PathUtils;
import org.netbeans.modules.php.blade.project.PhpProjectIndex;
import org.netbeans.modules.php.blade.syntax.antlr4.v10.BladeAntlrLexer;
import org.netbeans.spi.lexer.antlr4.AntlrTokenSequence;
import org.openide.filesystems.FileObject;
import static org.netbeans.modules.php.blade.syntax.antlr4.v10.BladeAntlrLexer.*;
import org.netbeans.modules.php.blade.syntax.antlr4.v10.BladeAntlrUtils;
import org.netbeans.modules.php.editor.lexer.PHPTokenId;
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
        BLADE_PATH, SECTION, USE, HAS_SECTION, PHP, CUSTOM_DIRECTIVE, NONE, PHP_CLASS
    }

    DeclarationType currentDeclarationType;

    @Override
    public OffsetRange getReferenceSpan(Document document, int caretOffset) {
        BaseDocument baseDoc = (BaseDocument) document;

        baseDoc.readLock();
        AntlrTokenSequence tokens = null;
        TokenSequence<? extends PHPTokenId> tsPhp = null;
        org.netbeans.api.lexer.Token<?> tokenPhp = null;
        OffsetRange offsetRange = OffsetRange.NONE;
        int lineOffset = caretOffset;
        currentDeclarationType = null;
        try {
            try {
                String text = baseDoc.getText(0, baseDoc.getLength());
                tokens = new AntlrTokenSequence(new BladeAntlrLexer(CharStreams.fromString(text)));
            } catch (BadLocationException ex) {
                //Exceptions.printStackTrace(ex);
            }
        } finally {
            baseDoc.readUnlock();
        }

        //inside php expression context ??
        if (tokens == null || tokens.isEmpty()) {
            return offsetRange;
        }

        tokens.seekTo(lineOffset);

        if (tokens.hasNext()) {
            org.antlr.v4.runtime.Token nt = tokens.next().get();

            switch (nt.getType()) {
                case D_CUSTOM:
                case PHP_IDENTIFIER:
                    return new OffsetRange(nt.getStartIndex(), nt.getStopIndex() + 1);
            }

            if (!tokens.hasPrevious()) {
                return offsetRange;
            }

            if (nt.getType() == BL_PARAM_STRING) {
                List<Integer> tokensMatch = Arrays.asList(new Integer[]{
                    D_EXTENDS, D_INCLUDE, D_EACH, D_SECTION, D_HAS_SECTION, D_SECTION_MISSING, D_PUSH, D_USE
                });
                List<Integer> tokensStop = Arrays.asList(new Integer[]{HTML});
                org.antlr.v4.runtime.Token matchedToken = BladeAntlrUtils.findBackward(tokens, tokensMatch, tokensStop);
                int offsetCorrection = caretOffset - lineOffset;
                if (matchedToken != null) {
                    offsetRange = new OffsetRange(nt.getStartIndex() + offsetCorrection, nt.getStopIndex() + offsetCorrection + 1);
                }
                return offsetRange;
            }
            //we will skip constant encapsed string and give priority to directives
            /*
            OffsetRange phpSpanRange = getPhpReferenceSpan(tsPhp, tokenPhp);
            if (!phpSpanRange.isEmpty()) {
                return phpSpanRange;
            }
             */

        }
        return offsetRange;
    }

    @Override
    public DeclarationLocation findDeclaration(ParserResult info, int caretOffset) {
        BladeParserResult parserResult = (BladeParserResult) info;

        Reference reference = parserResult.findOccuredRefrence(caretOffset);

        if (reference == null) {
            //what to do with constants??
            return DeclarationLocation.NONE;
        }

        PhpProjectIndex phpProjectIndex;
        FileObject currentFile = parserResult.getFileObject();
        DeclarationLocation location = DeclarationLocation.NONE;

        switch (reference.type) {
            case EXTENDS:
            case INCLUDE:
                String bladePath = reference.name;
                List<FileObject> includedFiles = PathUtils.findFileObjectsForBladePath(currentFile, bladePath);

                if (includedFiles.isEmpty()) {
                    return DeclarationLocation.NONE;
                }

                for (FileObject includedFile : includedFiles) {
                    PathElement elHandle = new PathElement(reference.name, includedFile);
                    DeclarationLocation dln = new DeclarationFinder.DeclarationLocation(includedFile, 0, elHandle);
                    if (location.equals(DeclarationLocation.NONE)) {
                        location = dln;
                    }
                    location.addAlternative(new AlternativeLocationImpl(dln));
                }
                return location;
            case SECTION:
            case HAS_SECTION:
            case SECTION_MISSING:
                String yieldId = reference.name;
                List<BladeIndex.IndexedReference> yields = QueryUtils.getYieldReferences(yieldId, currentFile);
                if (yields == null) {
                    return DeclarationLocation.NONE;
                }

                for (BladeIndex.IndexedReference yieldReference : yields) {
                    String yieldReferenceId = yieldReference.getReference().name;
                    NamedElement yieldIdHandle = new NamedElement(yieldReferenceId,
                            yieldReference.getOriginFile(), ElementType.YIELD_ID);
                    int startOccurence = yieldReference.getReference().defOffset.getStart();
                    DeclarationLocation dlyieldItem = new DeclarationFinder.DeclarationLocation(yieldReference.getOriginFile(), startOccurence, yieldIdHandle);
                    if (location.equals(DeclarationLocation.NONE)) {
                        location = dlyieldItem;
                    }
                    location.addAlternative(new AlternativeLocationImpl(dlyieldItem));
                }

                return location;
            case PUSH:
                String stackId = reference.name;
                List<BladeIndex.IndexedReference> stacks = QueryUtils.getStacksReferences(stackId, currentFile);

                if (stacks == null) {
                    return DeclarationLocation.NONE;
                }

                for (BladeIndex.IndexedReference stackReference : stacks) {
                    String stackReferenceId = stackReference.getReference().name;
                    NamedElement yieldIdHandle = new NamedElement(stackReferenceId, stackReference.getOriginFile(), ElementType.STACK_ID);
                    int startOccurence = stackReference.getReference().defOffset.getStart();
                    DeclarationLocation dlstack = new DeclarationFinder.DeclarationLocation(stackReference.getOriginFile(), startOccurence, yieldIdHandle);
                    if (location.equals(DeclarationLocation.NONE)) {
                        location = dlstack;
                    }
                    location.addAlternative(new AlternativeLocationImpl(dlstack));
                }

                return location;
            case CUSTOM_DIRECTIVE:
                String directiveNameFound = reference.name;
                Project project = FileOwnerQuery.getOwner(currentFile);

                DeclarationLocation dlcustomDirective = DeclarationLocation.NONE;

                CustomDirectives.getInstance(project).filterAction(new CustomDirectives.FilterCallbackDeclaration(dlcustomDirective) {
                    @Override
                    public void filterDirectiveName(String directiveName, FileObject file) {
                        if (directiveName.equals(directiveNameFound)) {
                            NamedElement customDirectiveHandle = new NamedElement(directiveNameFound, file, ElementType.CUSTOM_DIRECTIVE);
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
            case PHP_CLASS:
                phpProjectIndex = PhpProjectIndex.getInstance();
                Collection<PhpIndexResult> indexClassResults = PhpIndexUtils.queryExactClass(phpProjectIndex.rootFile, reference.name);

                for (PhpIndexResult indexResult : indexClassResults) {
                    NamedElement resultHandle = new NamedElement(reference.name, indexResult.declarationFile, ElementType.PHP_CLASS);
                     DeclarationLocation classLocation = new DeclarationFinder.DeclarationLocation(indexResult.declarationFile, indexResult.getStartOffset(), resultHandle);
                    if (location.equals(DeclarationLocation.NONE)) {
                        location = classLocation;
                    }
                    location.addAlternative(new AlternativeLocationImpl(classLocation));
                }
                return location;
            case PHP_FUNCTION:
                phpProjectIndex = PhpProjectIndex.getInstance();
                Collection<PhpIndexFunctionResult> indexResults = PhpIndexUtils.queryExactFunctions(phpProjectIndex.rootFile, reference.name);
                for (PhpIndexFunctionResult indexResult : indexResults) {
                    PhpFunctionElement resultHandle = new PhpFunctionElement(
                            reference.name,
                            indexResult.declarationFile,
                            ElementType.PHP_FUNCTION,
                            indexResult.getParams()
                    );
                    DeclarationLocation functionLocation = new DeclarationFinder.DeclarationLocation(indexResult.declarationFile, indexResult.getStartOffset(), resultHandle);
                    if (location.equals(DeclarationLocation.NONE)) {
                        location = functionLocation;
                    }
                    location.addAlternative(new AlternativeLocationImpl(functionLocation));
                }
                return location;
            case PHP_CONSTANT:
                phpProjectIndex = PhpProjectIndex.getInstance();
                Collection<PhpIndexResult> indexConstantsResults = PhpIndexUtils.queryExactConstants(phpProjectIndex.rootFile, reference.name);
                for (PhpIndexResult indexResult : indexConstantsResults) {
                    NamedElement resultHandle = new NamedElement(reference.name, indexResult.declarationFile, ElementType.PHP_CONSTANT);
                    DeclarationLocation constantLocation = new DeclarationFinder.DeclarationLocation(indexResult.declarationFile, indexResult.getStartOffset(), resultHandle);
                    if (location.equals(DeclarationLocation.NONE)) {
                        location = constantLocation;
                    }
                    location.addAlternative(new AlternativeLocationImpl(constantLocation));
                }
                return location;
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
             ElementHandle el = getLocation().getElement();
            if (el != null){
                formatter.appendText(el.getName());
                if (el.getFileObject() != null){
                    formatter.appendText(" in ");
                    formatter.appendText(FileUtil.getFileDisplayName(el.getFileObject()));
                }
                return formatter.getText();
            }
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
