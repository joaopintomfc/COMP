public class teste8 {
	
	private int[] A, B;
	private float[] C, resultado = new float[16];
	
	/* Para testes */
	private float expected[];
	
	private void loadVariables(){
		
		/* Matriz A */
		A = new int[] {	
				1, 1, 1, 1,
				1, 1, 1, 1,
				1, 1, 1, 1,
				1, 1, 1, 1
			};
		
		/* Matrix B */
		B = new int[]{	
				1, 1, 1, 1,
				1, 1, 1, 1,
				1, 1, 1, 1,
				1, 1, 1, 1
			};
		
		/* Matrix C */;
		C = new float[]{	
				2, 2, 2, 2,
				2, 2, 2, 2,
				2, 2, 2, 2,
				2, 2, 2, 2
			};
		
		/* Matriz expected - For testing purposes */
		expected = new float[]{	
				-1, -1, -1, -1,
				-1, -1, -1, -1,
				-1, -1, -1, -1,
				-1, -1, -1, -1
			};
	}
	
	public float[] getExpected(){ return expected; }
	
	public float[] getResultado(){ return resultado; }
	
	public void doOperation() throws SemanticException{
		loadVariables();
		
		/*@mat
		in int A[];
		in int B[];
		in float C[];
		out float resultado[];

		resultado(0:15) = A(0:15) + B(0:15) - (( A(0:15) * B(0:15) ) - C(0:15));
		
		 */
		
		//TODO: even more code...
	}
}