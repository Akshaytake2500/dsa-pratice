import java.util.*;
import java.lang.*;
class Main {
    public static void main(String[] args) {
        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int[] row : dp) Arrays.fill(row, -1);
        int answer = minPathSum(m-1,n-1,dp,grid);
        System.out.println(answer);
    }
    public static int minPathSum(int row, int col, int[][] dp, int[][] grid) {
        if (row == 0 && col == 0) return grid[row][col];
        if (row < 0 || col < 0) return Integer.MAX_VALUE;

        if (dp[row][col] != -1) return dp[row][col];

        int up = minPathSum(row-1, col, dp, grid);
        int left = minPathSum(row, col-1, dp, grid);

        return dp[row][col] = grid[row][col] + Math.min(up, left);
    }
}