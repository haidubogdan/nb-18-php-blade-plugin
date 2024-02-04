package org.netbeans.modules.php.blade.editor.actions;

import java.awt.event.ActionEvent;
import javax.swing.text.JTextComponent;
import org.netbeans.editor.BaseAction;
import org.netbeans.modules.php.blade.editor.refactoring.SymbolInformation;
import org.netbeans.modules.php.blade.editor.refactoring.WhereUsedRefactoringUIImpl;
import org.netbeans.modules.refactoring.spi.ui.UI;
import org.openide.awt.ActionID;
import org.openide.awt.ActionRegistration;
import org.openide.filesystems.FileObject;
import org.openide.nodes.Node;
import org.openide.windows.TopComponent;

/**
 *
 * @author bogdan
 */
@ActionID(id = "org.netbeans.modules.php.blade.editor.actions.FindUsage", category = "TemplateActions")
@ActionRegistration(displayName = "Find Usage")
public class FindUsage extends BaseAction {

    Node node;

    public FindUsage(Node node) {
        this.node = node;
    }

    @Override
    public void actionPerformed(ActionEvent ae, JTextComponent jtc) {
        FileObject fo = node.getLookup().lookup(FileObject.class);
        SymbolInformation si = new SymbolInformation(fo, fo.getName());
        UI.openRefactoringUI(new WhereUsedRefactoringUIImpl(si),
                TopComponent.getRegistry().getActivated());
    }

}
