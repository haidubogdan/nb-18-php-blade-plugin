package org.netbeans.modules.php.blade.editor.indexing;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.netbeans.api.editor.mimelookup.MimeRegistration;
import org.netbeans.api.project.Project;
import org.netbeans.modules.csl.api.OffsetRange;
import org.netbeans.modules.parsing.api.Snapshot;
import org.netbeans.modules.parsing.spi.Parser;
import org.netbeans.modules.parsing.spi.indexing.Context;
import org.netbeans.modules.parsing.spi.indexing.EmbeddingIndexer;
import org.netbeans.modules.parsing.spi.indexing.EmbeddingIndexerFactory;
import org.netbeans.modules.parsing.spi.indexing.Indexable;
import org.netbeans.modules.parsing.spi.indexing.support.IndexingSupport;
import org.netbeans.modules.parsing.spi.indexing.support.IndexDocument;
import org.netbeans.modules.php.blade.editor.BladeLanguage;
import org.netbeans.modules.php.blade.editor.parser.BladeParserResult;
import org.netbeans.modules.php.blade.editor.parser.BladeParserResult.Reference;
import org.netbeans.modules.php.blade.editor.parser.BladeParserResult.ReferenceType;
import org.netbeans.modules.php.blade.editor.path.PathUtils;
import org.netbeans.modules.php.blade.project.ProjectUtils;
import org.openide.filesystems.FileObject;
import org.openide.util.Exceptions;

/**
 * move to language EmbeddingIndexerFactory getIndexerFactory ?
 *
 * @author bhaidu
 */
public class BladeIndexer extends EmbeddingIndexer {

    private static final Logger LOGGER = Logger.getLogger(BladeIndexer.class.getSimpleName());
    public static final String BLADE_INDEXED = "indexed"; //NOI18N
    public static final String YIELD_REFERENCE = "yield"; //NOI18N
    public static final String YIELD_ID = "yieldid"; //NOI18N
    public static final String STACK_REFERENCE = "stack"; //NOI18N
    public static final String STACK_ID = "stackid"; //NOI18N
    public static final String INCLUDE_PATH = "include"; //NOI18N
    public static final String BLADE_PATH = "path"; //NOI18N

    @Override
    protected void index(Indexable indxbl, Parser.Result result, Context context) {
        BladeParserResult parserResult;
        if (result instanceof BladeParserResult) {
            parserResult = (BladeParserResult) result;
        } else {
            return;
        }

        //we have errors
        if (!parserResult.getDiagnostics().isEmpty()) {
            return;
        }

        try {
            IndexingSupport support = IndexingSupport.getInstance(context);
            // we need to remove old documents (document per object, not file)
            support.removeDocuments(indxbl);
            IndexDocument document = support.createDocument(indxbl);

            if (!parserResult.getYieldReferences().isEmpty()) {
                storeYieldReferences(parserResult.getYieldReferences(), document);
            }

            if (!parserResult.getStackReferences().isEmpty()) {
                storeStackReferences(parserResult.getStackReferences(), document);
            }

            if (!parserResult.includeBladeOccurences.isEmpty()) {
                storeIncludePathReferences(parserResult.includeBladeOccurences, document);
            }

            storeFilePathAsBladePath(parserResult.getSnapshot().getSource().getFileObject(), document);

            document.addPair(BLADE_INDEXED, Boolean.TRUE.toString(), true, true);

            support.addDocument(document);
        } catch (IOException ex) {
            LOGGER.log(Level.WARNING, null, ex);
            Exceptions.printStackTrace(ex);
        } catch (Exception ex) {
            Exceptions.printStackTrace(ex);
        }
    }

    private void storeYieldReferences(Map<String, Reference> yields, IndexDocument document) {

        for (Map.Entry<String, Reference> entry : yields.entrySet()) {
            StringBuilder sb = new StringBuilder();
            Reference ref = entry.getValue();
            //used for completion
            document.addPair(YIELD_ID, entry.getKey(), true, true);
            sb.append(entry.getKey()).append("#").append(ref.defOffset.getStart()).append(";").append(ref.defOffset.getEnd()); //NOI18N
            //used for declaration finder
            document.addPair(YIELD_REFERENCE, sb.toString(), true, true);
        }
    }

