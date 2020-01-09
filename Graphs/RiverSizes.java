import java.util.*;

public class RiverSizes {
	public static List<Integer> riverSizes(int[][] matrix) {
		// Write your code here.
			List<Integer> size = new ArrayList<>();
			for(int i=0; i<matrix.length; i++){
				for(int j=0;j<matrix[i].length; j++){
						if(matrix[i][j] == 1){
							size.add(findSize(i, j, matrix)+1);
						}
				}
			}
		return size;
	}
	private static int findSize(int i, int j, int[][] matrix){
		matrix[i][j] = 0;
		int count = 0;
		int[][] points = {{0,1}, {1,0}, {-1,0}, {0,-1}};
		
		for(int[] point : points){
			int newI = i+point[0]; int newJ = j+point[1];
			if(newI < 0 || newI >= matrix.length || newJ < 0 || newJ >= matrix[i].length){
				continue;
			}
			if(matrix[newI][newJ] == 1){
				count += findSize(newI,newJ, matrix) + 1;
			}
		}

		return count;
	}

	public static void main(String[] args){
		int[][] matrix = {{1,0,0,1,0},{1,0,1,0,0},{0,0,1,0,1},{1,0,1,0,1},{1,0,1,1,0}};
		RiverSizes rs = new RiverSizes();
		System.out.println("Size of rivers are : " + rs.riverSizes(matrix).toString());
	}
}
