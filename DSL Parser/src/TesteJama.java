import Jama.Matrix;


public class TesteJama {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		double[] array1 = {1.,2.,3.,4.,5.,6.,7.,8.,10.};
		Matrix teste1 = new Matrix(array1, 3);
		double[] array2 = {10.,20.,30.,40.,50.,60.,70.,80.,100.};
		Matrix teste2 = new Matrix(array2, 3);
		
		//Matrix A = new Matrix(array);
		//Matrix b = Matrix.random(3,1);
		//Matrix x = A.solve(b);
		//Matrix Residual = A.times(x).minus(b);
		//double rnorm = Residual.normInf();
		//Matrix Result = teste1.times(teste2);
		Matrix Result = teste1.times(teste2);
		//teste1.
		Result.print(3, 2);

	}

}
