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
				0, 0, 0, 0,
				0, 0, 0, 0,
				0, 0, 0, 0,
				0, 0, 0, 0,
			};
	}
	
	public float[] getExpected(){ return expected; }
	
	public float[] getResultado(){ return resultado; }
	
	public void doOperation() throws SemanticException{
		loadVariables();
		

CustomMatrix.atribui(resultado,(new CustomMatrix (A,0,15)).plus(new CustomMatrix (B,0,15)).minus((((new CustomMatrix (A,0,15)).times(new CustomMatrix (B,0,15)))).minus(new CustomMatrix (C,0,15))).getArrayCopyfloat(), 0,15);
		
		//TODO: even more code...
	}
}
