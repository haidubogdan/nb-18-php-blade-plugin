package org.netbeans.modules.php.blade.editor.completion;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import org.netbeans.editor.BaseDocument;
import javax.swing.text.Document;
import javax.swing.text.JTextComponent;
import org.antlr.v4.runtime.Token;
import org.netbeans.modules.csl.api.CodeCompletionContext;
import org.netbeans.modules.csl.api.CodeCompletionHandler;
import org.netbeans.modules.csl.api.CodeCompletionHandler2;
import org.netbeans.modules.csl.api.CodeCompletionResult;
import org.netbeans.modules.csl.api.CompletionProposal;
import org.netbeans.modules.csl.api.Documentation;
import org.netbeans.modules.csl.api.ElementHandle;
import org.netbeans.modules.csl.api.ParameterInfo;
import org.netbeans.modules.csl.spi.DefaultCompletionResult;
import org.netbeans.modules.csl.spi.ParserResult;
import org.netbeans.modules.csl.spi.support.CancelSupport;
import org.netbeans.modules.php.blade.csl.elements.ElementType;
import org.netbeans.modules.php.blade.csl.elements.NamedElement;
import org.netbeans.modules.php.blade.editor.completion.BladeCompletionItem.CompletionRequest;
import org.netbeans.modules.php.blade.editor.indexing.PhpIndexResult;
import org.netbeans.modules.php.blade.editor.indexing.PhpIndexUtils;
import org.netbeans.modules.php.blade.editor.parser.BladeParserResult;
import org.netbeans.modules.php.blade.editor.parser.ParsingUtils;
import org.netbeans.modules.php.blade.project.PhpProjectIndex;
import org.netbeans.modules.php.blade.syntax.antlr4.v10.BladeAntlrUtils;
import org.netbeans.modules.php.editor.csl.PHPLanguage;
import static org.netbeans.modules.php.blade.syntax.antlr4.v10.BladeAntlrLexer.*;
import org.openide.filesystems.FileObject;

/**
 *
 * @author bogdan
 */
public class BladeCompletionHandler implements CodeCompletionHandler2 {

    @Override
    public CodeCompletionResult complete(CodeCompletionContext completionContext) {
        BaseDocument doc = (BaseDocument) completionContext.getParserResult().getSnapshot().getSource().getDocument(false);
        if (doc == null) {
            return CodeCompletionResult.NONE;
        }

        if (CancelSupport.getDefault().isCancelled()) {
            return CodeCompletionResult.NONE;
        }

        if (completionContext.getCaretOffset() < 1) {
            return CodeCompletionResult.NONE;
        }

        BladeParserResult parserResult = (BladeParserResult) completionContext.getParserResult();

        final List<CompletionProposal> completionProposals = new ArrayList<>();

        Token currentToken = BladeAntlrUtils.getToken(doc, completionContext.getCaretOffset() - 1);

        if (currentToken == null) {
            return CodeCompletionResult.NONE;
        }

        switch (currentToken.getType()) {
            case PHP_EXPRESSION:
            //case PHP_IDENTIFIER:
                completePhpSnippet(completionProposals, completionContext.getCaretOffset(), currentToken);
                break;
            case BLADE_PHP_INLINE:
                completePhp(completionProposals, completionContext, parserResult);
                break;
            case PHP_VARIABLE:
                completeScopedVariables(completionProposals, completionContext, parserResult, currentToken);
                break;
        }

        //TODO add context
        return new DefaultCompletionResult(completionProposals, false);
    }

    private void completePhpSnippet(final List<CompletionProposal> completionProposals,
            int offset, Token currentToken) {
        String phpSnippet = currentToken.getText();
        String phpStart = "<?php";
        if (phpSnippet.length() < 1 || currentToken.getStartIndex() < phpStart.length()) {
            return;
        }
        int previousSpace = currentToken.getStartIndex() - phpStart.length();
        ParsingUtils parsingUtils = new ParsingUtils();
        String whitespaceFill = new String(new char[previousSpace]).replace("\0", " ");
        String phpSnippetText = whitespaceFill + phpStart + currentToken.getText();
        parsingUtils.parsePhpText(phpSnippetText);
        ParserResult phpParserResult = parsingUtils.getParserResult();
        if (phpParserResult == null) {
            return;
        }
        CodeCompletionHandler cc = (new PHPLanguage()).getCompletionHandler();
        String prefix = cc.getPrefix(phpParserResult, offset, true);

        if (prefix == null) {
            return;
        }

        if (prefix.length() == 0) {
            prefix = cc.getPrefix(phpParserResult, offset - 1, true);
        }

        if (prefix == null || prefix.length() == 0) {
            return;
        }
        String phpPrefix = prefix;

        CodeCompletionContext context = PhpCodeCompletionContext.completionContext(offset,
                phpParserResult, phpPrefix);

        CodeCompletionResult completionResult = cc.complete(context);
        List<CompletionProposal> proposals = completionResult.getItems();
        for (CompletionProposal proposal : proposals) {
            String proposalPrefix = proposal.getInsertPrefix();
            if (proposalPrefix.startsWith(prefix)) {
                completionProposals.add(proposal);
            }
        }
        if (!prefix.startsWith("$") && proposals.isEmpty()) {
            PhpProjectIndex phpProjectIndex = PhpProjectIndex.getInstance();
            Collection<PhpIndexResult> classes = PhpIndexUtils.queryClass(phpProjectIndex.rootFile, prefix);
            
            for (PhpIndexResult indexedClass : classes){
                CompletionRequest request = new CompletionRequest();
                request.anchorOffset = offset - prefix.length();
                request.carretOffset = offset;
                request.prefix = prefix;
                NamedElement classElement = new NamedElement(indexedClass.name,
                        indexedClass.declarationFile, ElementType.PHP_CLASS);
                completionProposals.add(new BladeCompletionItem.ClassItem(classElement, request, indexedClass.name));
            }
        }
    }

