/*
Licensed to the Apache Software Foundation (ASF)
 */
package org.netbeans.modules.php.blade.editor.completion;

import java.util.Collection;
import java.util.Set;
import org.netbeans.api.project.FileOwnerQuery;
import org.netbeans.api.project.Project;
import org.netbeans.modules.csl.api.DeclarationFinder.AlternativeLocation;
import org.netbeans.modules.csl.api.DeclarationFinder.DeclarationLocation;
import org.netbeans.modules.parsing.spi.indexing.support.QuerySupport;
import org.netbeans.modules.php.blade.editor.BladeDeclarationFinder.BladeAlternativeLocation;
import org.netbeans.modules.php.blade.editor.parser.BladeParserResult;
import org.netbeans.modules.php.blade.editor.parser.ParsingUtils;

import org.netbeans.modules.php.blade.project.BladeProjectProperties;
import org.netbeans.modules.php.blade.project.PhpProjectIndex;
import org.netbeans.modules.php.editor.CodeUtils;
import org.netbeans.modules.php.editor.api.ElementQuery;
import org.netbeans.modules.php.editor.api.ElementQueryFactory;
import org.netbeans.modules.php.editor.api.NameKind;
import org.netbeans.modules.php.editor.api.QuerySupportFactory;
import org.netbeans.modules.php.editor.api.elements.ClassElement;
import org.netbeans.modules.php.editor.api.elements.FunctionElement;
import org.netbeans.modules.php.editor.api.elements.MethodElement;
import org.netbeans.modules.php.editor.api.elements.PhpElement;
import org.netbeans.modules.php.editor.parser.PHPParseResult;
import org.openide.filesystems.FileObject;
import org.netbeans.modules.php.editor.model.Occurence;
import org.netbeans.modules.php.editor.model.OccurencesSupport;
import org.netbeans.modules.php.editor.parser.astnodes.ClassName;
import org.netbeans.modules.php.editor.parser.astnodes.FunctionInvocation;
import org.netbeans.modules.php.editor.parser.astnodes.Identifier;
import org.netbeans.modules.php.editor.parser.astnodes.MethodInvocation;

/**
 *
 * @author bogdan
 */
public final class PhpTypeCompletionProvider {

    private static final PhpTypeCompletionProvider INSTANCE = new PhpTypeCompletionProvider();
    private Set<ClassElement> cachedElements;

    private PhpTypeCompletionProvider() {
    }

    public static PhpTypeCompletionProvider getInstance() {
        return INSTANCE;
    }

