package org.netbeans.modules.php.blade.editor.ui.customizer;

import java.awt.Desktop;
import java.awt.EventQueue;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import javax.swing.ListModel;
import javax.swing.event.ChangeListener;
import org.netbeans.api.project.Project;
import org.netbeans.modules.php.blade.editor.directives.CustomDirectives;
import org.netbeans.modules.php.blade.project.BladeProjectProperties;
import org.openide.filesystems.FileChooserBuilder;
import org.openide.filesystems.FileUtil;
import org.openide.util.ChangeSupport;
import org.openide.util.Exceptions;

/**
 *
 * @author bhaidu
 */
public class BladeDirectives extends javax.swing.JPanel {

    private final ChangeSupport changeSupport = new ChangeSupport(this);
    private final Project project;
    BladeProjectProperties bladeProperties;

    /**
     * Creates new form CustomizerIncludePath
     *
     * @param project
     */
    public BladeDirectives(Project project) {
        this.project = project;
        bladeProperties = BladeProjectProperties.getInstance(project);
        initComponents();
        init();
    }

    private void init() {
        //the model reference is enough
        customDirectivePathList.setModel(bladeProperties.getModelForDirectiveCusomizerPathList());
    }

    public void storeData() {
        bladeProperties.storeDirectiveCustomizerPaths();
        CustomDirectives.resetInstance(project);
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
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        org.openide.awt.Mnemonics.setLocalizedText(includePathLabel, org.openide.util.NbBundle.getMessage(BladeDirectives.class, "BladeDirectives.includePathLabel.text_1")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(compilerPathFileButton, org.openide.util.NbBundle.getMessage(BladeDirectives.class, "BladeDirectives.compilerPathFileButton.text_1")); // NOI18N
        compilerPathFileButton.setToolTipText(org.openide.util.NbBundle.getMessage(BladeDirectives.class, "BladeDirectives.compilerPathFileButton.toolTipText_1")); // NOI18N
        compilerPathFileButton.setActionCommand(org.openide.util.NbBundle.getMessage(BladeDirectives.class, "BladeDirectives.compilerPathFileButton.actionCommand_1")); // NOI18N
        compilerPathFileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                compilerPathFileButtonActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(customDirectivePathList);

        org.openide.awt.Mnemonics.setLocalizedText(removePathButton, org.openide.util.NbBundle.getMessage(BladeDirectives.class, "BladeDirectives.removePathButton.text_1")); // NOI18N
        removePathButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removePathButtonActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jLabel1, org.openide.util.NbBundle.getMessage(BladeDirectives.class, "BladeDirectives.jLabel1.text")); // NOI18N

        jLabel3.setForeground(new java.awt.Color(0, 51, 255));
        org.openide.awt.Mnemonics.setLocalizedText(jLabel3, org.openide.util.NbBundle.getMessage(BladeDirectives.class, "BladeDirectives.jLabel3.text")); // NOI18N
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 486, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(compilerPathFileButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(removePathButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(includePathLabel)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel1))))
                        .addGap(0, 306, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(includePathLabel)
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addGap(8, 8, 8)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(compilerPathFileButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(removePathButton)))
                .addGap(0, 50, Short.MAX_VALUE))
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
            //TODO validate the path if it has directives
            bladeProperties.addDirectiveCustomizerPath(FileUtil.normalizeFile(sources).getAbsolutePath());
        }
    }//GEN-LAST:event_compilerPathFileButtonActionPerformed

    private void removePathButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removePathButtonActionPerformed
        int index = customDirectivePathList.getSelectedIndex();
        if (index > -1) {
            bladeProperties.removeCustomizerPath(index);
        }

    }//GEN-LAST:event_removePathButtonActionPerformed

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        try {
            Desktop.getDesktop().browse(new URI("https://laravel.com/docs/10.x/blade#extending-blade"));
        } catch (URISyntaxException | IOException ex) {
            Exceptions.printStackTrace(ex);
        }

    }//GEN-LAST:event_jLabel3MouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton compilerPathFileButton;
    private javax.swing.JList<String> customDirectivePathList;
    private javax.swing.JLabel includePathLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton removePathButton;
    // End of variables declaration//GEN-END:variables
}
