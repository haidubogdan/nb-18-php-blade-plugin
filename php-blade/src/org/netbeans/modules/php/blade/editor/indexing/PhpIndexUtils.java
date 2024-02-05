package org.netbeans.modules.php.blade.editor.indexing;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
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
                    String fullName = sig.string(1);
                    if (fullName.length() > 0 && fullName.startsWith(prefix)) {
                        results.add(new PhpIndexResult(fullName, indexFile, PhpIndexResult.Type.CLASS, new OffsetRange(0, 1)));
                    }
                }
            }
        } catch (IOException ex) {
            Exceptions.printStackTrace(ex);
        }
        return results;
    }

    public static Collection<PhpIndexResult> queryExactClass(FileObject fo, String identifier) {
        QuerySupport phpindex = QuerySupportFactory.get(fo);
        Collection<PhpIndexResult> results = new ArrayList<>();
        String queryPrefix = identifier.toLowerCase();
        try {
            Collection<? extends IndexResult> indexResults = phpindex.query("clz", queryPrefix, QuerySupport.Kind.PREFIX, new String[]{"clz"});
            for (IndexResult indexResult : indexResults) {
                FileObject indexFile = indexResult.getFile();
                //internal php index

                String[] values = indexResult.getValues("clz");
                for (String value : values) {
                    Signature sig = Signature.get(value);
                    String name = sig.string(1);
                    if (name.length() > 0 && name.equals(identifier)) {
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
            Collection<? extends IndexResult> indexResults = phpindex.query(PHPIndexer.FIELD_BASE, queryPrefix, QuerySupport.Kind.PREFIX, new String[]{PHPIndexer.FIELD_BASE});
            for (IndexResult indexResult : indexResults) {
                FileObject indexFile = indexResult.getFile();
                //internal php index

                String[] values = indexResult.getValues(PHPIndexer.FIELD_BASE);
                for (String value : values) {
                    Signature sig = Signature.get(value);
                    String name = sig.string(1);

                    if (name.length() > 0 && name.startsWith(prefix)) {
                        Integer offset = sig.integer(2);
                        String params = sig.string(3);
                        results.add(new PhpIndexFunctionResult(
                                name, indexFile,
                                PhpIndexResult.Type.FUNCTION,
                                new OffsetRange(offset, offset + name.length()),
                                parseParameters(params)        
                                ));
                    }
                }
            }
        } catch (IOException ex) {
            Exceptions.printStackTrace(ex);
        }
        return results;
    }

    static List<String> parseParameters(final String signature) {
        List<String> retval = new ArrayList<>();
        if (signature != null && signature.length() > 0) {
            final String regexp = String.format("\\%s", ","); //NOI18N

            for (String sign : signature.split(regexp)) {
                try {
                    final String param = parseOneParameter(sign);
                    if (param != null) {
                        retval.add(param);
                    }
                } catch (NumberFormatException originalException) {
                    final String message = String.format("%s [for signature: %s]", originalException.getMessage(), signature); //NOI18N
                    final NumberFormatException formatException = new NumberFormatException(message);
                    formatException.initCause(originalException);
                    throw formatException;
                }
            }
        }
        return retval;
    }

    static String parseOneParameter(String sig) {
        String retval = null;
        final String regexp = String.format("\\%s", ":"); //NOI18N
        String[] parts = sig.split(regexp);
        if (parts.length > 0) {
            String paramName = parts[0];
             boolean isRawType = Integer.parseInt(parts[2]) > 0;
            boolean isMandatory = Integer.parseInt(parts[4]) > 0;
            boolean isReference = Integer.parseInt(parts[5]) > 0;
            boolean isVariadic = Integer.parseInt(parts[6]) > 0;
            boolean isUnionType = Integer.parseInt(parts[7]) > 0;
            int modifier = Integer.parseInt(parts[8]);
            boolean isIntersectionType = Integer.parseInt(parts[9]) > 0;
            String defValue = parts.length > 3 ? parts[3] : null;
            String declaredType = parts.length > 10 ? parts[10] : null;
            String phpdocType = parts.length > 11 ? parts[11] : null;
            retval = paramName;
        }
        return retval;
    }

    public static Collection<PhpIndexResult> queryExactFunctions(FileObject fo, String prefix) {
        QuerySupport phpindex = QuerySupportFactory.get(fo);
        Collection<PhpIndexResult> results = new ArrayList<>();
        String queryPrefix = prefix.toLowerCase();
        try {
            Collection<? extends IndexResult> indexResults = phpindex.query(PHPIndexer.FIELD_BASE, queryPrefix, QuerySupport.Kind.PREFIX, new String[]{PHPIndexer.FIELD_BASE});
            for (IndexResult indexResult : indexResults) {
                FileObject indexFile = indexResult.getFile();
                //internal php index

                String[] values = indexResult.getValues(PHPIndexer.FIELD_BASE);
                for (String value : values) {
                    Signature sig = Signature.get(value);
                    String name = sig.string(1);

                    if (name.length() > 0 && name.equals(prefix)) {
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

    public static Collection<PhpIndexResult> queryConstants(FileObject fo, String prefix) {
        QuerySupport phpindex = QuerySupportFactory.get(fo);
        Collection<PhpIndexResult> results = new ArrayList<>();
        String queryPrefix = prefix.toLowerCase();
        try {
            Collection<? extends IndexResult> indexResults = phpindex.query(PHPIndexer.FIELD_CONST, queryPrefix, QuerySupport.Kind.PREFIX, new String[]{PHPIndexer.FIELD_CONST});
            for (IndexResult indexResult : indexResults) {
                FileObject indexFile = indexResult.getFile();
                //internal php index

                String[] values = indexResult.getValues(PHPIndexer.FIELD_CONST);
                for (String value : values) {
                    Signature sig = Signature.get(value);
                    String name = sig.string(1);

                    if (name.length() > 0 && name.equals(prefix)) {
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

    public static Collection<PhpIndexResult> queryExactConstants(FileObject fo, String prefix) {
        QuerySupport phpindex = QuerySupportFactory.get(fo);
        Collection<PhpIndexResult> results = new ArrayList<>();
        String queryPrefix = prefix.toLowerCase();
        try {
            Collection<? extends IndexResult> indexResults = phpindex.query(PHPIndexer.FIELD_CONST, queryPrefix, QuerySupport.Kind.PREFIX, new String[]{PHPIndexer.FIELD_CONST});
            for (IndexResult indexResult : indexResults) {
                FileObject indexFile = indexResult.getFile();
                //internal php index

                String[] values = indexResult.getValues(PHPIndexer.FIELD_CONST);
                for (String value : values) {
                    Signature sig = Signature.get(value);
                    String name = sig.string(1);

                    if (name.length() > 0 && name.equals(prefix)) {
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
