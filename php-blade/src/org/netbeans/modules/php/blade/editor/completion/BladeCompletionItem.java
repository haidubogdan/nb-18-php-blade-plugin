/*
Licensed to the Apache Software Foundation (ASF)
 */
package org.netbeans.modules.php.blade.editor.completion;

import java.util.Collections;
import java.util.Set;
import javax.swing.ImageIcon;
import org.netbeans.api.editor.EditorRegistry;
import org.netbeans.api.project.Project;
import org.netbeans.modules.csl.api.CompletionProposal;
import org.netbeans.modules.csl.api.ElementHandle;
import org.netbeans.modules.csl.api.ElementKind;
import org.netbeans.modules.csl.api.HtmlFormatter;
import org.netbeans.modules.csl.api.Modifier;

import org.openide.filesystems.FileObject;
import org.openide.util.ImageUtilities;

/**
 *
 * @author bogdan
 */
public class BladeCompletionItem implements CompletionProposal {

    private static final String ICON_BASE = "org/netbeans/modules/php/blade/resources/";
    //@StaticResource
    final CompletionRequest request;
    private final ElementHandle element;
    final String previewValue;

    BladeCompletionItem(ElementHandle element, CompletionRequest request, String previewValue) {
        this.element = element;
        this.request = request;
        this.previewValue = previewValue;
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

    public static class ClassItem extends BladeCompletionItem {

        public ClassItem(ElementHandle element, CompletionRequest request, String previewValue) {
            super(element, request, previewValue);
        }

        @Override
        public ElementKind getKind() {
            return ElementKind.CLASS;
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

    public static class FunctionItem extends BladeCompletionItem {

        public FunctionItem(ElementHandle element, CompletionRequest request, String previewValue) {
            super(element, request, previewValue);
        }

        @Override
        public ElementKind getKind() {
            return ElementKind.METHOD;
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
