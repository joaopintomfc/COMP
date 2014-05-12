import java.util.Vector;

public class VariableStore {
	private static Vector<MyVariable> storage = new Vector<MyVariable>();
	
	public static boolean hasVariable(String symbol, boolean input){
		for(MyVariable Var : storage){
			if(Var.symbol.equals(symbol) && Var.input == input)
				return true;
		}
		return false;
	}
	
	public static void add(MyVariable var){
		storage.add(var);
	}
	
	public static void clear(){
		storage.clear();
	}
	
	public static void dump(){
		for(MyVariable var : storage){
			System.out.println(var);
		}
	}
}
