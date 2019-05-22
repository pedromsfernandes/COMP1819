/* Generated By:JJTree: Do not edit this line. ASTType.java Version 6.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
public class ASTType extends SimpleNode {
  public String type;
  public boolean array = false;

  public ASTType(int id) {
    super(id);
  }

  public ASTType(jmm p, int id) {
    super(p, id);
  }

  public String toString() {
    return "type " + type + (array ? "[]" : "");
  }

  public String getType() {
    return type + (array ? "[]" : "");
  }

  @Override
  public String accept(ASTNodeVisitor visitor) {
    return visitor.visit(this);
  }
}
/*
 * JavaCC - OriginalChecksum=82260e3d975ec54bb074f6297441afec (do not edit this
 * line)
 */
