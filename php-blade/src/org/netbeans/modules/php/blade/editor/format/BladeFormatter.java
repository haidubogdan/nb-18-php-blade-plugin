package org.netbeans.modules.php.blade.editor.format;

import org.netbeans.modules.php.blade.editor.format.BladeFormatterService;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.prefs.Preferences;
import javax.swing.SwingUtilities;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import org.netbeans.modules.csl.api.Formatter;
import org.netbeans.modules.csl.spi.ParserResult;
import org.netbeans.modules.editor.indent.spi.Context;

import org.netbeans.api.editor.document.LineDocument;
import org.netbeans.api.editor.document.LineDocumentUtils;
import org.netbeans.api.editor.settings.SimpleValueNames;
import org.netbeans.modules.editor.indent.spi.CodeStylePreferences;
import org.netbeans.modules.php.blade.editor.format.BladeIndentationService;

/**
 * possible strategies
 *
 * separate the WS identation of HTML and DIRECTIVES
 *
 * build the identation on parser listener ??
 */
/**
 *
 * @author bhaidu
 */
public class BladeFormatter implements Formatter {

    private static final Logger LOGGER = Logger.getLogger(BladeFormatter.class.getName());

    public BladeFormatter() {
    }

    @Override
    public void reformat(Context context, ParserResult compilationInfo) {

        LineDocument doc = LineDocumentUtils.as(context.document(), LineDocument.class);
        if (doc == null) {
            return;
        }
        int indentSize = getIndentSize(context.document());

        long start = System.currentTimeMillis();
        Runnable rn = new Runnable() {
            @Override
            public void run() {
                //the text can update between reformatting
                LineDocument doc = LineDocumentUtils.as(context.document(), LineDocument.class);
                if (doc == null) {
                    return;
                }
                try {
                    String currentText = doc.getText(0, doc.getLength());
                    if (context.isIndent()) {
                        (new BladeIndentationService()).format(context, currentText, indentSize);
                    } else {
                        (new BladeFormatterService()).format(context, currentText, indentSize);
                    }
                } catch (BadLocationException ex) {
                }

                //TODO
                //move to service
                //have two usecases context.isIndent() and format triggered
            }

        };

        //run after html indent is finished
        SwingUtilities.invokeLater(rn);
        if (LOGGER.isLoggable(Level.FINE)) {
            long end = System.currentTimeMillis();
            LOGGER.log(Level.FINE, "Reformat took: {0} ms", (end - start)); //NOI18N
        }
    }

    @Override
    public void reindent(Context context) {
        reformat(context, null);
    }

    @Override
    public boolean needsParserResult() {
        return false;
    }

    @Override
    public int indentSize() {
        return 4;
    }

    @Override
    public int hangingIndentSize() {
        return 4;
    }

    static int getIndentSize(Document doc) {
        Preferences prefs = CodeStylePreferences.get(doc).getPreferences();
        return prefs.getInt(SimpleValueNames.INDENT_SHIFT_WIDTH, 4);
    }

}