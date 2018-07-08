package TreesAndGraphs;

public class PondsOrIslandsDFS {

	public static void main(String[] args) {
		String[] inputs = {"11111","10001","10101","10001","11111"};
		char[][] grid = new char[inputs.length][inputs[0].length()];
		int row = 0;
		for(String s:inputs) {
			char[] thisRow = s.toCharArray();
			grid[row] = thisRow;
			row++;
		}
		System.out.println(numIslands(grid));
	}
	public static int numIslands(char[][] grid) {
		int islands = 0;
		for(int row=0;row<grid.length;row++) {
			for(int col=0;col<grid[0].length;col++) {
				if(grid[row][col] =='1') {
					markIslandBoundary(grid,row,col);
					islands++;
				}
			}
		}
		return islands;
	}

	private static void markIslandBoundary(char[][] grid, int row, int col) {
		if((row<0)||(row>grid.length-1)||(col<0)||(col>grid[0].length-1))
			return;
		if(grid[row][col]=='1') {
		grid[row][col]='x';//mark visited
		markIslandBoundary(grid,row,col-1);
		markIslandBoundary(grid,row,col+1);
		markIslandBoundary(grid,row-1,col);
		markIslandBoundary(grid,row+1,col);
		}
	}
}
