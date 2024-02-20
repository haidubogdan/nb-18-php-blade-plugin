/*
Licensed to the Apache Software Foundation (ASF)
 */
package org.netbeans.modules.php.blade.editor.completion;

import java.util.Collections;
import java.util.Set;
import javax.swing.ImageIcon;
import org.netbeans.modules.csl.api.CompletionProposal;
import org.netbeans.modules.csl.api.ElementHandle;
import org.netbeans.modules.csl.api.ElementKind;
import org.netbeans.modules.csl.api.HtmlFormatter;
import org.netbeans.modules.csl.api.Modifier;
import org.netbeans.modules.php.blade.editor.ResourceUtilities;
import org.netbeans.modules.php.blade.syntax.annotation.Directive;

import org.openide.filesystems.FileObject;

/**
 *
 * @author bogdan
 */
abstract public class BaseCompletionItem implements CompletionProposal {

    final CompletionRequest request;
    private final ElementHandle element;

    public BaseCompletionItem(ElementHandle element, CompletionRequest request) {
        this.element = element;
        this.request = request;
    }

    @Override
    public int getAnchorOffset() {
        return request.anchorOffset;
    }

    @Override
    public ElementHandle getElement() {
        return element;
    }

    @Override
    public String getName() {
        return element.getName();
    }

    @Override
    public String getSortText() {
        return getName();
    }

    @Override
    public int getSortPrioOverride() {
        return 0;
    }

    @Override
    public ImageIcon getIcon() {
        return null;
    }

    @Override
    public Set<Modifier> getModifiers() {
        return Collections.emptySet();
    }

    @Override
    public String getCustomInsertTemplate() {
        return null;
    }

    @Override
    public String getInsertPrefix() {
        StringBuilder template = new StringBuilder();
        template.append(getName());
        return template.toString();

    }

    @Override
    public String getRhsHtml(HtmlFormatter formatter) {
        FileObject file = null;
        if (element != null) {
            file = element.getFileObject();
        }
        if (file != null) {
            formatter.reset();
            formatter.appendText(" ");
            formatter.appendText(file.getName());
        }
        return formatter.getText();
    }

    @Override
    public ElementKind getKind() {
        return ElementKind.CONSTRUCTOR;
    }

    @Override
    public boolean isSmart() {
        return true;
    }

    public static class BladeCompletionItem extends BaseCompletionItem {

        final String previewValue;

        public BladeCompletionItem(ElementHandle element, CompletionRequest request, String previewValue) {
            super(element, request);
            this.previewValue = previewValue;
        }

        @Override
        public String getLhsHtml(HtmlFormatter formatter) {
            formatter.name(getKind(), true);
            formatter.appendHtml("<font>");
            formatter.appendHtml("<b>");
            formatter.appendText(previewValue);
            formatter.appendHtml("</b>");
            formatter.appendHtml("</font>");
            formatter.name(getKind(), false);
            return formatter.getText();
        }
    }

    public static class DirectiveItem extends BaseCompletionItem {

        Directive directive;

        public DirectiveItem(Directive directive, ElementHandle element, CompletionRequest request) {
            super(element, request);
            this.directive = directive;
        }

        @Override
        public ImageIcon getIcon() {
            return ResourceUtilities.loadResourceIcon("icons/at.png");
        }

        @Override
        public String getLhsHtml(HtmlFormatter formatter) {
            formatter.name(getKind(), true);
            formatter.appendHtml("<font>");
            formatter.appendHtml("<b>");
            formatter.appendText(directive.name());
            formatter.appendHtml("</b>");
            formatter.appendHtml("</font>");
            formatter.name(getKind(), false);
            return formatter.getText();
        }
        
        @Override
        public String getCustomInsertTemplate() {
            StringBuilder builder = new StringBuilder();
            
            if (!directive.parameters().isEmpty()){
                builder.append(getName());
                builder.append("(");
                builder.append(directive.parameters());
                builder.append(")");
            }
            
            if (!directive.endtag().isEmpty()){
                builder.append("\n");//after identation utils this can be removed
                builder.append("${cursor}");
                builder.append("\n");
                builder.append(directive.endtag());
            }
            
            if (builder.length() > 0){
                return builder.toString();
            }
            
            return getName();
        }
    }

    public static class PhpElementItem extends BladeCompletionItem {

        public PhpElementItem(ElementHandle element, CompletionRequest request, String previewValue) {
            super(element, request, previewValue);
        }

        @Override
        public String getRhsHtml(HtmlFormatter formatter) {
            FileObject file = null;
            if (this.getElement() != null) {
                file = this.getElement().getFileObject();
            }
            if (file != null) {
                formatter.reset();
                formatter.appendText(" ");
                formatter.appendText(file.getNameExt());
            }
            return formatter.getText();
        }

    }

    public static class NamespaceItem extends PhpElementItem {

        public NamespaceItem(ElementHandle element, CompletionRequest request, String previewValue) {
            super(element, request, previewValue);
        }

        @Override
        public ElementKind getKind() {
            return ElementKind.PACKAGE;
        }

        @Override
        public int getSortPrioOverride() {
            return -50;//priority
        }
    }

    public static class ClassItem extends PhpElementItem {

        public ClassItem(ElementHandle element, CompletionRequest request, String previewValue) {
            super(element, request, previewValue);
        }

        @Override
        public ElementKind getKind() {
            return ElementKind.CLASS;
        }

        @Override
        public int getSortPrioOverride() {
            return 10;//priority
        }
    }

    public static class FunctionItem extends PhpElementItem {

        public FunctionItem(ElementHandle element, CompletionRequest request, String previewValue) {
            super(element, request, previewValue);
        }

        @Override
        public ElementKind getKind() {
            return ElementKind.METHOD;
        }

        @Override
        public int getSortPrioOverride() {
            return 20;//priority
        }
    }

    public static class ConstantItem extends PhpElementItem {

        public ConstantItem(ElementHandle element, CompletionRequest request, String previewValue) {
            super(element, request, previewValue);
        }

        @Override
        public ElementKind getKind() {
            return ElementKind.CONSTANT;
        }

    }

    public static class VariableItem extends BladeCompletionItem {

        public VariableItem(ElementHandle element, CompletionRequest request, String previewValue) {
            super(element, request, previewValue);
        }

        @Override
        public ElementKind getKind() {
            return ElementKind.VARIABLE;
        }

    }

    public static class CompletionRequest {

        public int anchorOffset;
        public int carretOffset;
        public String prefix;
    }
}
