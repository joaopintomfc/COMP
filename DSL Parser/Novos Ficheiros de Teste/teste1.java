public class teste1 {
	
	private int[] A, B;
	private float[] C, resultado;
	
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
				1, 1, 1, 1,
				1, 1, 1, 1,
				1, 1, 1, 1,
				1, 1, 1, 1
			};
	}
	
	public float[] getExpected(){ return expected; }
	
	public float[] getResultado(){ return resultado; }
	
	public void doOperation(){
		loadVariables();
		
		/*@mat
		in int A[16];
		in int B[];
		in float C[];
		out float resultado[];

		resultado = A + B - (A * B) - C;
		
		 */
		
		//TODO: more code...
	}
	
}
