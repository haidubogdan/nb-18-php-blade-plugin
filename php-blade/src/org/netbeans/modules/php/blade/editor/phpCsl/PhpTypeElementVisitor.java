package org.netbeans.modules.php.blade.editor.phpCsl;

import org.netbeans.modules.php.editor.model.nodes.ASTNodeInfo.Kind;
import org.netbeans.modules.php.editor.parser.astnodes.ASTNode;
import org.netbeans.modules.php.editor.parser.astnodes.ClassInstanceCreation;
import org.netbeans.modules.php.editor.parser.astnodes.ClassName;
import org.netbeans.modules.php.editor.parser.astnodes.Expression;
import org.netbeans.modules.php.editor.parser.astnodes.FunctionInvocation;
import org.netbeans.modules.php.editor.parser.astnodes.Identifier;
import org.netbeans.modules.php.editor.parser.astnodes.InstanceOfExpression;
import org.netbeans.modules.php.editor.parser.astnodes.MethodInvocation;
import org.netbeans.modules.php.editor.parser.astnodes.NamespaceName;
import org.netbeans.modules.php.editor.parser.astnodes.Scalar;
import org.netbeans.modules.php.editor.parser.astnodes.StaticConstantAccess;

/**
 *
 * @author bhaidu
 */
public class PhpTypeElementVisitor extends org.netbeans.modules.php.editor.parser.astnodes.visitors.DefaultVisitor {

    public enum IdentifierType {
        CLASS,
    };
    private int offset;
    private String identifier;
    private IdentifierType identifierType;

    public PhpTypeElementVisitor(int offset) {
        this.offset = offset;
    }

    @Override
    public void scan(ASTNode node) {
        if (node != null && identifier == null) {
            super.scan(node);
        }
    }

    @Override
    public void visit(StaticConstantAccess node) {
        if (indexBetween(node)) {
            Expression dispatcher = node.getDispatcher();
            Expression constant = node.getConstant();
            if (dispatcher instanceof NamespaceName) {
                Identifier elementIdentifier = ((NamespaceName) dispatcher).getSegments().get(0);
                identifier = elementIdentifier.getName();
                identifierType = IdentifierType.CLASS;
            } else {
                scan(dispatcher);
            }
            int x = 1;
            //nodeFound = node;
        }
    }

    @Override
    public void visit(Scalar node) {
        if (indexBetween(node)) {
        }
    }

    @Override
    public void visit(ClassInstanceCreation node) {
        if (indexBetween(node)) {
        }
    }

    @Override
    public void visit(InstanceOfExpression node) {
        if (indexBetween(node)) {
        }
    }

    @Override
    public void visit(ClassName node) {
        if (indexBetween(node)) {
        }
    }

    @Override
    public void visit(MethodInvocation node) {
        if (indexBetween(node)) {
        }
    }

    @Override
    public void visit(FunctionInvocation node) {
        if (indexBetween(node)) {
        }
    }

    public String getIdentifier() {
        return identifier;
    }

    public IdentifierType getIdentifierType() {
        return identifierType;
    }

    protected boolean indexBetween(ASTNode node) {
        return node.getStartOffset() <= offset && offset <= node.getEndOffset();
    }
}
