package dsl;
import java.util.Arrays;

import Jama.Matrix;

public class CustomMatrix {

	Matrix m;

	// int nColumns, nRows;

	public static void atribui(double[] result, double[] input, int range) {
		atribui(result, input, 0, range-1);
	}

	public static void atribui(double[] result, double[] input, int indexBegin, int indexEnd) {
		for (int i = indexBegin; i <= indexEnd; i++) {
			result[i] = input[i-indexBegin];
		}
	}
	
	public static void atribui(float[] result, float[] input, int range) {
		atribui(result, input, 0, range-1);
	}
	
	public static void atribui(float[] result, float[] input, int indexBegin, int indexEnd) {
		for (int i = indexBegin; i <= indexEnd; i++) {
			result[i] = input[i-indexBegin];
		}
	}

	public static void atribui(int[] result, int[] input, int indexBegin, int indexEnd) {
		for (int i = indexBegin; i <= indexEnd; i++) {
			result[i] = input[i-indexBegin];
		}
	}
	
	public static void atribui(int[] result, int[] input, int range) {
		atribui(result, input, 0, range-1);
	}

	

	public CustomMatrix(double[] arg0, int nColumnsAndNRows)
			throws SemanticException {
		if (nColumnsAndNRows * nColumnsAndNRows > arg0.length)
			throw new SemanticException(
					"Array with size of declaration insufficient");
		double[] array = Arrays.copyOf(arg0, nColumnsAndNRows
				* nColumnsAndNRows);
		// nRows = nColumns = nColumnsAndNRows;
		m = new Matrix(array, nColumnsAndNRows);
	}

	public CustomMatrix(double[] arg0, int indBegin, int indEnd)
			throws SemanticException {

		if (arg0.length <= indEnd)
			throw new SemanticException(
					"Array with size of declaration insufficient");
		double[] array = Arrays.copyOfRange(arg0, indBegin, indEnd);
		int sqrtRange = (int) Math.sqrt(indEnd + 1 - indBegin);

		m = new Matrix(array, sqrtRange);
	}

	public CustomMatrix(int[] arg0, int indBegin, int indEnd)
			throws SemanticException {

		if (arg0.length <= indEnd)
			throw new SemanticException(
					"Array with size of declaration insufficient");
		double[] array = new double[indEnd + 1];

		for (int i = indBegin; i <= indEnd; i++) {
			array[i - indBegin] = arg0[i];
		}

		int sqrtRange = (int) Math.sqrt(indEnd + 1 - indBegin);

		m = new Matrix(array, sqrtRange);

	}

	public CustomMatrix(float[] arg0, int indBegin, int indEnd)
			throws SemanticException {

		if (arg0.length <= indEnd)
			throw new SemanticException(
					"Array with size of declaration insufficient");
		double[] array = new double[indEnd + 1];

		for (int i = indBegin; i <= indEnd; i++) {
			array[i - indBegin] = arg0[i];
		}

		int sqrtRange = (int) Math.sqrt(indEnd + 1 - indBegin);

		m = new Matrix(array, sqrtRange);

	}

	/*
	 * public CustomMatrix(double[] arg0, int nColumns, int nRows) { double []
	 * array = Arrays.copyOf(arg0, nColumns*nRows); //this.nColumns = nColumns;
	 * //this.nRows = nRows; m = new Matrix(array, nColumns); }
	 */
	public CustomMatrix(Matrix m) {
		this.m = m;
	}

	public CustomMatrix minus(CustomMatrix c) {
		return new CustomMatrix(this.m.minus(c.m));
	}

	public CustomMatrix plus(CustomMatrix c) {
		return new CustomMatrix(this.m.plus(c.m));
	}

	public CustomMatrix times(CustomMatrix c) {
		return new CustomMatrix(this.m.times(c.m));
	}

	public CustomMatrix divide(CustomMatrix c) {
		// http://www.wikihow.com/Divide-Matrices
		return new CustomMatrix(this.m.times(c.m.inverse()));
	}

	public double[] getArrayCopydouble() {
		double[][] array2d = m.getArrayCopy();

		double[] array1d = new double[m.getColumnDimension()
				* m.getRowDimension()];

		for (int i = 0; i < array2d.length; i++) {
			for (int a = 0; a < array2d[i].length; a++) {
				array1d[a + i * array2d[i].length] = array2d[i][a];
			}
		}

		return array1d;
	}

	public float[] getArrayCopyfloat() {
		double[][] array2d = m.getArrayCopy();

		float[] array1d = new float[m.getColumnDimension()
				* m.getRowDimension()];

		for (int i = 0; i < array2d.length; i++) {
			for (int a = 0; a < array2d[i].length; a++) {
				array1d[a + i * array2d[i].length] = (float) array2d[i][a];
			}
		}

		return array1d;
	}

	public int[] getArrayCopyint() {
		double[][] array2d = m.getArrayCopy();

		int[] array1d = new int[m.getColumnDimension() * m.getRowDimension()];

		for (int i = 0; i < array2d.length; i++) {
			for (int a = 0; a < array2d[i].length; a++) {
				array1d[a + i * array2d[i].length] = (int) array2d[i][a];
			}
		}

		return array1d;
	}

	public void print() {
		m.print(10, 3);
	}

	public void print(int larguraColunasMatrizNoPrint, int precisaoDecimal) {
		m.print(larguraColunasMatrizNoPrint, precisaoDecimal);
	}

}
