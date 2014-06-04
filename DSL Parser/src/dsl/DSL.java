package dsl;
import java.io.*;

public class DSL/*@bgen(jjtree)*/implements DSLTreeConstants, DSLConstants {/*@bgen(jjtree)*/
  protected static JJTDSLState jjtree = new JJTDSLState();public static void main(String args [])
  {
        if( args.length != 1){
                System.out.println("Run: java -jar <name of the jar file.jar> <path of the example>");
                System.exit(0);
        }

    DSL dsl = null;

        if( args[0] != null )
        {
      System.out.println("-- " + args[0] + " --");
      try
      {
        File toParse = new File(Generator.extractDSLCode(new File(args[0])));
        InputStream inputStream = new FileInputStream(toParse);
        if (dsl == null) dsl = new DSL(inputStream);
        else ReInit(inputStream);
        try
        {
          SimpleNode n = DSL.Start();
          //System.out.println("---------");
          //n.dump("");
          //System.out.println("---------");
          //n.deleteFactorAfterTerm();
          n.deleteUninterestingNodes();
          n.dump("");          Warning.dump();
          Generator gen = new Generator(new File(args[0]), n);
          System.out.println("Successfully Parsed and Generated!\u005cn");
          // Clear all the static stuff for the next file parsing          VariableStore.clear();
          MyVariable.clear();
          Warning.dump();
          Warning.clear();
          Generator.clean();
        }
        catch (SemanticException e)
        {
          System.err.println("::: Semantic Error :::");
          System.err.println(e.getMessage());
        }
        catch (Exception e)
        {
          System.err.println("::: Syntax Error :::");
          System.err.println(e.getMessage());
          e.printStackTrace();
        }
      }
      catch (IOException e)
      {
        System.out.println("Oops.");
        System.out.println(e.getMessage());
      }
        }
        else
        {
          System.out.println("No input files");
        }
  }

