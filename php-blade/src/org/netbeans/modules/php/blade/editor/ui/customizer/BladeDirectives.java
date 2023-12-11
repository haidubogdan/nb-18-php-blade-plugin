package org.netbeans.modules.php.blade.editor.ui.customizer;

import java.awt.EventQueue;
import java.io.File;
import javax.swing.DefaultListModel;
import javax.swing.event.ChangeListener;
import org.netbeans.api.project.Project;
import org.netbeans.modules.php.blade.project.BladeProjectProperties;
import org.netbeans.modules.php.blade.project.CustomDirectives;
import org.openide.filesystems.FileChooserBuilder;
import org.openide.filesystems.FileUtil;
import org.openide.util.ChangeSupport;

/**
 *
 * @author bhaidu
 */
public class BladeDirectives extends javax.swing.JPanel {
    
    private final ChangeSupport changeSupport = new ChangeSupport(this);
    private final Project project;
    /**
     * Creates new form CustomizerIncludePath
     */
    public BladeDirectives(Project project) {
        this.project = project;
        initComponents();
        init();
    }
    
    private void init(){
    }
         
    public void storeData(){
        DefaultListModel pathModel = (DefaultListModel) customDirectivePathList.getModel();
        BladeProjectProperties.getInstance(project).setCompilerPathList(pathModel);
    }
    
    public void addChangeListener(ChangeListener listener) {
        changeSupport.addChangeListener(listener);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        includePathLabel = new javax.swing.JLabel();
        compilerPathFileButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        customDirectivePathList = new javax.swing.JList<>();
        removePathButton = new javax.swing.JButton();

        org.openide.awt.Mnemonics.setLocalizedText(includePathLabel, org.openide.util.NbBundle.getMessage(BladeDirectives.class, "BladeDirectives.includePathLabel.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(compilerPathFileButton, org.openide.util.NbBundle.getMessage(BladeDirectives.class, "BladeDirectives.compilerPathFileButton.text")); // NOI18N
        compilerPathFileButton.setToolTipText(org.openide.util.NbBundle.getMessage(BladeDirectives.class, "BladeDirectives.compilerPathFileButton.toolTipText")); // NOI18N
        compilerPathFileButton.setActionCommand(org.openide.util.NbBundle.getMessage(BladeDirectives.class, "BladeDirectives.compilerPathFileButton.actionCommand")); // NOI18N
        compilerPathFileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                compilerPathFileButtonActionPerformed(evt);
            }
        });

        customDirectivePathList.setModel(org.netbeans.modules.php.blade.project.BladeProjectProperties.getInstance(project).getModelCompilerPathList());
        jScrollPane1.setViewportView(customDirectivePathList);

        org.openide.awt.Mnemonics.setLocalizedText(removePathButton, org.openide.util.NbBundle.getMessage(BladeDirectives.class, "BladeDirectives.removePathButton.text")); // NOI18N
        removePathButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removePathButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(includePathLabel)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(compilerPathFileButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(removePathButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(includePathLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(compilerPathFileButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(removePathButton))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 110, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void compilerPathFileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_compilerPathFileButtonActionPerformed
        assert EventQueue.isDispatchThread();
        File sources = new FileChooserBuilder(BladeDirectives.class)
                .setFilesOnly(true)
                .setTitle("Select compiler File Path")
                .setDefaultWorkingDirectory(FileUtil.toFile(project.getProjectDirectory()))
                .forceUseOfDefaultWorkingDirectory(true)
                .showOpenDialog();
        if (sources != null) {
            DefaultListModel pathModel = (DefaultListModel) customDirectivePathList.getModel();
            //TODO validate the path if it has directives
            pathModel.addElement(FileUtil.normalizeFile(sources).getAbsolutePath());
        }
    }//GEN-LAST:event_compilerPathFileButtonActionPerformed

    private void removePathButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removePathButtonActionPerformed
        int index = customDirectivePathList.getSelectedIndex();
        if (index > -1) {
            DefaultListModel pathModel = (DefaultListModel) customDirectivePathList.getModel();
            pathModel.remove(index);
        }
        
    }//GEN-LAST:event_removePathButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton compilerPathFileButton;
    private javax.swing.JList<String> customDirectivePathList;
    private javax.swing.JLabel includePathLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton removePathButton;
    // End of variables declaration//GEN-END:variables
}
