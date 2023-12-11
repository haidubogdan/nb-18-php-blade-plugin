/*
Licensed to the Apache Software Foundation (ASF)
 */
package org.netbeans.modules.php.laravel.project;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.netbeans.modules.php.api.phpmodule.PhpModule;
import org.openide.filesystems.FileObject;
import org.openide.util.Exceptions;

/**
 *
 * @author bogdan
 */
public class ComposerPackages {

    private final PhpModule phpModule;
    private static ComposerPackages INSTANCE = null;
    private Map<String, Object> composerJsonContent = new HashMap<>();

    private ComposerPackages(PhpModule phpModule) {
        this.phpModule = phpModule;
        this.extractPackageInfo();
    }

    private void extractPackageInfo() {
        FileObject composerJsonFile = phpModule.getSourceDirectory().getFileObject("composer.json");

        if (composerJsonFile == null) {
            return;
        }

        JSONParser parser = new JSONParser();

        try {
            composerJsonContent = (Map<String, Object>) parser.parse(new FileReader(composerJsonFile.getPath()));
        } catch (FileNotFoundException ex) {
            Exceptions.printStackTrace(ex);
        } catch (IOException | ParseException ex) {
            Exceptions.printStackTrace(ex);
        }
    }

    public Map<String, Object> getcomposerJsonContent() {
        return composerJsonContent;
    }

    public String getLaravelVersion() {
        Map<String, Object> require = (Map<String, Object>) composerJsonContent.get("require");
        String laravelVersion = (String) require.get("laravel/framework");
        return laravelVersion;
    }

    public static ComposerPackages fromPhpModule(PhpModule phpModule) {
        INSTANCE = new ComposerPackages(phpModule);
        return INSTANCE;
    }

    public static ComposerPackages getInstance() {
        return INSTANCE;
    }
}
