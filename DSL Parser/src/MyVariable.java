public class MyVariable {
	public static boolean rangeOnDeclaration = false;
	public static int range = -1;
	public int rangeArray;
	public boolean multiplier;
	public String symbol;
	public Token type;
	public boolean input = true;
	
	public static void clear(){
		range = -1;
		rangeOnDeclaration = false;
	}
	
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
		if(input.image.equals("in")) this.input = true;
		else this.input = false;
		if( rangeOnDeclaration && this.input){
			if(rangeArray > range) range = rangeArray;
			else rangeArray = range;
		}
		//this.rangeArray = rangeArray;
		multiplier = false;
		
	}
	
	public String toString(){
		return new String((input? "in":"out") + " | "
							+ symbol + " | "
							+ rangeArray + " | "
							+ type.image);
	}
}
