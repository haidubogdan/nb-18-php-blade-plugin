/*
Licensed to the Apache Software Foundation (ASF)
 */
package org.netbeans.modules.php.blade.editor.completion;

import org.netbeans.modules.csl.api.Documentation;
import org.netbeans.modules.php.blade.csl.elements.NamedElement;

/**
 * @TODO update doc representation
 * 
 * @author bogdan
 */
public class TooltipDoc {

    public static Documentation generateDoc(NamedElement elementHandle) {
        Documentation result = null;
        switch (elementHandle.getType()) {
            case PATH:
                return Documentation.create(String.format("<div align=\"right\"><font size=-1>%s</font></div>", "blade path"), null);
            case CUSTOM_DIRECTIVE:
                String docInfo = String.format("<div align=\"right\"><font size=-1>%s</font></div>", "custom directive")
                        + "<div>" + elementHandle.getFileObject().getNameExt() + "</div>";
                return Documentation.create(docInfo, null);
        }

        return result;
    }
}
