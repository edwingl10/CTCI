package ArraysAndStrings;

public class ZeroMatrix {
/*
 * write an algorithm such that if an element in an MxN matrix is 0, its entire row and column are set to 0.
 */
	
	public static void setMatrix(int[][] matrix) {
		int M= matrix.length;
		int N = matrix[0].length;
		
		//use the first cell in the row and top cell in the column as flags 
		for(int i=0; i<M; i++) {
			for(int j=0; j<N; j++) {
				if(matrix[i][j] == 0) {
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}
		//use the flags in the matrix to convert values to 0
		convertMatrix(matrix);
		
	}
	
	private static void convertMatrix(int[][] matrix) {
		int ROWS = matrix.length;
		int COLUMNS = matrix[0].length;
		
		for(int row=1; row<ROWS; row++) {
			if(matrix[row][0] == 0) {
				for(int col=0;col<COLUMNS;col++) {
					matrix[row][col] =0;
				}
			}
		}
		
		for(int col=0; col<COLUMNS; col++) {
			if(matrix[0][col] == 0) {
				for(int row=1; row<ROWS; row++) {
					matrix[row][col] = 0;
				}
			}
		}
		
		if(matrix[0][0] == 0) {
			for(int col=0; col<COLUMNS; col++) {
				matrix[0][col] =0;
			}
		}
	}
	
	public static int[][] createRandomMatrix(int M, int N, int[] values) {
		int[][] matrix = new int[M][N];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				int rand = (int)(Math.random() * values.length);
				matrix[i][j] = values[rand];
			}
		}
		return matrix;
	}
	
	public static void printMatrix(int[][] matrix) {
		int M = matrix.length;
		int N = matrix[0].length;
		
		for(int i=0; i< M; i++) {
			for(int j=0; j< N; j++) {
				System.out.print(matrix[i][j]+" | ");
			}
			System.out.println("\n");
		}
	}
	
	public static void main(String[] args) {
		int[][] matrix = createRandomMatrix(3,3, new int[] {0,1,2,3,4,5});
		System.out.println("Original Matrix");
		printMatrix(matrix);
		
		setMatrix(matrix);
		System.out.println("Zero Matrix");
		printMatrix(matrix);
	}
}
