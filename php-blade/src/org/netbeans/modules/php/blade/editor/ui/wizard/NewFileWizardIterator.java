package org.netbeans.modules.php.blade.editor.ui.wizard;

import java.awt.Component;
import java.io.IOException;
import java.util.Collections;
import java.util.Set;
import javax.swing.JPanel;
import javax.swing.event.ChangeListener;
import org.netbeans.api.project.Project;
import org.netbeans.api.project.ProjectUtils;
import org.netbeans.api.project.SourceGroup;
import org.netbeans.api.project.Sources;
import org.netbeans.api.templates.TemplateRegistration;
import org.openide.WizardDescriptor;
import org.openide.filesystems.FileObject;
import org.openide.loaders.DataFolder;
import org.netbeans.spi.project.ui.templates.support.Templates;
import org.openide.loaders.DataObject;
import org.openide.util.HelpCtx;

/**
 *
 * @author bhaidu
 */
public class NewFileWizardIterator implements WizardDescriptor.InstantiatingIterator<WizardDescriptor> {

    WizardDescriptor wizard;
    private WizardDescriptor.Panel<WizardDescriptor> wizardPanel;
    // used in a background thread in instantiate() method
    private volatile BottomPanel bottomPanel;

    private NewFileWizardIterator() {

    }

    @TemplateRegistration(folder = "Blade", category = "PHP",
            content = "../../../resources/emptyBladeFile.blade.php",
            description = "../../../resources/NewBladeFileDescription.html",
            position = 120,
            displayName = "Blade file",
            scriptEngine = "freemarker")
    public static WizardDescriptor.InstantiatingIterator<WizardDescriptor> createBladeWizardIterator() {
        return new NewFileWizardIterator();
    }

    @Override
    public Set<FileObject> instantiate() throws IOException {
        getBottomPanel().save();

        FileObject dir = Templates.getTargetFolder(wizard);
        FileObject template = Templates.getTemplate(wizard);

        DataFolder dataFolder = DataFolder.findFolder(dir);
        DataObject dataTemplate = DataObject.find(template);
        DataObject createdFile = dataTemplate.createFromTemplate(dataFolder, Templates.getTargetName(wizard) + ".blade");
        return Collections.singleton(createdFile.getPrimaryFile());
    }

    @Override
    public void initialize(WizardDescriptor wizard) {
        this.wizard = wizard;
        Templates.setTargetName(wizard, "myfile");
        wizardPanel = createWizardPanel();
    }

    @Override
    public void uninitialize(WizardDescriptor wizard) {
        this.wizard = null;
        wizardPanel = null;
        bottomPanel = null;
    }

    @Override
    public WizardDescriptor.Panel<WizardDescriptor> current() {
        return wizardPanel;
    }

    @Override
    public String name() {
        return ""; // NOI18N
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public boolean hasPrevious() {
        return false;
    }

    @Override
    public void nextPanel() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void previousPanel() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void addChangeListener(ChangeListener listener) {
        getBottomPanel().addChangeListener(listener);
    }

    @Override
    public void removeChangeListener(ChangeListener listener) {
        getBottomPanel().removeChangeListener(listener);
    }

    private BottomPanel getBottomPanel() {
        if (bottomPanel != null) {
            return bottomPanel;
        }

        bottomPanel = BottomPanel.EMPTY;

        return bottomPanel;
    }

    private WizardDescriptor.Panel<WizardDescriptor> createWizardPanel() {
        Project project = getProject();
        assert project != null;
        // #233484
        //ensureProperTargetFolder(project);
        return Templates.buildSimpleTargetChooser(project, getSourceGroups(project))
                .bottomPanel(getBottomPanel())
                .create();
    }

    private SourceGroup[] getSourceGroups(Project project) {
        Sources sources = ProjectUtils.getSources(project);
        return sources.getSourceGroups(Sources.TYPE_GENERIC);
    }

    private Project getProject() {
        return Templates.getProject(wizard);
    }

    private interface BottomPanel extends WizardDescriptor.Panel<WizardDescriptor> {

        BottomPanel EMPTY = new EmptyBottomPanel();

        void save() throws IOException;
    }

    private static final class EmptyBottomPanel implements BottomPanel {

        @Override
        public Component getComponent() {
            return new JPanel();
        }

        @Override
        public HelpCtx getHelp() {
            return null;
        }

        @Override
        public void readSettings(WizardDescriptor settings) {
        }

        @Override
        public void storeSettings(WizardDescriptor settings) {
        }

        @Override
        public boolean isValid() {
            return true;
        }

        @Override
        public void addChangeListener(ChangeListener l) {
        }

        @Override
        public void removeChangeListener(ChangeListener l) {
        }

        @Override
        public void save() throws IOException {
        }

    }

}
