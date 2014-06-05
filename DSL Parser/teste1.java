public class teste1 {
	
	private int[] A, B;
	private float[] C, resultado = new float[16];
	
	/* Para testes */
	private float expected[];
	
	private void loadVariables(){
		/* Resultado */
		resultado = new float[] {	
				0, 0, 0, 0,
				0, 0, 0, 0,
				0, 0, 0, 0,
				0, 0, 0, 0
			};
		
		/* Matriz A */
		A = new int[] {	
				1, 2, 2, 2,
				2, 1, 1, 1,
				1, 1, 1, 1,
				2, 2, 2, 2
			};
		
		/* Matrix B */
		B = new int[]{	
				1, 1, 1, 1,
				1, 1, 1, 1,
				1, 1, 2, 2,
				2, 2, 1, 1
			};
		
		/* Matrix C */;
		C = new float[]{	
				1, 1, 1, 1,
				2, 2, 2, 2,
				2, 2, 2, 2,
				2, 2, 2, 2
			};
		
		/* Matriz expected - For testing purposes */
		expected = new float[]{		
				0, 0, 0, 0,
				0, 24, 24, 24,
				24, 0, 0, 0,
				0, 0, 0, 0
			};
	}
	
	public float[] getExpected(){ return expected; }
	
	public float[] getResultado(){ return resultado; }
	
	public void doOperation() throws SemanticException{
		loadVariables();
		
		/*@mat
		in int A[16];
		in int B[];
		in float C[];
		out float resultado[];

		resultado(5:8) = ((A(1:4) + B(10:13)) * (A(12:15) + C(0:3)));
		
		 */
		
		//TODO: even more code...
	}
}