    private void completePhp(final List<CompletionProposal> completionProposals,
            final CodeCompletionContext completionContext, BladeParserResult parserResult) {
        int offset = completionContext.getCaretOffset();
        ParserResult phpParserResult = parserResult.getPhpParserResult();
        if (phpParserResult == null) {
            return;
        }
        CodeCompletionHandler cc = (new PHPLanguage()).getCompletionHandler();
        String prefix = cc.getPrefix(phpParserResult, offset, true);

        if (prefix == null) {
            return;
        }

        if (prefix.length() == 0) {
            prefix = cc.getPrefix(phpParserResult, offset - 1, true);
        }

        if (prefix == null || prefix.length() == 0) {
            return;
        }

        String phpPrefix = prefix;

        CodeCompletionContext context = PhpCodeCompletionContext.completionContext(offset,
                phpParserResult, phpPrefix);

        CodeCompletionResult completionResult = cc.complete(context);
        List<CompletionProposal> proposals = completionResult.getItems();
        for (CompletionProposal proposal : proposals) {
            String proposalPrefix = proposal.getInsertPrefix();
            if (proposalPrefix.startsWith(prefix)) {
                completionProposals.add(proposal);
            }
        }

        if (phpPrefix.startsWith("@")) {
            completeScopedVariables(completionProposals, completionContext, parserResult, phpPrefix);
        }
    }

    private void completeScopedVariables(final List<CompletionProposal> completionProposals,
            CodeCompletionContext completionContext, BladeParserResult parserResult, Token currentToken) {
        String variablePrefix = currentToken.getText();
        Set<String> scopedVariables = parserResult.findVariablesForScope(completionContext.getCaretOffset());
        FileObject fo = completionContext.getParserResult().getSnapshot().getSource().getFileObject();
        if (scopedVariables != null) {
            for (String variableName : scopedVariables) {
                if (variableName.startsWith(variablePrefix)) {
                    NamedElement variableElement = new NamedElement(variableName,fo, ElementType.VARIABLE );
                    CompletionRequest request = new CompletionRequest();
                    request.anchorOffset = completionContext.getCaretOffset() - variablePrefix.length();
                    request.carretOffset = completionContext.getCaretOffset();
                    request.prefix = variablePrefix;
                    completionProposals.add(new BladeCompletionItem.VariableItem(variableElement, request, variableName));
                }
            }
        }
    }

    private void completeScopedVariables(final List<CompletionProposal> completionProposals,
            CodeCompletionContext completionContext, BladeParserResult parserResult,
            String variablePrefix) {
        Set<String> scopedVariables = parserResult.findVariablesForScope(completionContext.getCaretOffset());
        FileObject fo = completionContext.getParserResult().getSnapshot().getSource().getFileObject();
        if (scopedVariables != null) {
            for (String variableName : scopedVariables) {
                if (variableName.startsWith(variablePrefix)) {
                    NamedElement variableElement = new NamedElement(variableName, fo, ElementType.VARIABLE);
                    CompletionRequest request = new CompletionRequest();
                    request.anchorOffset = completionContext.getCaretOffset() - variablePrefix.length();
                    request.carretOffset = completionContext.getCaretOffset();
                    request.prefix = variablePrefix;
                    completionProposals.add(new BladeCompletionItem.VariableItem(variableElement, request, variableName));
                }
            }
        }
    }

    @Override
    public String document(ParserResult pr, ElementHandle eh) {
        return null;
    }

    @Override
    public ElementHandle resolveLink(String string, ElementHandle eh) {
        return null;
    }

    @Override
    public String getPrefix(ParserResult info, int offset, boolean upToOffset) {
        return "";
    }

    @Override
    public QueryType getAutoQuery(JTextComponent component, String typedText) {
        if (typedText.length() == 0) {
            return QueryType.NONE;
        }

        char lastChar = typedText.charAt(typedText.length() - 1);

        switch (lastChar) {
            case '\n':
                return QueryType.STOP;
            default:
                return QueryType.TOOLTIP;
        }
    }

    @Override
    @SuppressWarnings("rawtypes")
    public String resolveTemplateVariable(String string, ParserResult pr, int i, String string1, Map map) {
        return null;
    }

    @Override
    public Set<String> getApplicableTemplates(Document dcmnt, int i, int i1) {
        return Collections.emptySet();
    }

    @Override
    public ParameterInfo parameters(ParserResult pr, int i, CompletionProposal cp) {
        return new ParameterInfo(new ArrayList<>(), 0, 0);
    }

    /**
     * used also for tooltip in blade mime context
     *
     * @param parserResult
     * @param elementHandle
     * @param cancel
     * @return
     */
    @Override
    public Documentation documentElement(ParserResult parserResult, ElementHandle elementHandle, Callable<Boolean> cancel) {
        Documentation result = null;
        
        if (elementHandle instanceof NamedElement) {
            return TooltipDoc.generateDoc((NamedElement) elementHandle);
        }
        return result;
    }
}
