import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 
 * @author Mike
 * Class responsible for generating the dsl given an IR
 */
public class Generator {
	BufferedReader in;
	BufferedWriter out;
	String generatedCode;
	
	public Generator(File file, SimpleNode ast) throws IOException{
		in = new BufferedReader(new FileReader(file));
		out = new BufferedWriter(new FileWriter("output/"+file.getName()));
		generate();
		write();
		in.close();
		out.close();
	}
	
	/**
	 * Generates the code
	 */
	public void generate(){
		
	}
	
	/**
	 * Writes the generated code to the file along with the original code from the source file
	 * @throws IOException 
	 */
	public void write() throws IOException{
		boolean stop = false;
		int limitTop = 0;
		do{
			int v = in.read();
			char c = (char) v;
			
			if(c == '/'){
				in.mark(0); // 
				switch(c){
				
				}
			}else{
				out.write(v);
			}
			stop=true;
		}while(!stop);
	}
}
