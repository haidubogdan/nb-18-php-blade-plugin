package org.netbeans.modules.php.blade.editor.refactoring;


import java.util.Objects;
import org.openide.filesystems.FileObject;

/**
 *
 * @author bogdan
 */
public class SymbolInformation {

    private final FileObject sourceFile;
    private final String name;

    public SymbolInformation(FileObject sourceFile, String name) {
        this.sourceFile = sourceFile;
        this.name = name;
    }

    public FileObject getSourceFile() {
        return sourceFile;
    }

    public String getName() {
        return name;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.sourceFile);
        hash = 53 * hash + Objects.hashCode(this.name);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SymbolInformation other = (SymbolInformation) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return Objects.equals(this.sourceFile, other.sourceFile);
    }

}
