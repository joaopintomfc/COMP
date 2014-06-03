public Teste1 {
	
	private int[] A, B;
	private float[] C, resultado;
	
	private void loadVariables(){
		//TODO: code...
	}
	
	public void doOperation(){
		//TODO: more code...
		

CustomMatrix.atribui(resultado,((((new CustomMatrix (C,4)).minus((new CustomMatrix (A,4)).times(new CustomMatrix (B,4)))).minus(new CustomMatrix (B,4))).plus(new CustomMatrix (A,4))).getArrayCopyfloat(), 16);
CustomMatrix.atribui(resultado2,((new CustomMatrix (B,0,15)).plus(new CustomMatrix (C,0,15))).getArrayCopyfloat(), 0,15);
		
		//TODO: even more code...
	}
	
}
