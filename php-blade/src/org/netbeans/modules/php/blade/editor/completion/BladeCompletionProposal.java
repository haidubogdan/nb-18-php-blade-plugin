package org.netbeans.modules.php.blade.editor.completion;

import java.util.Collections;
import java.util.Set;
import javax.swing.ImageIcon;
import org.netbeans.modules.csl.api.CompletionProposal;
import org.netbeans.modules.csl.api.ElementHandle;
import org.netbeans.modules.csl.api.ElementKind;
import org.netbeans.modules.csl.api.HtmlFormatter;
import org.netbeans.modules.csl.api.Modifier;
import org.netbeans.modules.php.blade.csl.elements.CompletionElement;
import org.openide.filesystems.FileObject;
import org.openide.util.*;

/**
 *
 * @author bhaidu
 */
public class BladeCompletionProposal implements CompletionProposal {

    private static final String ICON_BASE = "org/netbeans/modules/php/blade/resources/";
    //@StaticResource
    private final CompletionElement element;
    final String previewValue;
    private final int offset;

    public BladeCompletionProposal(CompletionElement element, String previewValue, int offset) {
        this.element = element;
        this.previewValue = previewValue;
        this.offset = offset;
    }

    @Override
    public int getAnchorOffset() {
        return offset;
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
        return ImageUtilities.loadImageIcon(ICON_BASE + "icons/at.png", false);
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
        return null;
    }

    @Override
    public ElementKind getKind() {
        return ElementKind.CONSTRUCTOR;
    }

    @Override
    public boolean isSmart() {
        return true;
    }

    /**
     * completion item for blade output statements
     * it will but the cursor in the middle of the tags
     * 
     * {{ }} escaped echo
     * {!! !!} raw echo
     * {{-- --}} comment
     */
    public static class OutputCompletionItem extends BladeCompletionProposal {

        private final String closeTag;

        public OutputCompletionItem(CompletionElement element, String previewValue, int offset,String closeTag) {
            super(element, previewValue, offset);
            this.closeTag = closeTag;
        }

        @Override
        public String getCustomInsertTemplate() {
            StringBuilder builder = new StringBuilder();
            builder.append(" ${cursor} ");
            builder.append(this.closeTag);
            return builder.toString();
        }
    }
}