    private void storeStackReferences(Map<String, Reference> stacks, IndexDocument document) {

        for (Map.Entry<String, Reference> entry : stacks.entrySet()) {
            StringBuilder sb = new StringBuilder();
            Reference ref = entry.getValue();
            //used for completion
            document.addPair(STACK_ID, entry.getKey(), true, true);
            //do we need end ??
            sb.append(entry.getKey()).append("#").append(ref.defOffset.getStart()).append(";").append(ref.defOffset.getEnd()); //NOI18N
            //used for declaration finder
            document.addPair(STACK_REFERENCE, sb.toString(), true, true);
        }
    }

    private void storeFilePathAsBladePath(FileObject fo, IndexDocument document) {
        Project project = ProjectUtils.getMainOwner(fo);
        if (project == null) {
            return;
        }
        List<FileObject> roots = PathUtils.getCustomViewsRoots(project, fo);
        String filePath = fo.getPath();

        for (FileObject root : roots) {
            String rootPath = root.getPath();
            if (filePath.startsWith(rootPath)) {
                String bladeFormatPath = filePath.replace(rootPath, "").replace(".blade.php", "").replace("/", ".");
                if (bladeFormatPath.startsWith(".")) {
                    bladeFormatPath = bladeFormatPath.substring(1, bladeFormatPath.length());
                }
                document.addPair(BLADE_PATH, bladeFormatPath, true, true);
            }
        }
    }

    public static Reference extractYieldDataFromIndex(String index) {
        String[] mainElements = index.split("#");

        if (mainElements.length == 0) {
            return null;
        }

        String name = mainElements[0];
        String offsets[] = mainElements[1].split(";");
        int start = 0;
        int end = 1;

        if (offsets.length > 0) {
            start = Integer.parseInt(offsets[0]);
            end = Integer.parseInt(offsets[1]);
        }

        return new Reference(ReferenceType.YIELD, name, new OffsetRange(start, end));
    }
    
    public static Reference extractTemplatePathDataFromIndex(String indexInfo) {
        String[] mainElements = indexInfo.split("#");

        if (mainElements.length == 0) {
            return null;
        }

        String name = mainElements[0];
        String offsets[] = mainElements[1].split(";");
        int start = 0;
        int end = 1;

        if (offsets.length > 0) {
            start = Integer.parseInt(offsets[0]);
            end = start + name.length();
        }

        return new Reference(ReferenceType.TEMPLATE_PATH, name, new OffsetRange(start, end));
    }

    private void storeIncludePathReferences(Map<String, List<OffsetRange>> includes, IndexDocument document) {
        for (Map.Entry<String, List<OffsetRange>> entry : includes.entrySet()) {
            StringBuilder sb = new StringBuilder();

            sb.append(entry.getKey()).append("#");
            for (OffsetRange range : entry.getValue()){
                sb.append(range.getStart()); //NOI18N
                sb.append(";");//NOI18N
            }

            document.addPair(INCLUDE_PATH, sb.toString(), true, true);
        }
    }

    @MimeRegistration(mimeType = BladeLanguage.MIME_TYPE, service = EmbeddingIndexerFactory.class) //NOI18N
    public static class Factory extends EmbeddingIndexerFactory {

        public static final String NAME = "blade"; //NOI18N
        public static final int VERSION = 2;

        @Override
        public EmbeddingIndexer createIndexer(Indexable indxbl, Snapshot snapshot) {
            if (isIndexable(snapshot)) {
                return new BladeIndexer();
            } else {
                return null;
            }
        }

        @Override
        public void filesDeleted(Iterable<? extends Indexable> deleted, Context context) {
            try {
                IndexingSupport is = IndexingSupport.getInstance(context);
                for (Indexable i : deleted) {
                    is.removeDocuments(i);
                }
            } catch (IOException ioe) {
                LOGGER.log(Level.WARNING, null, ioe);
            }
        }

        @Override
        public void filesDirty(Iterable<? extends Indexable> dirty, org.netbeans.modules.parsing.spi.indexing.Context context) {
            try {
                IndexingSupport is = IndexingSupport.getInstance(context);
                for (Indexable i : dirty) {
                    is.markDirtyDocuments(i);
                }
            } catch (IOException ioe) {
                LOGGER.log(Level.WARNING, null, ioe);
            }
        }

        @Override
        public String getIndexerName() {
            return NAME;
        }

        @Override
        public int getIndexVersion() {
            return VERSION;
        }

        private boolean isIndexable(Snapshot snapshot) {
            return BladeLanguage.MIME_TYPE.equals(snapshot.getMimeType());
        }
    }

}