  static final public SimpleNode Start() throws ParseException, Exception {
 /*@bgen(jjtree) Start */
  SimpleNode jjtn000 = new SimpleNode(JJTSTART);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);
    try {
      parseDSL();
    jjtree.closeNodeScope(jjtn000, true);
    jjtc000 = false;
    {if (true) return jjtn000;}
    } catch (Throwable jjte000) {
    if (jjtc000) {
      jjtree.clearNodeScope(jjtn000);
      jjtc000 = false;
    } else {
      jjtree.popNode();
    }
    if (jjte000 instanceof RuntimeException) {
      {if (true) throw (RuntimeException)jjte000;}
    }
    if (jjte000 instanceof ParseException) {
      {if (true) throw (ParseException)jjte000;}
    }
    if (jjte000 instanceof Exception) {
      {if (true) throw (Exception)jjte000;}
    }
    {if (true) throw (Error)jjte000;}
    } finally {
    if (jjtc000) {
      jjtree.closeNodeScope(jjtn000, true);
    }
    }
    throw new Error("Missing return statement in function");
  }

  static final public void parseDSL() throws ParseException, Exception {
    jj_consume_token(26);
    dslStatements();
    jj_consume_token(27);
  }

  static final public void dslStatements() throws ParseException, Exception {
    label_1:
    while (true) {
      dslLine();
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case IN:
      case OUT:
      case VAR:
        ;
        break;
      default:
        jj_la1[0] = jj_gen;
        break label_1;
      }
    }
  }

  static final public void dslLine() throws ParseException, Exception {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case IN:
    case OUT:
      dslDeclaration();
      jj_consume_token(SEMICOLON);
      break;
    case VAR:
      dslAtribution();
      jj_consume_token(SEMICOLON);
      break;
    default:
      jj_la1[1] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public Token dslDataType() throws ParseException {
  Token t;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case INT:
      t = jj_consume_token(INT);
      break;
    case FLOAT:
      t = jj_consume_token(FLOAT);
      break;
    case DOUBLE:
      t = jj_consume_token(DOUBLE);
      break;
    default:
      jj_la1[2] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    {if (true) return t;}
    throw new Error("Missing return statement in function");
  }

  static final public void dslDeclaration() throws ParseException, SemanticException {
  Token t1, t2, t3, t4;
  boolean gotRanged = false;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case IN:
      t1 = jj_consume_token(IN);
      t2 = dslDataType();
      t3 = jj_consume_token(VAR);
      jj_consume_token(LBRACKET);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case INTEGER:
        t4 = jj_consume_token(INTEGER);
      //MyVariable.rangeOnDeclaration = true;
      if (!MyVariable.checkRange(Integer.parseInt(t4.image))) {if (true) throw new SemanticException("Variable " + t3.image + " has a wrong range for a matrix (sqrt(" + t4.image + ") is valid for no. of rows).");}
      gotRanged = true;
      VariableStore.add(new MyVariable(t3.image, t2, t1, Integer.parseInt(t4.image)));
        break;
      default:
        jj_la1[3] = jj_gen;
        ;
      }
      jj_consume_token(RBRACKET);
    if (!gotRanged)
    {
      VariableStore.add(new MyVariable(t3.image, t2, t1, - 1));
    }
      break;
    case OUT:
      t1 = jj_consume_token(OUT);
      t2 = dslDataType();
      t3 = jj_consume_token(VAR);
      jj_consume_token(LBRACKET);
      jj_consume_token(RBRACKET);
    VariableStore.add(new MyVariable(t3.image, t2, t1, - 1));
      break;
    default:
      jj_la1[4] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void dslAtribution() throws ParseException, Exception {
 /*@bgen(jjtree) dslAtribution */
  SimpleNode jjtn000 = new SimpleNode(JJTDSLATRIBUTION);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);Token t, t1;
  Integer [ ] indxRange = null;
    try {
      t1 = dslVarAtr();
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case ASSIGN:
        t = jj_consume_token(ASSIGN);
        dslExpr();
        break;
      case LPAREN:
        indxRange = dslVarWithRange(t1);
        t = jj_consume_token(ASSIGN);
        dslExpr2();
        break;
      default:
        jj_la1[5] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    jjtree.closeNodeScope(jjtn000, true);
    jjtc000 = false;
    jjtn000.symbol = t.image;
    jjtn000.indicesRange = indxRange;
    int rangeDeclaration = VariableStore.getRange(jjtn000.symbol);
    if (indxRange != null)
      if (rangeDeclaration != -1 && rangeDeclaration <= jjtn000.indicesRange [ 1 ]) {if (true) throw new SemanticException("Range defined in operation bigger than range declared in declaration on variable " + jjtn000.symbol);}
    } catch (Throwable jjte000) {
    if (jjtc000) {
      jjtree.clearNodeScope(jjtn000);
      jjtc000 = false;
    } else {
      jjtree.popNode();
    }
    if (jjte000 instanceof RuntimeException) {
      {if (true) throw (RuntimeException)jjte000;}
    }
    if (jjte000 instanceof ParseException) {
      {if (true) throw (ParseException)jjte000;}
    }
    if (jjte000 instanceof Exception) {
      {if (true) throw (Exception)jjte000;}
    }
    if (jjte000 instanceof SemanticException) {
      {if (true) throw (SemanticException)jjte000;}
    }
    {if (true) throw (Error)jjte000;}
    } finally {
    if (jjtc000) {
      jjtree.closeNodeScope(jjtn000, true);
    }
    }
  }

  static final public Token dslVarAtr() throws ParseException, Exception {
  Token t;
    t = jj_consume_token(VAR);
    SimpleNode jjtn001 = new SimpleNode(JJTTERM);
    boolean jjtc001 = true;
    jjtree.openNodeScope(jjtn001);
    try {
    jjtree.closeNodeScope(jjtn001, true);
    jjtc001 = false;
    jjtn001.symbol = t.image;
    //VariableStore.dump();
    switch (VariableStore.checkVariable(t.image, false))
    {
      case 0 : {if (true) throw new ParseException("Variable " + t.image + " was not instantiated or is not a valid keyword.");}
      break;
      case 1 : {if (true) throw new SemanticException("Variable " + t.image + " is in the wrong call order. Should be used as input and not as output.");}
      break;
      default : break;
    }
    {if (true) return t;}
    } finally {
    if (jjtc001) {
      jjtree.closeNodeScope(jjtn001, true);
    }
    }
    throw new Error("Missing return statement in function");
  }

  static final public Token dslVar() throws ParseException, SemanticException {
  Token t;
    t = jj_consume_token(VAR);
    switch (VariableStore.checkVariable(t.image, true))
    {
      case 0 : {if (true) throw new ParseException("Variable " + t.image + " was not instantiated or is not a valid keyword.");}
      break;
      case 1 : {if (true) throw new SemanticException("Variable " + t.image + " is in the wrong call order. Should be used as output and not as input.");}
      break;
      default : break;
    }
    {if (true) return t;}
    throw new Error("Missing return statement in function");
  }

  static final public Integer [ ] dslVarWithRange(Token var) throws ParseException, SemanticException {
  Token t1, t2;
    jj_consume_token(LPAREN);
    t1 = jj_consume_token(INTEGER);
    jj_consume_token(COLON);
    t2 = jj_consume_token(INTEGER);
    jj_consume_token(RPAREN);
    //if (MyVariable.rangeOnDeclaration) throw new ParseException("Range Specified on Declaration. Specify it only in one place!");
    int r1, r2;
    if ((r1 = Integer.parseInt(t1.image)) >= (r2 = Integer.parseInt(t2.image))) {if (true) throw new SemanticException("Wrong Range Values.!" + r2 + " should be less than " + r1);}
    if (!MyVariable.checkRange((r2 + 1 - r1))) {if (true) throw new SemanticException("Variable has a wrong range (" + r1 + ":" + r2 + ") for a matrix (sqrt() is valid for no. of rows).");}
    Integer [ ] retorno = new Integer [ 2 ];
    retorno [ 0 ] = new Integer(r1);
    retorno [ 1 ] = new Integer(r2);
    {if (true) return retorno;}
    //if (Math.sqrt(r2-r1) == double) throw new SemanticException();
    //if (MyVariable.range < r + 1) MyVariable.range = r + 1;
    //VariableStore.setRange(var.image, r+1);

    throw new Error("Missing return statement in function");
  }

  static final public void dslExpr() throws ParseException, SemanticException {
 /*@bgen(jjtree) dslExpr */
  SimpleNode jjtn000 = new SimpleNode(JJTDSLEXPR);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);String s;
    try {
      dslTerm();
      s = dslTermTail();
    jjtree.closeNodeScope(jjtn000, true);
    jjtc000 = false;
    if (s != null) jjtn000.symbol = s;
    } catch (Throwable jjte000) {
    if (jjtc000) {
      jjtree.clearNodeScope(jjtn000);
      jjtc000 = false;
    } else {
      jjtree.popNode();
    }
    if (jjte000 instanceof RuntimeException) {
      {if (true) throw (RuntimeException)jjte000;}
    }
    if (jjte000 instanceof ParseException) {
      {if (true) throw (ParseException)jjte000;}
    }
    if (jjte000 instanceof SemanticException) {
      {if (true) throw (SemanticException)jjte000;}
    }
    {if (true) throw (Error)jjte000;}
    } finally {
    if (jjtc000) {
      jjtree.closeNodeScope(jjtn000, true);
    }
    }
  }

  static final public void dslTerm() throws ParseException, SemanticException {
 /*@bgen(jjtree) dslTerm */
  SimpleNode jjtn000 = new SimpleNode(JJTDSLTERM);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);String s;
    try {
      dslFactor();
      s = dslFactorTail();
    jjtree.closeNodeScope(jjtn000, true);
    jjtc000 = false;
    if (s != null) jjtn000.symbol = s;
    } catch (Throwable jjte000) {
    if (jjtc000) {
      jjtree.clearNodeScope(jjtn000);
      jjtc000 = false;
    } else {
      jjtree.popNode();
    }
    if (jjte000 instanceof RuntimeException) {
      {if (true) throw (RuntimeException)jjte000;}
    }
    if (jjte000 instanceof ParseException) {
      {if (true) throw (ParseException)jjte000;}
    }
    if (jjte000 instanceof SemanticException) {
      {if (true) throw (SemanticException)jjte000;}
    }
    {if (true) throw (Error)jjte000;}
    } finally {
    if (jjtc000) {
      jjtree.closeNodeScope(jjtn000, true);
    }
    }
  }

  static final public String dslTermTail() throws ParseException, SemanticException {
 /*@bgen(jjtree) dslTermTail */
  SimpleNode jjtn000 = new SimpleNode(JJTDSLTERMTAIL);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);Token t;
  String s;
    try {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case PLUS:
      case MINUS:
        t = dslAddOp();
        dslTerm();
        s = dslTermTail();
    jjtree.closeNodeScope(jjtn000, true);
    jjtc000 = false;
    //jjtThis.symbol = t.image;
    if (s != null) jjtn000.symbol = s;
    {if (true) return t.image;}
        break;
      default:
        jj_la1[6] = jj_gen;

    jjtree.closeNodeScope(jjtn000, true);
    jjtc000 = false;
    {if (true) return null;}
      }
    } catch (Throwable jjte000) {
    if (jjtc000) {
      jjtree.clearNodeScope(jjtn000);
      jjtc000 = false;
    } else {
      jjtree.popNode();
    }
    if (jjte000 instanceof RuntimeException) {
      {if (true) throw (RuntimeException)jjte000;}
    }
    if (jjte000 instanceof ParseException) {
      {if (true) throw (ParseException)jjte000;}
    }
    if (jjte000 instanceof SemanticException) {
      {if (true) throw (SemanticException)jjte000;}
    }
    {if (true) throw (Error)jjte000;}
    } finally {
    if (jjtc000) {
      jjtree.closeNodeScope(jjtn000, true);
    }
    }
    throw new Error("Missing return statement in function");
  }

  static final public void dslFactor() throws ParseException, SemanticException {
 /*@bgen(jjtree) dslFactor */
  SimpleNode jjtn000 = new SimpleNode(JJTDSLFACTOR);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);Token t;
    try {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case LPAREN:
        jj_consume_token(LPAREN);
        dslExpr();
        jj_consume_token(RPAREN);
        break;
      case VAR:
        t = dslVar();
      jjtree.closeNodeScope(jjtn000, true);
      jjtc000 = false;
      jjtn000.symbol = t.image;
        break;
      default:
        jj_la1[7] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    } catch (Throwable jjte000) {
    if (jjtc000) {
      jjtree.clearNodeScope(jjtn000);
      jjtc000 = false;
    } else {
      jjtree.popNode();
    }
    if (jjte000 instanceof RuntimeException) {
      {if (true) throw (RuntimeException)jjte000;}
    }
    if (jjte000 instanceof ParseException) {
      {if (true) throw (ParseException)jjte000;}
    }
    if (jjte000 instanceof SemanticException) {
      {if (true) throw (SemanticException)jjte000;}
    }
    {if (true) throw (Error)jjte000;}
    } finally {
    if (jjtc000) {
      jjtree.closeNodeScope(jjtn000, true);
    }
    }
  }

  static final public String dslFactorTail() throws ParseException, SemanticException {
 /*@bgen(jjtree) dslFactorTail */
  SimpleNode jjtn000 = new SimpleNode(JJTDSLFACTORTAIL);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);Token t;
  String s;
    try {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case STAR:
      case SLASH:
        t = dslMultOp();
        dslFactor();
        s = dslFactorTail();
      jjtree.closeNodeScope(jjtn000, true);
      jjtc000 = false;
      //jjtThis.symbol = t.image;
      if (s != null) jjtn000.symbol = s;
      {if (true) return t.image;}
        break;
      default:
        jj_la1[8] = jj_gen;

      jjtree.closeNodeScope(jjtn000, true);
      jjtc000 = false;
      {if (true) return null;}
      }
    } catch (Throwable jjte000) {
    if (jjtc000) {
      jjtree.clearNodeScope(jjtn000);
      jjtc000 = false;
    } else {
      jjtree.popNode();
    }
    if (jjte000 instanceof RuntimeException) {
      {if (true) throw (RuntimeException)jjte000;}
    }
    if (jjte000 instanceof ParseException) {
      {if (true) throw (ParseException)jjte000;}
    }
    if (jjte000 instanceof SemanticException) {
      {if (true) throw (SemanticException)jjte000;}
    }
    {if (true) throw (Error)jjte000;}
    } finally {
    if (jjtc000) {
      jjtree.closeNodeScope(jjtn000, true);
    }
    }
    throw new Error("Missing return statement in function");
  }

