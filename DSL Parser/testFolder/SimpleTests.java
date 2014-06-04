import static org.junit.Assert.*;

import org.junit.Test;

import dsl.SemanticException;


public class SimpleTests {

	@Test
	public void test() throws SemanticException {
		teste1 teste1 = new teste1();
		
		// Do the math
		teste1.doOperation();
		
		assertArrayEquals(teste1.getExpected(), teste1.getResultado(), (float) 0.01);
		
	}

}
