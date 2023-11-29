package org.netbeans.modules.php.blade.editor.indexing;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutionException;
import org.netbeans.api.project.Project;
import org.netbeans.api.project.ui.OpenProjects;
import org.netbeans.modules.parsing.spi.indexing.support.IndexResult;
import org.netbeans.modules.parsing.spi.indexing.support.QuerySupport;
import org.openide.filesystems.FileObject;
import org.openide.util.Exceptions;

/**
 *
 * @author bhaidu
 */
public class BladeIndex {

    private final QuerySupport querySupport;
    private static final Map<Project, BladeIndex> INDEXES = new WeakHashMap<>();
    private static boolean areProjectsOpen = false;

    private BladeIndex(QuerySupport querySupport) throws IOException {
        this.querySupport = querySupport;
    }

    public static BladeIndex get(Project project) throws IOException {
        if (project == null) {
            return null;
        }
        synchronized (INDEXES) {
            BladeIndex index = INDEXES.get(project);
            if (index == null) {
                if (!areProjectsOpen) {
                    try {
                        // just be sure that the projects are open
                        OpenProjects.getDefault().openProjects().get();
                    } catch (InterruptedException ex) {
                        Exceptions.printStackTrace(ex);
                    } catch (ExecutionException ex) {
                        Exceptions.printStackTrace(ex);
                    } finally {
                        areProjectsOpen = true;
                    }
                }
                Collection<FileObject> sourceRoots = QuerySupport.findRoots(project,
                        null /* all source roots */,
                        Collections.<String>emptyList(),
                        Collections.<String>emptyList());
                QuerySupport querySupport = QuerySupport.forRoots(BladeIndexer.Factory.NAME, BladeIndexer.Factory.VERSION, sourceRoots.toArray(new FileObject[]{}));
                index = new BladeIndex(querySupport);
                if (sourceRoots.size() > 0) {
                    INDEXES.put(project, index);
                }
            }
            return index;
        }
    }

    public List<IndexedReference> getYieldReferences(String prefix) {
        List<IndexedReference> indexedReferences = new ArrayList<>();
        try {
            Collection<? extends IndexResult> result = querySupport.query(BladeIndexer.YIELD_REFERENCE, prefix, QuerySupport.Kind.PREFIX, BladeIndexer.YIELD_REFERENCE);

            if (result == null || result.isEmpty()) {
                return indexedReferences;
            }

            for (IndexResult indexResult : result) {
                String[] values = indexResult.getValues(BladeIndexer.YIELD_REFERENCE);
                for (String value : values) {
                    if (value.startsWith(prefix)) {
                        indexedReferences.add(new IndexedReference(value, indexResult.getFile()));
                    }
                }
            }
        } catch (IOException ex) {
            Exceptions.printStackTrace(ex);
        }
        
        return indexedReferences;
    }
    
    
    public List<IndexedReference> getYieldIds(String prefix) {
        List<IndexedReference> indexedReferences = new ArrayList<>();
        try {
            Collection<? extends IndexResult> result = querySupport.query(BladeIndexer.YIELD_ID, prefix, QuerySupport.Kind.PREFIX, BladeIndexer.YIELD_ID);

            if (result == null || result.isEmpty()) {
                return indexedReferences;
            }

            for (IndexResult indexResult : result) {
                String[] values = indexResult.getValues(BladeIndexer.YIELD_ID);
                for (String value : values) {
                    if (value.startsWith(prefix)) {
                        indexedReferences.add(new IndexedReference(value, indexResult.getFile()));
                    }
                }
            }
        } catch (IOException ex) {
            Exceptions.printStackTrace(ex);
        }
        
        return indexedReferences;
    }

    public void getPathReferences(String prefix) {
        Collection<? extends IndexResult> result = null;
        try {
            result = querySupport.query(BladeIndexer.INCLUDE_PATH, prefix, QuerySupport.Kind.PREFIX, BladeIndexer.INCLUDE_PATH);

            if (result == null || result.isEmpty()) {
                return;
            }

            for (IndexResult indexResult : result) {
                String[] values = indexResult.getValues(BladeIndexer.INCLUDE_PATH);
            }
            int x = 1;
        } catch (IOException ex) {
            Exceptions.printStackTrace(ex);
        }
    }

    public Set<FileObject> getFileObjectPathOccurences(String prefix) {
        Collection<? extends IndexResult> result;
        Set<FileObject> fileObjectPathOccurences = new LinkedHashSet<>();
        try {
            result = querySupport.query(BladeIndexer.INCLUDE_PATH, prefix, QuerySupport.Kind.PREFIX, BladeIndexer.INCLUDE_PATH);

            if (result == null || result.isEmpty()) {
                return fileObjectPathOccurences;
            }

            for (IndexResult indexResult : result) {
                fileObjectPathOccurences.add(indexResult.getFile());
            }
            int x = 1;
        } catch (IOException ex) {
            Exceptions.printStackTrace(ex);
        }

        return fileObjectPathOccurences;
    }

    public static class IndexedReference {

        private final String identifier;
        private final FileObject originFile;

        public IndexedReference(String identifier, FileObject originFile) {
            this.identifier = identifier;
            this.originFile = originFile;
        }

        public String getIdenfiier() {
            return this.identifier;
        }

        public FileObject getOriginFile() {
            return this.originFile;
        }
    }
}
