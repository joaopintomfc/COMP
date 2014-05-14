import Jama.Matrix;


public class TesteJama {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		double[] array1 = { 1., 2., 3., 4., 5., 6., 7., 8., 10. };
		double[] A = null;
		double[] B = null;
		double[] Z = null;
		double[] C = null;
		Matrix teste1 = new Matrix(array1, 3);
		double[] array2 = { 10., 20., 30., 40., 50., 60., 70., 80., 100. };
		Matrix teste2 = new Matrix(array2, 3);

		// Matrix A = new Matrix(array);
		// Matrix b = Matrix.random(3,1);
		// Matrix x = A.solve(b);
		// Matrix Residual = A.times(x).minus(b);
		// double rnorm = Residual.normInf();
		// Matrix Result = teste1.times(teste2);
		Matrix Result = teste1.times(teste2);
		// teste1.
		Result.print(10, 2);

		/*double[][] D = ((new Matrix(A, 3)).times(((new Matrix(C, 3))
				.minus(new Matrix(Z, 3))).plus(new Matrix(B, 3))))
				.getArrayCopy();*/
		
		//Matrix teste = new Matrix(array1, 2);
		//System.out.print(teste.getColumnDimension());
		//CustomMatrix testeCM = new CustomMatrix(teste);
		//Matrix teste2 = new Matrix(array1, 4);
		//teste.

	}

}
