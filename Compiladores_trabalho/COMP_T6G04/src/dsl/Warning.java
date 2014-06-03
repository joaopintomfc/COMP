package dsl;
import java.util.Vector;


public class Warning {
	private static Vector<String> warnings = new Vector<String>();
	
	public static void push(String warning){
		warnings.add(warning);
	}
	
	public static void dump(){
		for(String s : warnings){
			System.out.println(":: Warning :: " + s);
		}
	}
	
	public static void clear(){
		warnings.clear();
	}
}
