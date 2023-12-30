package org.netbeans.modules.php.blade.editor.phpCsl;

import java.awt.Point;
import java.io.IOException;
import java.util.Collection;
import javax.swing.JToolTip;
import org.netbeans.modules.csl.api.DeclarationFinder;
import org.netbeans.modules.parsing.spi.indexing.support.IndexResult;
import org.netbeans.modules.parsing.spi.indexing.support.QuerySupport;
import org.netbeans.modules.php.blade.csl.elements.PhpProxyElement;
import org.netbeans.modules.php.blade.editor.BladeDeclarationFinder;
import org.netbeans.modules.php.blade.editor.phpCsl.PhpTypeElementVisitor.IdentifierType;
import org.netbeans.modules.php.editor.api.QuerySupportFactory;
import org.netbeans.modules.php.editor.api.elements.PhpElement;
import org.netbeans.modules.php.editor.model.Occurence;
import org.netbeans.modules.php.editor.model.OccurencesSupport;
import org.netbeans.modules.php.editor.parser.PHPParseResult;
import org.openide.filesystems.FileObject;
import org.openide.util.Exceptions;

/**
 *
 * @author bhaidu
 */
public class PhpTypeDeclarationProvider {

    private static final PhpTypeDeclarationProvider INSTANCE = new PhpTypeDeclarationProvider();

    private PhpTypeDeclarationProvider() {
    }

    public static PhpTypeDeclarationProvider getInstance() {
        return INSTANCE;
    }

    /**
     * @todo should know the context (function / class)
     *
     * @param sourceFile
     * @param phpResult
     * @param carretOffset
     * @return
     */
    public DeclarationFinder.DeclarationLocation getItems(FileObject sourceFile, PHPParseResult phpResult, int carretOffset) {
        DeclarationFinder.DeclarationLocation alternatives = DeclarationFinder.DeclarationLocation.NONE;

        if (phpResult == null) {
            return DeclarationFinder.DeclarationLocation.NONE;
        }

        //this works for common functions and classes
        final org.netbeans.modules.php.editor.model.Model commonModel = phpResult.getModel(org.netbeans.modules.php.editor.model.Model.Type.COMMON);
        OccurencesSupport occurencesSupport = commonModel.getOccurencesSupport(carretOffset);
        Occurence underCaret = occurencesSupport.getOccurence();
        if (underCaret != null) {
            Collection<? extends PhpElement> gotoDeclarations = underCaret.gotoDeclarations();
            if (gotoDeclarations == null || gotoDeclarations.isEmpty()) {
                return DeclarationFinder.DeclarationLocation.NONE;
            }
            PhpElement declaration = gotoDeclarations.iterator().next();
            FileObject declarationFo = declaration.getFileObject();
            if (declarationFo == null) {
                return DeclarationFinder.DeclarationLocation.NONE;
            }
            return new DeclarationFinder.DeclarationLocation(declarationFo, declaration.getOffset(), declaration);
        } else {
            //we need to find the info using index
            //first find the node type
            PhpTypeElementVisitor visitor = new PhpTypeElementVisitor(carretOffset);
            phpResult.getProgram().accept(visitor);

            String identifier = visitor.getIdentifier();
            IdentifierType identifierType = visitor.getIdentifierType();

            if (identifier == null || identifierType == null) {
                return DeclarationFinder.DeclarationLocation.NONE;
            }
            QuerySupport phpindex = QuerySupportFactory.get(sourceFile);

            switch (identifierType) {
                case CLASS: {
                    try {
                        Collection<? extends IndexResult> indexResults = phpindex.query("clz", identifier.toLowerCase(), QuerySupport.Kind.PREFIX, new String[]{"clz"});
                        for (IndexResult indexResult : indexResults) {
                            FileObject indexFile = indexResult.getFile();
                            DeclarationFinder.DeclarationLocation declLocation = new DeclarationFinder.DeclarationLocation(
                                    indexFile, 0);
                            DeclarationFinder.AlternativeLocation al = new BladeDeclarationFinder.BladeAlternativeLocation(
                                    new PhpProxyElement(identifier, indexFile), declLocation);
                            if (alternatives == DeclarationFinder.DeclarationLocation.NONE) {
                                alternatives = al.getLocation();
                            }
                            alternatives.addAlternative(al);
                        }

                    } catch (IOException ex) {
                        Exceptions.printStackTrace(ex);
                    }
                }
                break;

            }
        }

        return alternatives;
    }

}
