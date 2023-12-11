package org.netbeans.modules.php.blade.editor.ui.customizer;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;


/**
 *
 * @author bhaidu
 */
public class UiOptionsUtils {

    private UiOptionsUtils() {
    }

    
    public static String encodeToStrings(Enumeration<String> list) {
        List<String> result = new ArrayList<>();
        while (list.hasMoreElements()) {
            result.add(list.nextElement());
        }

        return String.join("|", result);
    }
    
    public static DefaultListModel<String> createListModel(Iterator<String> it) {
        DefaultListModel<String> model = new DefaultListModel<>();
        while (it.hasNext()) {
            model.addElement(it.next());
        }
        return model;
    }
}
