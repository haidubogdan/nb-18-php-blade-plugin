/*
Licensed to the Apache Software Foundation (ASF)
 */
package org.netbeans.modules.php.blade.editor.indexing;

import java.io.IOException;
import java.util.List;
import org.netbeans.api.project.FileOwnerQuery;
import org.netbeans.api.project.Project;
import org.openide.filesystems.FileObject;
import org.openide.util.Exceptions;

/**
 *
 * @author bogdan
 */
public class QueryUtils {

    public static List<BladeIndex.IndexedReference> getYieldReferences(String prefix, FileObject fo) {
        BladeIndex bladeIndex = getIndex(fo);
        if (bladeIndex == null) {
            return null;
        }
        return bladeIndex.getYieldIndexedReferences(prefix);
    }

    public static List<BladeIndex.IndexedReference> getStacksReferences(String prefix, FileObject fo) {
        BladeIndex bladeIndex = getIndex(fo);
        if (bladeIndex == null) {
            return null;
        }
        return bladeIndex.getStacksIndexedReferences(prefix);
    }
    
    public static List<BladeIndex.IndexedOffsetReference> getIncludePathReferences(String prefix, FileObject fo) {
        BladeIndex bladeIndex = getIndex(fo);
        if (bladeIndex == null) {
            return null;
        }
        return bladeIndex.getIncludePaths(prefix);
    }
    
    public static BladeIndex getIndex(FileObject fo) {
        Project project = FileOwnerQuery.getOwner(fo);
        
        //the PHP ProjectConvertor is looking only for
        //"src"
        //"lib"
        String className = project.getClass().getSimpleName();
        
        //we need to load the root project
        if (className.equals("ConvertorProject")){
            FileObject root = project.getProjectDirectory();
            
            if (root != null){
                FileObject rootDir = root.getParent();
                if (rootDir != null) {
                    project = FileOwnerQuery.getOwner(rootDir);
                }
            }
        }
        
        try {
            return BladeIndex.get(project);
        } catch (IOException ex) {
            Exceptions.printStackTrace(ex);
        }
        return null;
    }
}
