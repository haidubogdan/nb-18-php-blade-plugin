package org.netbeans.modules.php.blade.editor.indexing;

import java.io.IOException;
import java.util.Collection;
import org.netbeans.modules.parsing.spi.indexing.support.IndexResult;
import org.netbeans.modules.parsing.spi.indexing.support.QuerySupport;
import org.netbeans.modules.php.editor.api.QuerySupportFactory;
import org.openide.filesystems.FileObject;
import org.openide.util.Exceptions;

/**
 * this is experimental to be investigated in the future
 *
 * @author bhaidu
 */
public class PhpIndexUtils {

    public static void query(FileObject fo) {
        QuerySupport phpindex = QuerySupportFactory.get(fo);
        {
            try {
                Collection<? extends IndexResult> indexResults = phpindex.query("method", "render", QuerySupport.Kind.PREFIX, new String[]{"method"});
                for (IndexResult indexResult : indexResults) {
                    FileObject indexFile = indexResult.getFile();
                    //internal php index
                    if (indexFile.getClass().getSimpleName().equals("AbstractFileObject")) {
                        continue;
                    }
                    //                          String[] values = indexResult.getValues("method");
                    int w = 1;
                }
                int y = 1;
            } catch (IOException ex) {
                Exceptions.printStackTrace(ex);
            }
        }
        int x = 1;
    }
}
