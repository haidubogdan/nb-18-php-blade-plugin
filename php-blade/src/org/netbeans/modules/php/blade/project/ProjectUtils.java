package org.netbeans.modules.php.blade.project;

import org.netbeans.api.project.FileOwnerQuery;
import org.netbeans.api.project.Project;
import org.openide.filesystems.FileObject;

/**
 *
 * @author bogdan
 */
public class ProjectUtils {

    public static Project getMainOwner(FileObject file) {
        Project project = FileOwnerQuery.getOwner(file);

        if (project == null) {
            return null;
        }
        String className = project.getClass().getSimpleName();
        //the PHP ProjectConvertor is looking only for
        //"src"
        //"lib"
        //we need to load the root project
        if (className.equals("ConvertorProject")) {
            FileObject root = project.getProjectDirectory();

            if (root != null) {
                FileObject rootDir = root.getParent();
                if (rootDir != null) {
                    project = FileOwnerQuery.getOwner(rootDir);
                }
            }
        }
        return project;
    }
}