    /*
        * FOR PHP ??
     */
    public DeclarationLocation getItems(FileObject sourceFile, PHPParseResult phpResult, int carretOffset) {
        String prefix = "";
        DeclarationLocation alternatives = DeclarationLocation.NONE;

        if (phpResult == null) {
            return DeclarationLocation.NONE;
        }

        //phpResult.get
        final org.netbeans.modules.php.editor.model.Model model = phpResult.getModel(org.netbeans.modules.php.editor.model.Model.Type.COMMON);
        OccurencesSupport occurencesSupport = model.getOccurencesSupport(carretOffset);
        Occurence underCaret = occurencesSupport.getOccurence();
        if (underCaret != null) {
            Collection<? extends PhpElement> gotoDeclarations = underCaret.gotoDeclarations();
            if (gotoDeclarations == null || gotoDeclarations.isEmpty()) {
                return DeclarationLocation.NONE;
            }
            PhpElement declaration = gotoDeclarations.iterator().next();
            FileObject declarationFo = declaration.getFileObject();
            if (declarationFo == null) {
                return DeclarationLocation.NONE;
            }
            return new DeclarationLocation(declarationFo, declaration.getOffset(), declaration);
        } else {
            //todo add a visitor ?
            PhpElementsVisitor visitor = new PhpElementsVisitor(carretOffset, prefix);
            phpResult.getProgram().accept(visitor);
            org.netbeans.modules.php.editor.parser.astnodes.ASTNode nodeFound = visitor.getNodeFound();
            if (nodeFound == null) {
                return DeclarationLocation.NONE;
            }

            Project project = FileOwnerQuery.getOwner(sourceFile);
            if (project == null) {
                return DeclarationLocation.NONE;
            }

            ElementQuery.Index phpIndexQuery = PhpProjectIndex.getInstance().getPhpIndex();

            if (phpIndexQuery == null){
                return DeclarationLocation.NONE;
            }
            
            if (nodeFound instanceof Identifier) {
                Set<ClassElement> classes = phpIndexQuery.getClasses(NameKind.create(prefix, QuerySupport.Kind.PREFIX));
                for (ClassElement classElement : classes) {
                    if (!CodeUtils.isSyntheticTypeName(classElement.getName())) {
                        FileObject fo = classElement.getFileObject();
                        DeclarationLocation declLocation = new DeclarationLocation(
                                fo, classElement.getOffset());

                        AlternativeLocation al = new BladeAlternativeLocation(classElement, declLocation);
                        if (alternatives == DeclarationLocation.NONE) {
                            alternatives = al.getLocation();
                        }
                        alternatives.addAlternative(al);
                    }
                }
            } else if (nodeFound instanceof MethodInvocation) {
                Set<MethodElement> functions = phpIndexQuery.getMethods(NameKind.create(prefix, QuerySupport.Kind.PREFIX));
                for (MethodElement functionElement : functions) {
                    if (!CodeUtils.isSyntheticTypeName(functionElement.getName())) {
                        FileObject fo = functionElement.getFileObject();
                        DeclarationLocation declLocation = new DeclarationLocation(
                                fo, functionElement.getOffset());

                        AlternativeLocation al = new BladeAlternativeLocation(functionElement, declLocation);
                        if (alternatives == DeclarationLocation.NONE) {
                            alternatives = al.getLocation();
                        }
                        alternatives.addAlternative(al);
                    }
                }
            } else if (nodeFound instanceof FunctionInvocation) {
                Set<FunctionElement> functions = phpIndexQuery.getFunctions(NameKind.create(prefix, QuerySupport.Kind.PREFIX));
                for (FunctionElement functionElement : functions) {
                    if (!CodeUtils.isSyntheticTypeName(functionElement.getName())) {
                        FileObject fo = functionElement.getFileObject();
                        DeclarationLocation declLocation = new DeclarationLocation(
                                fo, functionElement.getOffset());

                        AlternativeLocation al = new BladeAlternativeLocation(functionElement, declLocation);
                        if (alternatives == DeclarationLocation.NONE) {
                            alternatives = al.getLocation();
                        }
                        alternatives.addAlternative(al);
                    }
                }

            }
        }

        return alternatives;
    }

    private synchronized Set<ClassElement> getElements(FileObject fileObject) {
        if (cachedElements == null) {
            ElementQuery.Index indexQuery = ElementQueryFactory.createIndexQuery(QuerySupportFactory.get(fileObject));
            cachedElements = indexQuery.getClasses(NameKind.empty());
        }
        return cachedElements;
    }

    public synchronized void clearCache() {
        cachedElements = null;
    }

    public static class PhpElementsVisitor extends org.netbeans.modules.php.editor.parser.astnodes.visitors.DefaultVisitor {

        private int offset;
        private String prefix;
        private org.netbeans.modules.php.editor.parser.astnodes.ASTNode nodeFound;

        public PhpElementsVisitor(int offset, String prefix) {
            this.offset = offset;
            this.prefix = prefix;
        }

        @Override
        public void scan(org.netbeans.modules.php.editor.parser.astnodes.ASTNode node) {
            if (node != null && nodeFound == null) {
                super.scan(node);
            }
        }

        @Override
        public void visit(Identifier node) {
            if (matches(node, node.getName())) {
                nodeFound = node;
            }
        }

        @Override
        public void visit(ClassName node) {
            if (matches(node, node.getName().toString())) {
                nodeFound = node;
            }
        }

        @Override
        public void visit(MethodInvocation node) {
            if (matches(node, node.getMethod().toString())) {
                nodeFound = node;
            }
        }

        @Override
        public void visit(FunctionInvocation node) {
            if (matches(node, node.getFunctionName().getName().toString())) {
                nodeFound = node;
            }
        }

        private boolean matches(org.netbeans.modules.php.editor.parser.astnodes.ASTNode node, String name) {
            return node.getStartOffset() <= offset && node.getEndOffset() >= offset && name.replace("\\", "").equals(prefix);
        }

        public org.netbeans.modules.php.editor.parser.astnodes.ASTNode getNodeFound() {
            return nodeFound;
        }
    }
}
