public class teste10 {
	
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
				-4, -4, -4, -4,
				-4, -4, -4, -4,
				-4, -4, -4, -4,
				-4, -4, -4, -4
			};
	}
	
	public float[] getExpected(){ return expected; }
	
	public float[] getResultado(){ return resultado; }
	
	public void doOperation() throws SemanticException{
		loadVariables();
		

CustomMatrix.atribui(resultado,(((((((new CustomMatrix (A,4)).plus(new CustomMatrix (B,4))))).minus((((((new CustomMatrix (A,4)).times(new CustomMatrix (B,4)))))))))).minus(new CustomMatrix (C,4)).getArrayCopyfloat(), 16);
		
		//TODO: even more code...
	}
}
