/*
Licensed to the Apache Software Foundation (ASF)
 */
package org.netbeans.modules.php.blade.editor.completion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import org.netbeans.editor.BaseDocument;
import javax.swing.text.AbstractDocument;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.JTextComponent;
import org.antlr.v4.runtime.CharStreams;
import org.netbeans.api.editor.document.EditorDocumentUtils;
import org.netbeans.modules.csl.api.CodeCompletionContext;
import org.netbeans.modules.csl.api.CodeCompletionHandler2;
import org.netbeans.modules.csl.api.CodeCompletionResult;
import org.netbeans.modules.csl.api.CompletionProposal;
import org.netbeans.modules.csl.api.Documentation;
import org.netbeans.modules.csl.api.ElementHandle;
import org.netbeans.modules.csl.api.ParameterInfo;
import org.netbeans.modules.csl.spi.ParserResult;
import org.netbeans.modules.csl.spi.support.CancelSupport;
import org.netbeans.modules.php.blade.syntax.antlr4.v10.BladeAntlrLexer;
import org.netbeans.spi.lexer.antlr4.AntlrTokenSequence;
import org.openide.filesystems.FileObject;

/**
 * should be removed or swapped with blade completion provider
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
        
        
        return CodeCompletionResult.NONE;
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

        switch(lastChar){
            case '\n':
                return QueryType.STOP;
            default:
                return BladeCompletionService.getQueryType(component, typedText);
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
        return new ParameterInfo(new ArrayList<String>(), 0, 0);
    }

    @Override
    public Documentation documentElement(ParserResult parserResult, ElementHandle elementHandle, Callable<Boolean> cancel) {
        Documentation result = null;
        return result;
    }
}
