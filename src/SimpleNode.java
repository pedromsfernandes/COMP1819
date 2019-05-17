import java.util.Map;

/* Generated By:JJTree: Do not edit this line. SimpleNode.java Version 6.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
public class SimpleNode implements Node {

  protected Node parent;
  protected Node[] children;
  protected int id;
  protected Object value;
  protected jmm parser;

  public int line;
  public int column;

  static int labelCount = 0;

  public SimpleNode(int i) {
    id = i;
  }

  public SimpleNode(jmm p, int i) {
    this(i);
    parser = p;
  }

  public void jjtOpen() {
  }

  public void jjtClose() {
  }

  public void jjtSetParent(Node n) {
    parent = n;
  }

  public Node jjtGetParent() {
    return parent;
  }

  public void jjtAddChild(Node n, int i) {
    if (children == null) {
      children = new Node[i + 1];
    } else if (i >= children.length) {
      Node c[] = new Node[i + 1];
      System.arraycopy(children, 0, c, 0, children.length);
      children = c;
    }
    children[i] = n;
  }

  public Node jjtGetChild(int i) {
    return children[i];
  }

  public int jjtGetNumChildren() {
    return (children == null) ? 0 : children.length;
  }

  public void jjtSetValue(Object value) {
    this.value = value;
  }

  public Object jjtGetValue() {
    return value;
  }

  /*
   * You can override these two methods in subclasses of SimpleNode to customize
   * the way the node appears when the tree is dumped. If your output uses more
   * than one line you should override toString(String), otherwise overriding
   * toString() is probably all you need to do.
   */

  public String toString() {
    return jmmTreeConstants.jjtNodeName[id];
  }

  public String toString(String prefix) {
    return prefix + toString();
  }

  /*
   * Override this method if you want to customize how the node dumps out its
   * children.
   */

  public void dump(String prefix) {
    System.out.println(toString(prefix));
    if (children != null) {
      for (int i = 0; i < children.length; ++i) {
        SimpleNode n = (SimpleNode) children[i];
        if (n != null) {
          n.dump(prefix + " ");
        }
      }
    }
  }

  public void printSymbolTable() {

    if (this instanceof ASTClassDeclaration) {
      System.out.println("Symbol table for " + ((ASTClassDeclaration) this).id);
      for (Map.Entry<String, STEntry> entry : ((ASTClassDeclaration) this).symtbl.entrySet()) {
        System.out.println(entry.getKey() + ": " + entry.getValue().type);
      }
    }
    if (this instanceof ASTMainDeclaration) {
      System.out.println("Symbol table for main");
      for (Map.Entry<String, STEntry> entry : ((ASTMainDeclaration) this).symtbl.entrySet()) {
        System.out.println(entry.getKey() + ": " + entry.getValue().type);
      }
    }
    if (this instanceof ASTMethodDeclaration) {
      System.out.println("Symbol table for " + ((ASTMethodDeclaration) this).id);
      for (Map.Entry<String, STEntry> entry : ((ASTMethodDeclaration) this).symtbl.entrySet()) {
        System.out.println(entry.getKey() + ": " + entry.getValue().type);
      }
    }

    if (children != null) {
      for (int i = 0; i < children.length; ++i) {
        SimpleNode n = (SimpleNode) children[i];
        if (n != null) {
          n.printSymbolTable();
        }
      }
    }
  }

  public int getId() {
    return id;
  }

  // TODO: fazer analise semantica depois de ter symbol table completa
  public void semanticAnalysis() {
 
    try {
      triggerSemanticAnalysis();
    } catch (SemanticException e) {
      System.err.println("SemanticException: " + e.getMessage());
    }

    if (children != null) {
      for (int i = 0; i < children.length; ++i) {
        SimpleNode n = (SimpleNode)children[i];
        if (n != null) {
          n.semanticAnalysis();
        }
      }
    }
  }

  public boolean addToSymbolTable(String id, STEntry entry)
  {
    Node n = parent;
    STEntry id_prev;

    while(n != null)
    {    

      if(n instanceof ASTClassDeclaration)
      {    

        id_prev = ((ASTClassDeclaration) n).symtbl.get(id);

        if(id_prev != null)
          return false;
        
        entry.order = ((ASTClassDeclaration) n).global_order;
        ((ASTClassDeclaration) n).global_order++;
        ((ASTClassDeclaration) n).symtbl.put(id, entry);
        return true;
      }
      
      if(n instanceof ASTMainDeclaration)
      {    

        id_prev = ((ASTMainDeclaration) n).symtbl.get(id);

        if(id_prev != null)
          return false;
        
        entry.order = ((ASTMainDeclaration) n).global_order;
        ((ASTMainDeclaration) n).global_order++;
        ((ASTMainDeclaration) n).symtbl.put(id, entry);
        return true;
      } 

      if(n instanceof ASTMethodDeclaration)
      {    

        id_prev = ((ASTMethodDeclaration) n).symtbl.get(id);

        if(id_prev != null)
          return false;

        entry.order = ((ASTMethodDeclaration) n).global_order;
        ((ASTMethodDeclaration) n).global_order++;
        ((ASTMethodDeclaration) n).symtbl.put(id, entry);
        return true;
      } 

      n = ((SimpleNode) n).parent;
    }

    return false;
  }

  void triggerSemanticAnalysis() throws SemanticException
  {
    //to be overwritten
  }

  String getPreJasmin()
  {
    return "";
  }

  String getPostJasmin()
  {
    return "";
  }

  public String printJasmin()
  {
    String j = getPreJasmin();

    if (children != null) {
      for (int i = 0; i < children.length; ++i) {
        SimpleNode n = (SimpleNode) children[i];
        if (n != null) {
          j += n.printJasmin();
        }
      }
    }

    j += getPostJasmin();

    return j;
  }

  public String getType() {

    return "Error";
  }

  STEntry checkSymbolTable(String info)
  {
    SimpleNode tempParent = (SimpleNode)parent;
    STEntry answer = null;
    while(tempParent != null){
      if (tempParent instanceof ASTClassDeclaration) {
        answer = ((ASTClassDeclaration) tempParent).symtbl.get(info);
      }
      else if (tempParent instanceof ASTMainDeclaration) {
        answer = ((ASTMainDeclaration) tempParent).symtbl.get(info);
      }
      else if (tempParent instanceof ASTMethodDeclaration) {
        answer = ((ASTMethodDeclaration) tempParent).symtbl.get(info);
      }
      if(answer != null) break;
      tempParent = (SimpleNode)tempParent.parent;
    }

    return answer;
  }

  STEntry checkImediateSymbolTable(String info)
  {
    SimpleNode tempParent = (SimpleNode)parent;
    STEntry answer = null;
    while(tempParent != null){
      if (tempParent instanceof ASTClassDeclaration) {
        answer = ((ASTClassDeclaration) tempParent).symtbl.get(info);
        return answer;
      }
      else if (tempParent instanceof ASTMainDeclaration) {
        answer = ((ASTMainDeclaration) tempParent).symtbl.get(info);
        return answer;
      }
      else if (tempParent instanceof ASTMethodDeclaration) {
        answer = ((ASTMethodDeclaration) tempParent).symtbl.get(info);
        return answer;
      }
      if(answer != null) break;
      tempParent = (SimpleNode)tempParent.parent;
    }

    return answer;
  }

  String getClassName()
  {
    SimpleNode tempParent = (SimpleNode)parent;
    while(tempParent != null){
      if (tempParent instanceof ASTClassDeclaration) {
        return ((ASTClassDeclaration) tempParent).id;
      }

      tempParent = (SimpleNode)tempParent.parent;
    }

    return "";
  }

  public static String getJasminType(String type) {
    switch(type)
    {
      case "void":
        return "V";
      case "int":
        return "I";
      case "int[]":
        return "[I";
      case "bool":
        return "Z";
      case "String":
        return "Ljava/lang/String;";
      case "String[]":
        return "[Ljava/lang/String;"; 
    }

    return "";
  }

  public static int getNextLabel()
  {
    return ++labelCount;
  }
}

/* JavaCC - OriginalChecksum=1170bfc765845a635efbe3cdd869fe92 (do not edit this line) */
