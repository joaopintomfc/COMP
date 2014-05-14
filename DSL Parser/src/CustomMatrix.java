import java.util.Arrays;

import Jama.Matrix;


public class CustomMatrix {

	Matrix m;
	//int nColumns, nRows;
	
	public CustomMatrix(double[] arg0, int nColumnsAndNRows) {
		double [] array = Arrays.copyOf(arg0, nColumnsAndNRows*nColumnsAndNRows);
		//nRows = nColumns = nColumnsAndNRows;
		m = new Matrix(array, nColumnsAndNRows);
	}
	
	public CustomMatrix(double[] arg0, int nColumns, int nRows) {
		double [] array = Arrays.copyOf(arg0, nColumns*nRows);
		//this.nColumns = nColumns;
		//this.nRows = nRows;
		m = new Matrix(array, nColumns);
	}
	
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
		//http://www.wikihow.com/Divide-Matrices
		return new CustomMatrix(this.m.times(c.m.inverse()));
	}
	
	public double[] getArrayCopydouble() {
		double [][] array2d = m.getArrayCopy();
		
		double [] array1d = new double[m.getColumnDimension()*m.getRowDimension()];
		
		for(int i = 0; i < array2d.length; i++) {
			for (int a = 0; a < array2d[i].length; a++) {
				array1d[a+i*array2d[i].length] = array2d[i][a]; 
			}
		}
		
		return array1d;
	}
	
	public float[] getArrayCopyfloat() {
		double [][] array2d = m.getArrayCopy();
		
		float [] array1d = new float[m.getColumnDimension()*m.getRowDimension()];
		
		for(int i = 0; i < array2d.length; i++) {
			for (int a = 0; a < array2d[i].length; a++) {
				array1d[a+i*array2d[i].length] = (float) array2d[i][a]; 
			}
		}
		
		return array1d;
	}
	
	public int[] getArrayCopyint() {
		double [][] array2d = m.getArrayCopy();
		
		int [] array1d = new int[m.getColumnDimension()*m.getRowDimension()];
		
		for(int i = 0; i < array2d.length; i++) {
			for (int a = 0; a < array2d[i].length; a++) {
				array1d[a+i*array2d[i].length] = (int) array2d[i][a]; 
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
