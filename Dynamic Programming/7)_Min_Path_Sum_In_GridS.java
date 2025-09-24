import java.util.*;
import java.lang.*;

class Main {
    public static void main(String[] args) {
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        int answer = minPathSum(grid);
        System.out.println(answer); // Expected: 7
    }

    public static int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[] prev = new int[n];

        for (int i = 0; i < m; i++) {
            int[] curr = new int[n];
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    curr[j] = grid[i][j];
                } else {
                    int up = i > 0 ? prev[j] : Integer.MAX_VALUE;
                    int left = j > 0 ? curr[j - 1] : Integer.MAX_VALUE;
                    curr[j] = grid[i][j] + Math.min(up, left);
                }
            }
            prev = curr; // Move current row into previous
        }

        return prev[n - 1];
    }
}
