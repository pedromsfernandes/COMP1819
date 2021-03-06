package utils;

import parser.*;

public interface ASTNodeVisitor {
    public String visit(ASTlt node);

    public String visit(ASTmult node);

    public String visit(ASTnot node);

    public String visit(ASTsub node);

    public String visit(ASTdiv node);

    public String visit(ASTVarDeclaration node);

    public String visit(ASTWhile node);

    public String visit(ASTIf node);

    public String visit(ASTid node);

    public String visit(ASTsum node);

    public String visit(ASTType node);

    public String visit(ASTStatement node);

    public String visit(ASTMethodDeclaration node);

    public String visit(ASTMainDeclaration node);

    public String visit(ASTbool node);

    public String visit(ASTArg node);

    public String visit(ASTArgs node);

    public String visit(ASTClassDeclaration node);

    public String visit(AST_new node);

    public String visit(AST_this node);

    public String visit(ASTand node);

    public String visit(ASTfield node);

    public String visit(ASTliteral node);
}