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
		generate(ast);
		write();
		in.close();
		out.close();
	}
	
	/**
	 * Generates the code
	 * @param ast 
	 */
	public void generate(SimpleNode ast){
		
	}
	
	/**
	 * Writes the generated code to the file along with the original code from the source file
	 * @throws IOException 
	 */
	public void write() throws IOException{
		/*boolean stop = false;
		do{
			String read = in.readLine();
			
			if(read.contains("/*@mat")){
				String[] lastTop = read.split("/*@mat");
				out.write(lastTop[0].trim());
			}else{
				out.write(read);
			}

		}while(!stop);*/
	}
	
	public void main(String[] args){
		try {
			Generator g = new Generator(new File("input/test3.java"), new SimpleNode(1));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
