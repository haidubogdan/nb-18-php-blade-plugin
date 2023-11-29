package org.netbeans.modules.php.blade.editor.typinghooks;

import javax.swing.text.BadLocationException;
import org.netbeans.api.editor.mimelookup.MimePath;
import org.netbeans.api.editor.mimelookup.MimeRegistration;
import org.netbeans.api.editor.mimelookup.MimeRegistrations;
import org.netbeans.modules.php.blade.editor.BladeLanguage;
import org.netbeans.spi.editor.typinghooks.TypedBreakInterceptor;

/**
 *
 * @author bhaidu
 */
public class BladetTypedBreakInterceptor implements TypedBreakInterceptor {

    @Override
    public boolean beforeInsert(Context cntxt) throws BadLocationException {
        return false;
    }

    @Override
    public void insert(MutableContext mc) throws BadLocationException {
        
    }

    @Override
    public void afterInsert(Context cntxt) throws BadLocationException {
        
    }

    @Override
    public void cancelled(Context cntxt) {
        int x = 1;
    }

    @MimeRegistrations({
        @MimeRegistration(mimeType = BladeLanguage.MIME_TYPE, service = TypedBreakInterceptor.Factory.class),
        @MimeRegistration(mimeType = "text/x-php5", service = TypedBreakInterceptor.Factory.class),
    })
    public static class BladeFactory implements TypedBreakInterceptor.Factory {

        @Override
        public TypedBreakInterceptor createTypedBreakInterceptor(MimePath mimePath) {
            return new BladetTypedBreakInterceptor();
        }
    }

    @MimeRegistrations({
        @MimeRegistration(mimeType = BladeLanguage.MIME_TYPE, service = TypedBreakInterceptor.Factory.class),
        @MimeRegistration(mimeType = "text/x-php5", service = TypedBreakInterceptor.Factory.class),
    })
    public static class BladeTypedFactory implements TypedBreakInterceptor.Factory {

        @Override
        public TypedBreakInterceptor createTypedBreakInterceptor(MimePath mimePath) {
            return new BladetTypedBreakInterceptor();
        }
    }
}
