/* Generated By:JJTree: Do not edit this line. ASTbool.java Version 6.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
public
class ASTbool extends SimpleNode {
  public boolean info = false;

  public ASTbool(int id) {
    super(id);
  }

  public ASTbool(parser p, int id) {
    super(p, id);
  }

  public String toString() {
    return "bool " + info;
  }

}
/* JavaCC - OriginalChecksum=7064e952aa942fd46131a1edde577da1 (do not edit this line) */