// Handling the variables having inline range defined  static final public void dslExpr2() throws ParseException, SemanticException {
 /*@bgen(jjtree) dslExpr2 */
  SimpleNode jjtn000 = new SimpleNode(JJTDSLEXPR2);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);String s;
    try {
      dslTerm2();
      s = dslTermTail2();
    jjtree.closeNodeScope(jjtn000, true);
    jjtc000 = false;
    if (s != null) jjtn000.symbol = s;
    } catch (Throwable jjte000) {
    if (jjtc000) {
      jjtree.clearNodeScope(jjtn000);
      jjtc000 = false;
    } else {
      jjtree.popNode();
    }
    if (jjte000 instanceof RuntimeException) {
      {if (true) throw (RuntimeException)jjte000;}
    }
    if (jjte000 instanceof ParseException) {
      {if (true) throw (ParseException)jjte000;}
    }
    if (jjte000 instanceof SemanticException) {
      {if (true) throw (SemanticException)jjte000;}
    }
    {if (true) throw (Error)jjte000;}
    } finally {
    if (jjtc000) {
      jjtree.closeNodeScope(jjtn000, true);
    }
    }
  }

  static final public void dslTerm2() throws ParseException, SemanticException {
 /*@bgen(jjtree) dslTerm2 */
  SimpleNode jjtn000 = new SimpleNode(JJTDSLTERM2);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);String s;
    try {
      dslFactor2();
      s = dslFactorTail2();
    jjtree.closeNodeScope(jjtn000, true);
    jjtc000 = false;
    if (s != null) jjtn000.symbol = s;
    } catch (Throwable jjte000) {
    if (jjtc000) {
      jjtree.clearNodeScope(jjtn000);
      jjtc000 = false;
    } else {
      jjtree.popNode();
    }
    if (jjte000 instanceof RuntimeException) {
      {if (true) throw (RuntimeException)jjte000;}
    }
    if (jjte000 instanceof ParseException) {
      {if (true) throw (ParseException)jjte000;}
    }
    if (jjte000 instanceof SemanticException) {
      {if (true) throw (SemanticException)jjte000;}
    }
    {if (true) throw (Error)jjte000;}
    } finally {
    if (jjtc000) {
      jjtree.closeNodeScope(jjtn000, true);
    }
    }
  }

  static final public String dslTermTail2() throws ParseException, SemanticException {
 /*@bgen(jjtree) dslTermTail2 */
  SimpleNode jjtn000 = new SimpleNode(JJTDSLTERMTAIL2);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);Token t;
  String s;
    try {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case PLUS:
      case MINUS:
        t = dslAddOp();
        dslTerm2();
        s = dslTermTail2();
    jjtree.closeNodeScope(jjtn000, true);
    jjtc000 = false;
    if (s != null) jjtn000.symbol = s;
    {if (true) return t.image;}
        break;
      default:
        jj_la1[9] = jj_gen;

    jjtree.closeNodeScope(jjtn000, true);
    jjtc000 = false;
    {if (true) return null;}
      }
    } catch (Throwable jjte000) {
    if (jjtc000) {
      jjtree.clearNodeScope(jjtn000);
      jjtc000 = false;
    } else {
      jjtree.popNode();
    }
    if (jjte000 instanceof RuntimeException) {
      {if (true) throw (RuntimeException)jjte000;}
    }
    if (jjte000 instanceof ParseException) {
      {if (true) throw (ParseException)jjte000;}
    }
    if (jjte000 instanceof SemanticException) {
      {if (true) throw (SemanticException)jjte000;}
    }
    {if (true) throw (Error)jjte000;}
    } finally {
    if (jjtc000) {
      jjtree.closeNodeScope(jjtn000, true);
    }
    }
    throw new Error("Missing return statement in function");
  }

  static final public void dslFactor2() throws ParseException, SemanticException {
 /*@bgen(jjtree) dslFactor2 */
  SimpleNode jjtn000 = new SimpleNode(JJTDSLFACTOR2);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);Token t;
  Integer [ ] indxRange;
    try {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case LPAREN:
        jj_consume_token(LPAREN);
        dslExpr2();
        jj_consume_token(RPAREN);
        break;
      case VAR:
        t = dslVar();
        indxRange = dslVarWithRange(t);
      jjtree.closeNodeScope(jjtn000, true);
      jjtc000 = false;
      jjtn000.symbol = t.image;
      jjtn000.indicesRange = indxRange;
      int rangeDeclaration = VariableStore.getRange(jjtn000.symbol);
      if (rangeDeclaration != -1 && rangeDeclaration <= jjtn000.indicesRange [ 1 ]) {if (true) throw new SemanticException("Range defined in operation bigger than range declared in declaration on variable " + jjtn000.symbol);}
        break;
      default:
        jj_la1[10] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    } catch (Throwable jjte000) {
    if (jjtc000) {
      jjtree.clearNodeScope(jjtn000);
      jjtc000 = false;
    } else {
      jjtree.popNode();
    }
    if (jjte000 instanceof RuntimeException) {
      {if (true) throw (RuntimeException)jjte000;}
    }
    if (jjte000 instanceof ParseException) {
      {if (true) throw (ParseException)jjte000;}
    }
    if (jjte000 instanceof SemanticException) {
      {if (true) throw (SemanticException)jjte000;}
    }
    {if (true) throw (Error)jjte000;}
    } finally {
    if (jjtc000) {
      jjtree.closeNodeScope(jjtn000, true);
    }
    }
  }

  static final public String dslFactorTail2() throws ParseException, SemanticException {
 /*@bgen(jjtree) dslFactorTail2 */
  SimpleNode jjtn000 = new SimpleNode(JJTDSLFACTORTAIL2);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);Token t;
  String s;
    try {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case STAR:
      case SLASH:
        t = dslMultOp();
        dslFactor2();
        s = dslFactorTail2();
      jjtree.closeNodeScope(jjtn000, true);
      jjtc000 = false;
      //jjtThis.symbol = t.image;
      if (s != null) jjtn000.symbol = s;
      {if (true) return t.image;}
        break;
      default:
        jj_la1[11] = jj_gen;

      jjtree.closeNodeScope(jjtn000, true);
      jjtc000 = false;
      {if (true) return null;}
      }
    } catch (Throwable jjte000) {
    if (jjtc000) {
      jjtree.clearNodeScope(jjtn000);
      jjtc000 = false;
    } else {
      jjtree.popNode();
    }
    if (jjte000 instanceof RuntimeException) {
      {if (true) throw (RuntimeException)jjte000;}
    }
    if (jjte000 instanceof ParseException) {
      {if (true) throw (ParseException)jjte000;}
    }
    if (jjte000 instanceof SemanticException) {
      {if (true) throw (SemanticException)jjte000;}
    }
    {if (true) throw (Error)jjte000;}
    } finally {
    if (jjtc000) {
      jjtree.closeNodeScope(jjtn000, true);
    }
    }
    throw new Error("Missing return statement in function");
  }

  static final public Token dslAddOp() throws ParseException {
  Token t;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case PLUS:
      t = jj_consume_token(PLUS);
      break;
    case MINUS:
      t = jj_consume_token(MINUS);
      break;
    default:
      jj_la1[12] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    {if (true) return t;}
    throw new Error("Missing return statement in function");
  }

  static final public Token dslMultOp() throws ParseException {
  Token t;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case STAR:
      t = jj_consume_token(STAR);
      break;
    case SLASH:
      t = jj_consume_token(SLASH);
      break;
    default:
      jj_la1[13] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    {if (true) return t;}
    throw new Error("Missing return statement in function");
  }

  static private boolean jj_initialized_once = false;
  /** Generated Token Manager. */
  static public DSLTokenManager token_source;
  static SimpleCharStream jj_input_stream;
  /** Current token. */
  static public Token token;
  /** Next token. */
  static public Token jj_nt;
  static private int jj_ntk;
  static private int jj_gen;
  static final private int[] jj_la1 = new int[14];
  static private int[] jj_la1_0;
  static {
      jj_la1_init_0();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x800060,0x800060,0x3800,0x200000,0x60,0x84000,0x180,0x804000,0x600,0x180,0x804000,0x600,0x180,0x600,};
   }

  /** Constructor with InputStream. */
  public DSL(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public DSL(java.io.InputStream stream, String encoding) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser.  ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new DSLTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 14; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jjtree.reset();
    jj_gen = 0;
    for (int i = 0; i < 14; i++) jj_la1[i] = -1;
  }

  /** Constructor. */
  public DSL(java.io.Reader stream) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new DSLTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 14; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jjtree.reset();
    jj_gen = 0;
    for (int i = 0; i < 14; i++) jj_la1[i] = -1;
  }

  /** Constructor with generated Token Manager. */
  public DSL(DSLTokenManager tm) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 14; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(DSLTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jjtree.reset();
    jj_gen = 0;
    for (int i = 0; i < 14; i++) jj_la1[i] = -1;
  }

  static private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }


/** Get the next Token. */
  static final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  static final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  static private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  static private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  static private int[] jj_expentry;
  static private int jj_kind = -1;

  /** Generate ParseException. */
  static public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[28];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 14; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 28; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  static final public void enable_tracing() {
  }

  /** Disable tracing. */
  static final public void disable_tracing() {
  }

}
