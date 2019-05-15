/* Generated By:JJTree: Do not edit this line. ASTdiv.java Version 6.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
public
class ASTdiv extends SimpleNode {

  public ASTdiv(int id) {
    super(id);
  }

  public ASTdiv(jmm p, int id) {
    super(p, id);
  }

  public String getType() {
    return "int";
  }

  void triggerSemanticAnalysis() throws SemanticException
  {
    SimpleNode left = (SimpleNode)children[0];
    SimpleNode right = (SimpleNode)children[1];

    if(!left.getType().equals("int") || !right.getType().equals("int")){
      throw new SemanticException("At least one of operands of / is not an int at line " + line + ", column " + column + ".");
    }
  }

  String getPreJasmin()
  {
    String out = "";

    if(parent instanceof ASTsum ||
    parent instanceof ASTsub ||
    parent instanceof ASTmult ||
    parent instanceof ASTdiv)
    return "";

    SimpleNode p = (SimpleNode) parent;

    String assign = null;
    if(p instanceof ASTStatement)
      assign = ((ASTStatement) p).id;

    STEntry local = checkImediateSymbolTable(assign);
    STEntry global = checkSymbolTable(assign);

    if(assign != null)
      if(local == null)
      {
        if(global != null)
          out += "aload_0\n";
      }

    out += getJasminRecursive();

    if(local == null)
    {
      if(global != null)
        out += "putfield " + assign + "/" + global.order + "\n";
    }
    else
    {
      out += "istore " + local.order + "\n";
    }

    return out;
  }


  String getJasminRecursive()
  {
    String out = "";
    

    if(children[0] instanceof ASTid)
    {
      String arg0 = ((ASTid) children[0]).info;
      STEntry local_0 = checkImediateSymbolTable(arg0);
      STEntry global_0 = checkSymbolTable(arg0);

      if(local_0 == null)
      {
        if(global_0 != null)
        {
          out += "aload_0\n";
          out += "getfield " + arg0 + "/" + global_0.order + "\n";
        }
      }
      else
      {
        out += "iload " + local_0.order + "\n";
      }
    }
    else if (children[0] instanceof ASTliteral)
    {
      out += "ldc " + ((ASTliteral) children[0]).info + "\n";
    }
    else if (children[0] instanceof ASTsum)
      out += ((ASTsum) children[0]).getJasminRecursive();
    else if (children[0] instanceof ASTsub)
      out += ((ASTsub) children[0]).getJasminRecursive();
    else if (children[0] instanceof ASTmult)
      out += ((ASTmult) children[0]).getJasminRecursive();
    else if (children[0] instanceof ASTdiv)
      out += ((ASTdiv) children[0]).getJasminRecursive();

    if(children[1] instanceof ASTid)
    {
      String arg1 = ((ASTid) children[1]).info;
      STEntry local_1 = checkImediateSymbolTable(arg1);
      STEntry global_1 = checkSymbolTable(arg1);

      if(local_1 == null)
      {
        if(global_1 != null)
        {
          out += "aload_0\n";
          out += "getfield " + arg1 + "/" + global_1.order + "\n";
        }
      }
      else
      {
        out += "iload " + local_1.order + "\n";
      }
    }
    else if (children[1] instanceof ASTliteral)
    {
      out += "ldc " + ((ASTliteral) children[1]).info + "\n";
    }
    else if (children[1] instanceof ASTsum)
      out += ((ASTsum) children[1]).getJasminRecursive();
    else if (children[1] instanceof ASTsub)
      out += ((ASTsub) children[1]).getJasminRecursive();
    else if (children[1] instanceof ASTmult)
      out += ((ASTmult) children[1]).getJasminRecursive();
    else if (children[1] instanceof ASTdiv)
      out += ((ASTdiv) children[1]).getJasminRecursive();

    out += "idiv\n";
    
    return out;
  }
}
/* JavaCC - OriginalChecksum=8e5bf6cb6320f30a44173f2c5c582639 (do not edit this line) */
