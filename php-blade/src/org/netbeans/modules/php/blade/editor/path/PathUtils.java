/*
Licensed to the Apache Software Foundation (ASF)
 */
package org.netbeans.modules.php.blade.editor.path;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.netbeans.api.project.FileOwnerQuery;
import org.netbeans.api.project.Project;
import org.netbeans.modules.php.blade.project.BladeProjectProperties;
import org.openide.filesystems.FileObject;
import org.openide.filesystems.FileUtil;

/**
 *
 * @author bogdan
 */
public class PathUtils {

    private static final String LARAVEL_VIEW_PATH = "resources/views"; //NOI18N

    public static FileObject extractRootPath(FileObject currentFile) {
        String currentFilepath = currentFile.getPath();
        int viewRootPos = currentFilepath.lastIndexOf("/views/");
        if (viewRootPos< 0){
            return null;
        }
        String relativePath = currentFilepath.substring(viewRootPos);
        int currentFileDeep = StringUtils.countMatches(relativePath, "/");
        String relativeRootPath = StringUtils.repeat("../", currentFileDeep) + "views";
        FileObject viewRoot = currentFile.getFileObject(relativeRootPath, true);

        if (viewRoot == null || !viewRoot.isValid()) {
            return null;
        }

        return viewRoot;
    }

    /**
     * first we need to extract the root folder of view after we apply a generic
     * path sanitize for blade paths (ex "my.path" -> "my/path.blade.php")
     *
     * @param contextFile
     * @param bladePath
     * @return List<FileObject>
     */
    public static List<FileObject> findFileObjectsForBladePath(FileObject contextFile, String bladePath) {
        List<FileObject> list = new ArrayList<>();
        Project project = FileOwnerQuery.getOwner(contextFile);

        if (project == null) {
            return list;
        }

        List<FileObject> viewRoots = getCustomViewsRoots(project, contextFile);

        if (viewRoots == null || viewRoots.isEmpty()) {
            return list;
        }

        String sanitizedBladePath = bladePath.replace(".", "/") + ".blade.php"; //NOI18N

        for (FileObject viewRoot : viewRoots) {
            FileObject includedFile = viewRoot.getFileObject(sanitizedBladePath, true);

            if (includedFile != null && includedFile.isValid()) {
                list.add(includedFile);
            }
        }

        return list;
    }

    /**
     *
     *
     * @param contextFile
     * @param prefixPath
     * @return List<FileObject>
     */
    public static List<FileObject> getParentChildrenFromPrefixPath(FileObject contextFile,
            String prefixPath) {
        List<FileObject> list = new ArrayList<>();
        //this should be a fallback
        Project project = FileOwnerQuery.getOwner(contextFile);

        if (project == null) {
            return list;
        }

        List<FileObject> viewRoots = getCustomViewsRoots(project, contextFile);

        if (viewRoots == null || viewRoots.isEmpty()) {
            return list;
        }

        String canonicalPath = prefixPath.replace(".", "/");
        int lastSlash;

        //fix issues with lastIndexOf search
        if (canonicalPath.endsWith("/")) {
            lastSlash = canonicalPath.length();
        } else {
            lastSlash = prefixPath.lastIndexOf("/");
        }

        int nSlashes = StringUtils.countMatches(canonicalPath, "/");

        List<FileObject> filteredViewRoots = new ArrayList<>();
        if (lastSlash > 0 && nSlashes > 0) {
            for (FileObject rootFolder : viewRoots) {
                FileObject relativeViewRoot = rootFolder.getFileObject(canonicalPath.substring(0, lastSlash));

                if (relativeViewRoot != null && relativeViewRoot.isValid()) {
                    filteredViewRoots.add(relativeViewRoot);
                }
            }
            //empty list
            viewRoots.clear();
        } else {
            filteredViewRoots = viewRoots;
        }

        String prefixToCompare;

        if (lastSlash > 0) {
            prefixToCompare = canonicalPath.substring(lastSlash, canonicalPath.length());
        } else {
            prefixToCompare = canonicalPath;
        }

        if (canonicalPath.endsWith("/")) {
            for (FileObject rootFolder : filteredViewRoots) {
                list.addAll(Arrays.asList(rootFolder.getChildren()));
            }
        } else {
            for (FileObject rootFolder : filteredViewRoots) {
                for (FileObject file : rootFolder.getChildren()) {
                    if (file.getName().startsWith(prefixToCompare)) {
                        list.add(file);
                    }
                }
            }
        }

        return list;
    }

    public static List<FileObject> getCustomViewsRoots(Project project, FileObject contextFile) {
        List<FileObject> list = new ArrayList<>();
        String[] views = BladeProjectProperties.getInstance(project).getViewsPathList();
        views = Arrays.stream(views).filter(s -> !s.isEmpty()).toArray(String[]::new);
        Arrays.sort(views, (String s1, String s2) -> {
            //clear empty configs
            if (s1 == null || s2 == null) {
                return 0;
            }
            return s2.length() - s1.length();// comparision
        });

        if (views.length > 0) {
            for (String view : views) {
                if (view.length() == 0) {
                    continue;
                }
                File viewPath = new File(view);
                if (!viewPath.exists()) {
                    continue;
                }

                list.add(FileUtil.toFileObject(viewPath));
            }
        } else {
            //fallback to default
            FileObject defaultLaravelPath = project.getProjectDirectory().getFileObject(LARAVEL_VIEW_PATH);
            if (defaultLaravelPath != null) {
                list.add(defaultLaravelPath);
            }
        }

        FileObject estimatedRoot = extractRootPath(contextFile);

        if (estimatedRoot != null) {
            list.add(estimatedRoot);
        }

        return list;
    }
}
