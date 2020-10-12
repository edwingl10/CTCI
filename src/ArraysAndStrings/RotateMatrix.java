package ArraysAndStrings;

public class RotateMatrix {
	/*
	 * Given an image represented by an NxN matrix, where each pixel in the image is 4 bytes, write 
	 * a method to rotate the image by 90 degrees. Can you do this in place?
	 */
	
	public static void Rotate(int[][] matrix) {
		if(matrix.length == 0 || matrix.length != matrix[0].length) {
			System.out.println("Not a square");
			return;
		}
		int N = matrix.length;
		
		for(int x=0; x<N/2; x++) {
			for(int y=x; y < N-x-1; y++) {
                int temp = matrix[x][y];  
                matrix[x][y] = matrix[y][N - 1 - x]; 
                matrix[y][N - 1 - x] = matrix[N - 1 - x][N - 1 - y]; 
                matrix[N - 1 - x][N - 1 - y] = matrix[N - 1 - y][x]; 
                matrix[N - 1 - y][x] = temp; 
			}
		}
		
	}
	
	public static int[][] createRandomMatrix(int N, int[] values) {
		int[][] matrix = new int[N][N];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				int rand = (int)(Math.random() * values.length);
				matrix[i][j] = values[rand];
			}
		}
		return matrix;
	}
	
	public static void printMatrix(int[][] matrix, int N) {
		for(int i=0; i< N; i++) {
			for(int j=0; j< N; j++) {
				System.out.print(matrix[i][j]+" | ");
			}
			System.out.println("\n");
		}
	}
	
	public static void main(String[] args) {
		int[][] matrix = createRandomMatrix(4, new int[] {1,2,3});
		System.out.println("ORIGINAL MATRIX");
		printMatrix(matrix, 4);
		System.out.println("ROTATED MATRIX");
		Rotate(matrix);
		printMatrix(matrix, 4);
	}
}
