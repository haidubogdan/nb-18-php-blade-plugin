package org.netbeans.modules.php.blade.editor.completion;

import java.util.HashMap;

/**
 *
 * @author bhaidu
 */
public class BladeCompletionService {

    private static HashMap<String, HashMap> yamlCompletionConfig;


    public static HashMap<String, HashMap> getDirectiveCompletionList() {

        if (yamlCompletionConfig == null) {
            yamlCompletionConfig = CompletionConfig.getConfigMapping("directives_list.yml");
        }

        return yamlCompletionConfig;
    }
}
