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
	
	public Generator(File file, SimpleNode ast) throws IOException, SemanticException{
		in = new BufferedReader(new FileReader(file));
		File dir = new File("output/");
		dir.mkdirs();
		File f = new File("output/"+file.getName());
		f.createNewFile();
		out = new BufferedWriter(new FileWriter(f));
		generate(ast);
		write();
		in.close();
		out.close();
		
	}
	
	/**
	 * Generates the code
	 * @param ast 
	 * @throws SemanticException 
	 */
	public void generate(SimpleNode ast) throws SemanticException{
		generatedCode = ast.getCode();
	}
	
	/**
	 * Writes the generated code to the file along with the original code from the source file
	 * @throws IOException 
	 */
	public void write() throws IOException{
		boolean stop = false;
		do{
			String read = in.readLine();
			if(read == null) break;
			if(read.contains("/*@mat")){
				String[] lastTop = read.split(new String("/*@mat"));
				for(int i=0; i<lastTop[0].trim().length()-2; i++){
					out.write(lastTop[0].trim().charAt(i));
				}	
				stop = true;
				out.write(String.format("%n"));
			}else{
				out.write(read+String.format("%n"));
			}

		}while(!stop);
		
		out.write(generatedCode);
		//out.write("hello"+String.format("%n"));
		
		stop=false;
		do{
			String read = in.readLine();
			if(read == null) break;
			if(read.contains("*/")){
				String[] lastDsl = read.split(new String("\\*/"));
				stop=true;
				if(lastDsl.length > 1) out.write(lastDsl[1].trim()+String.format("%n"));
			}
		}while(!stop);
		
		stop=false;
		do{
			String read = in.readLine();
			if(read == null) break;
			else out.write(read+String.format("%n"));
		}while(!stop);
	}

	public static String extractDSLCode(File file) throws IOException{
		BufferedReader in;
		BufferedWriter out;
		in = new BufferedReader(new FileReader(file));
		File dir = new File("temp/");
		dir.mkdir();
		String filename = new String("temp/"+file.getName());
		out = new BufferedWriter(new FileWriter(new File(filename)));
		
		boolean stop = false;
		do{
			String read = in.readLine();
			if(read == null) break;
			if(read.contains("/*@mat")){
				String[] lastTop = read.split(new String("/*@mat"));
				for(int i=lastTop[0].trim().length()-2; i<lastTop[0].trim().length(); i++){
					out.write(lastTop[0].trim().charAt(i));
				}
				out.write("@mat");
				stop = true;
				out.write(String.format("%n"));
			}
		}while(!stop);
		
		stop=false;
		do{
			String read = in.readLine();
			if(read == null) break;
			if(read.contains("*/")){
				String[] lastDsl = read.split(new String("\\*/"));
				stop=true;
				if(lastDsl.length != 0)out.write(lastDsl[0].trim()+String.format("%n"));
				out.write("*/");
			}else{
				out.write(read+String.format("%n"));
			}
		}while(!stop);
		in.close();
		out.close();
		return filename;
	}
}
