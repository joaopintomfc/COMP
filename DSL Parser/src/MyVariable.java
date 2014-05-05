public class MyVariable {
	public static boolean rangeOnDeclaration = false;
	public int rangeArray;
	public boolean multiplier;
	public String symbol;
	public Token type;
	public boolean input = true;
	
	// for multiplier declaration
	public MyVariable(String symbol, Token type){
		this.symbol = symbol;
		this.type = type;
		multiplier = true;
	}
	
	// for matrix/vector declaration
	public MyVariable(String symbol, Token type, Token input, int rangeArray) throws ParseException{
		this.symbol = symbol;
		this.type = type;
		if( rangeArray != -1 && rangeOnDeclaration ) throw new ParseException("Array range missing");
		this.rangeArray = rangeArray;
		multiplier = false;
		if(input.image.equals("in")) this.input = true;
		else this.input = false;
	}
}
