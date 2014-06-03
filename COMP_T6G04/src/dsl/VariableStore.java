package dsl;
import java.util.Vector;

public class VariableStore {
	private static Vector<MyVariable> storage = new Vector<MyVariable>();
	
	public static int checkVariable(String symbol, boolean input){
		int i=0;
		
		for(MyVariable Var : storage){
			if(Var.symbol.equals(symbol)){
				i++;
				if(Var.input == input) 
					i++;
				return i;
			}
		}
		return i;
	}
	
	public static void add(MyVariable var){
		storage.add(var);
	}
	
	public static void setRange(String symbol, int range){
		for(MyVariable Var : storage){
			if(Var.symbol.equals(symbol))
				Var.rangeArray = range;
		}
	}
	
	public static int getRange(String symbol) {
		for(MyVariable Var : storage){
			if(Var.symbol.equals(symbol)) {
				//if ()
				return Var.rangeArray;
			}
		}
		return -1;
	}
	
	public static void clear(){
		storage.clear();
	}
	
	public static String getType(String symbol) {
		for(MyVariable Var : storage){
			if(Var.symbol.equals(symbol)) {
				return Var.type.image;
			}
		}
		return null;
	}
	
	public static void dump(){
		for(MyVariable var : storage){
			System.out.println(var);
		}
	}
}
