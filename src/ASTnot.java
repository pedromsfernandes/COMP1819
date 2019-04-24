/* Generated By:JJTree: Do not edit this line. ASTnot.java Version 6.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
public
class ASTnot extends SimpleNode {

  public ASTnot(int id) {
    super(id);
  }

  public ASTnot(jmm p, int id) {
    super(p, id);
  }

  public String getType() {
    return "bool";
  }

  void triggerSemanticAnalysis() throws SemanticException
  {
    Node lastChild = null;
    for (Node sibling : ((SimpleNode)parent).children) {
      if(sibling == this)
      {
        break;
      }
      else{
        lastChild = sibling;
      }
    }
    
    if(lastChild != null)
    {
      if(!((SimpleNode) lastChild).getType().equals("bool")){
        throw new SemanticException("Operand of ! is not a bool at line " + line + ", column " + column + ".");
      }
    }

  }
}
/* JavaCC - OriginalChecksum=fb8d63593e6952b5ae4d23414e6729e2 (do not edit this line) */
