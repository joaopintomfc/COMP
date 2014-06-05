


public interface Node {
	public void setSymbol(String s);

	public String getSymbol();

	public void setSymbolParent(String s);

	public void deleteChild(int i);

	public void deleteChild(Node n);

	public boolean deleteUninterestingNodes();

	public void appendChild(Node n);

	public String getCode() throws SemanticException;

	/**
	 * This method is called after the node has been made the current node. It
	 * indicates that child nodes can now be added to it.
	 */
	public void jjtOpen();

	/**
	 * This method is called after all the child nodes have been added.
	 */
	public void jjtClose();

	/**
	 * This pair of methods are used to inform the node of its parent.
	 */
	public void jjtSetParent(Node n);

	public Node jjtGetParent();

	/**
	 * This method tells the node to add its argument to the node's list of
	 * children.
	 */
	public void jjtAddChild(Node n, int i);

	/**
	 * This method returns a child node. The children are numbered from zero,
	 * left to right.
	 */
	public Node jjtGetChild(int i);

	/** Return the number of children the node has. */
	public int jjtGetNumChildren();

	public String getCodeAux(int raizRangeMinVarsAtribuicao)
			throws SemanticException;

	public int getRange() throws SemanticException;

	public String getType();

	public boolean deleteFactorAfterTerm();

	public void addChild(Node node, int i);
}
/*
 * JavaCC - OriginalChecksum=51a365986f30b3d8da41a4f7d049ee04 (do not edit this
 * line)
 */
