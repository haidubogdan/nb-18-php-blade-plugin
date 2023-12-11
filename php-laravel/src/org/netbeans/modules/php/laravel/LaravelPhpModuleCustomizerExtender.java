/*
Licensed to the Apache Software Foundation (ASF)
 */
package org.netbeans.modules.php.laravel;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.EnumSet;
import java.util.Map;
import javax.swing.JComponent;
import javax.swing.event.ChangeListener;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.netbeans.modules.php.api.phpmodule.PhpModule;
import org.netbeans.modules.php.laravel.ui.customizer.LaravelCustomizerPanel;
import org.netbeans.modules.php.spi.framework.PhpModuleCustomizerExtender;
import org.openide.filesystems.FileObject;
import org.openide.util.HelpCtx;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.netbeans.modules.php.laravel.project.ComposerPackages;
import org.openide.util.Exceptions;

/**
 *
 * @author bogdan
 */
public class LaravelPhpModuleCustomizerExtender extends PhpModuleCustomizerExtender {

    private final PhpModule phpModule;
    private final boolean originalEnabled;
    private ComposerPackages composerPackages;

    // @GuardedBy(EDT)
    private LaravelCustomizerPanel component;
    
    LaravelPhpModuleCustomizerExtender(PhpModule phpModule) {
        this.phpModule = phpModule;
        composerPackages = ComposerPackages.fromPhpModule(phpModule);
        originalEnabled = LaravelPhpFrameworkProvider.getInstance().isInPhpModule(phpModule);
    }

    @Override
    public String getDisplayName() {
        return "Laravel";
    }

    private LaravelCustomizerPanel getPanel() {
        if (component == null) {
            component = new LaravelCustomizerPanel(phpModule.getSourceDirectory());
            component.setLaravelVersion(composerPackages.getLaravelVersion());
        }
        return component;
    }
    
    @Override
    public void addChangeListener(ChangeListener listener) {
        getPanel().addChangeListener(listener);
    }

    @Override
    public void removeChangeListener(ChangeListener listener) {
        getPanel().removeChangeListener(listener);
    }

    @Override
    public JComponent getComponent() {
        return getPanel();
    }

    @Override
    public HelpCtx getHelp() {
        return null;
    }

    @Override
    public boolean isValid() {
        return true;
    }

    @Override
    public String getErrorMessage() {
        return null;
    }

    @Override
    public EnumSet<Change> save(PhpModule pm) {
        return null;
    }

}
