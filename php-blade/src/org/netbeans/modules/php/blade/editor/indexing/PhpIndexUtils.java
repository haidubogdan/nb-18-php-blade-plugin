package org.netbeans.modules.php.blade.editor.indexing;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import org.netbeans.modules.csl.api.OffsetRange;
import org.netbeans.modules.parsing.spi.indexing.support.IndexResult;
import org.netbeans.modules.parsing.spi.indexing.support.QuerySupport;
import org.netbeans.modules.php.editor.api.QuerySupportFactory;
import org.netbeans.modules.php.editor.index.PHPIndexer;
import org.netbeans.modules.php.editor.index.Signature;
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

    /**
     * @todo implement a parser for php elements
     * 
     * @param fo
     * @param prefix
     * @return 
     */
    public static Collection<PhpIndexResult> queryClass(FileObject fo, String prefix) {
        QuerySupport phpindex = QuerySupportFactory.get(fo);
        Collection<PhpIndexResult> results = new ArrayList<>();
        String queryPrefix = prefix.toLowerCase();
        try {
            Collection<? extends IndexResult> indexResults = phpindex.query("clz", queryPrefix, QuerySupport.Kind.PREFIX, new String[]{"clz"});
            for (IndexResult indexResult : indexResults) {
                FileObject indexFile = indexResult.getFile();
                //internal php index

                String[] values = indexResult.getValues("clz");
                for (String value : values) {
                    Signature sig = Signature.get(value);
                    String name = sig.string(1);
                    if (name.length() > 0 && name.startsWith(prefix)) {
                        results.add(new PhpIndexResult(name, indexFile, PhpIndexResult.Type.CLASS, new OffsetRange(0, 1)));
                    }
                }
            }
        } catch (IOException ex) {
            Exceptions.printStackTrace(ex);
        }
        return results;
    }
    
    public static Collection<PhpIndexResult> queryFunctions(FileObject fo, String prefix) {
        QuerySupport phpindex = QuerySupportFactory.get(fo);
        Collection<PhpIndexResult> results = new ArrayList<>();
        String queryPrefix = prefix.toLowerCase();
        try {
            Collection<? extends IndexResult> indexResults = phpindex.query(PHPIndexer.FIELD_BASE, queryPrefix, QuerySupport.Kind.PREFIX, new String[]{PHPIndexer.FIELD_BASE });
            for (IndexResult indexResult : indexResults) {
                FileObject indexFile = indexResult.getFile();
                //internal php index

                String[] values = indexResult.getValues(PHPIndexer.FIELD_BASE );
                for (String value : values) {
                    Signature sig = Signature.get(value);
                    String name = sig.string(1);
                    
                    if (name.length() > 0 && name.startsWith(prefix)) {
                        Integer offset = sig.integer(2);
                        results.add(new PhpIndexResult(name, indexFile, PhpIndexResult.Type.FUNCTION, new OffsetRange(offset, offset + name.length())));
                    }
                }
            }
        } catch (IOException ex) {
            Exceptions.printStackTrace(ex);
        }
        return results;
    }
}
