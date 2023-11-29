/*
Licensed to the Apache Software Foundation (ASF)
 */
package org.netbeans.modules.php.blade.editor.path;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.openide.filesystems.FileObject;

/**
 *
 * @author bogdan
 */
public class PathUtils {

    public static FileObject extractRootPath(FileObject currentFile) {
        String currentFilepath = currentFile.getPath();
        int viewRootPos = currentFilepath.lastIndexOf("/views/");
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
     * @return FileObject
     */
    public static FileObject findFileObjectForBladePath(FileObject contextFile, String bladePath) {
        FileObject viewRoot = extractRootPath(contextFile);

        if (viewRoot == null) {
            return null;
        }

        String sanitizedBladePath = bladePath.replace(".", "/") + ".blade.php";

        FileObject includedFile = viewRoot.getFileObject(sanitizedBladePath, true);

        if (includedFile != null && includedFile.isValid()) {
            return includedFile;
        }

        return null;
    }

    public static List<FileObject> getParentChildrenFromPrefixPath(FileObject contextFile,
            String prefixPath) {
        List<FileObject> list = new ArrayList<>();
        //this should be a fallback
        FileObject viewRoot = extractRootPath(contextFile);

        if (viewRoot == null) {
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

        //try to move folder to context
        if (lastSlash > 0 && nSlashes > 0) {
            viewRoot = viewRoot.getFileObject(canonicalPath.substring(0, lastSlash));
            if (!viewRoot.isValid()) {
                return list;
            }
        }

        String prefixToCompare;

        if (lastSlash > 0) {
            prefixToCompare = canonicalPath.substring(lastSlash, canonicalPath.length());
        } else {
            prefixToCompare = canonicalPath;
        }

        if (canonicalPath.endsWith("/")) {
            list = Arrays.asList(viewRoot.getChildren());
        } else {
            for (FileObject file : viewRoot.getChildren()) {
                if (file.getName().startsWith(prefixToCompare)) {
                    list.add(file);
                }
            }
        }

        return list;
    }
}
