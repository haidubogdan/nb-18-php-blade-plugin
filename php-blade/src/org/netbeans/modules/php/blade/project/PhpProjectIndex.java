/*
Licensed to the Apache Software Foundation (ASF)
 */
package org.netbeans.modules.php.blade.project;

import org.netbeans.api.project.Project;
import org.netbeans.modules.php.blade.editor.parser.ParsingUtils;
import org.netbeans.modules.php.editor.api.ElementQuery;
import org.netbeans.modules.php.editor.api.ElementQueryFactory;
import org.netbeans.modules.php.editor.api.QuerySupportFactory;
import org.openide.filesystems.FileObject;

/**
 *
 * @author bogdan
 */
public class PhpProjectIndex {

    private static final PhpProjectIndex INSTANCE = new PhpProjectIndex();
    ElementQuery.Index phpIndex;
    boolean phpIndexScanned = false;
    public Project project;
    public FileObject rootFile;

    public static PhpProjectIndex getInstance(Project project) {
        if (INSTANCE.project == null || INSTANCE.project != project) {
            INSTANCE.project = project;
        }
        return INSTANCE;
    }

    public static PhpProjectIndex getInstance() {
        return INSTANCE;
    }

    public ElementQuery.Index getPhpIndex() {
        if (phpIndexScanned) {
            return phpIndex;
        }
        if (project == null){
            return null;
        }
        FileObject files[] = project.getProjectDirectory().getChildren();
        for (FileObject file : files) {
            if (file.isFolder()) {
                continue;
            }
            //parse an existing root file to get all the info
            if (file.getExt().equals("php")) {
                rootFile = file;
                ParsingUtils parsingUtils = new ParsingUtils();
                parsingUtils.parseFileObject(file);
                phpIndex = ElementQueryFactory.createIndexQuery(QuerySupportFactory.get(parsingUtils.getParserResult()));
                break;
            }
        }

        phpIndexScanned = true;
        return phpIndex;
    }
}
