
public class MyVariable {
	public static boolean rangeOnDeclaration = false;
	public int rangeArray;
	public boolean multiplier;
	public String symbol;
	public Token type;
	
	// for multiplier declaration
	public MyVariable(String symbol, Token type){
		this.symbol = symbol;
		this.type = type;
		multiplier = true;
	}
	
	// for matrix/vector declaration
	public MyVariable(String symbol, Token type, int rangeArray){
		this.symbol = symbol;
		this.type = type;
		this.rangeArray = rangeArray;
		multiplier = false;
	}
}
