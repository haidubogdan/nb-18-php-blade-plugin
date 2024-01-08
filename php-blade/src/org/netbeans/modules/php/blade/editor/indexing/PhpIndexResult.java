/*
Licensed to the Apache Software Foundation (ASF)
 */
package org.netbeans.modules.php.blade.editor.indexing;

import org.openide.filesystems.FileObject;

/**
 *
 * @author bogdan
 */
public class PhpIndexResult {
    public static enum Type{
        CLASS,
        FUNCTION,
        CONSTANT
    };

    public String name;
    public FileObject declarationFile;
    public PhpIndexResult.Type type;
    
    public PhpIndexResult(String name, FileObject fo, PhpIndexResult.Type type){
        this.name = name;
        this.declarationFile = fo;
        this.type = type;
    }
}
