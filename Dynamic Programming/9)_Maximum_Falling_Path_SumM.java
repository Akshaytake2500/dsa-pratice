import java.util.*;

class Main {
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 10, 4},
            {100, 3, 2, 1},
            {1, 1, 20, 2},
            {1, 2, 2, 1}
        };
        int m = matrix.length;
        int n = matrix[0].length;
        
        int[][] dp = new int[m][n];
        for(int[] rows : dp){
            Arrays.fill(rows, -1);
        }
        
        int answer = Integer.MIN_VALUE;
        for (int col = 0; col < n; col++) {
            answer = Math.max(answer, maxPathSum(m - 1, col, matrix, dp));
        }

        System.out.println(answer);
    }

    public static int maxPathSum(int row, int col, int[][] matrix, int[][] dp) {
        if (col < 0 || col >= matrix[0].length) return Integer.MIN_VALUE;

        if (row == 0) return matrix[row][col];
        
        if(dp[row][col] != -1) return dp[row][col];

        int leftDiagonal  = matrix[row][col] + maxPathSum(row - 1, col - 1, matrix, dp);
        int straight      = matrix[row][col] + maxPathSum(row - 1, col, matrix, dp);
        int rightDiagonal = matrix[row][col] + maxPathSum(row - 1, col + 1, matrix, dp);

        return dp[row][col] = Math.max(straight, Math.max(leftDiagonal, rightDiagonal));
    }
}
