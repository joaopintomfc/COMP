import static org.junit.Assert.*;

import org.junit.Test;


public class SimpleTests {

	@Test
	public void test1() throws SemanticException {
		teste1 teste1 = new teste1();
		
		// Do the math
		teste1.doOperation();
		
		assertArrayEquals(teste1.getExpected(), teste1.getResultado(), (float) 0.01);
		
	}
	
	@Test
	public void test8() throws SemanticException {
		teste8 test8 = new teste8();
		
		// Do the math
		test8.doOperation();
		
		assertArrayEquals(test8.getExpected(), test8.getResultado(), (float) 0.01);
		
	}
	
	
	
	@Test
	public void test9() throws SemanticException {
		teste9 test9 = new teste9();
		
		// Do the math
		test9.doOperation();
		
		assertArrayEquals(test9.getExpected(), test9.getResultado(), (float) 0.01);
		
	}
	
	@Test
	public void test10() throws SemanticException {
		teste10 test10 = new teste10();
		
		// Do the math
		test10.doOperation();
		
		assertArrayEquals(test10.getExpected(), test10.getResultado(), (float) 0.01);
		
	}

}
