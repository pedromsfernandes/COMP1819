/* Generated By:JJTree: Do not edit this line. ASTMethodDeclaration.java Version 6.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
public
class ASTMethodDeclaration extends SimpleNode {
  public String id;

  public ASTMethodDeclaration(int id) {
    super(id);
  }

  public ASTMethodDeclaration(parser p, int id) {
    super(p, id);
  }

  public String toString() {
    return "method " + id;
  }
}
/* JavaCC - OriginalChecksum=4db4e7d00203d02b3e258a10941c8c0e (do not edit this line) */
