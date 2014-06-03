package dsl;

public class SemanticException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3760597857150568472L;

	public SemanticException() { super(); }
	public SemanticException(String message) { super(message); }
	public SemanticException(String message, Throwable cause) { super(message, cause); }
	public SemanticException(Throwable cause) { super(cause); }
}
