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

        // Base case: first row = same as matrix first row
        for (int j = 0; j < n; j++) {
            dp[0][j] = matrix[0][j];
        }

        // Fill dp table row by row
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int leftDiagonal = (j > 0) ? dp[i - 1][j - 1] : Integer.MIN_VALUE;
                int straight     = dp[i - 1][j];
                int rightDiagonal= (j < n - 1) ? dp[i - 1][j + 1] : Integer.MIN_VALUE;

                dp[i][j] = matrix[i][j] + Math.max(straight, Math.max(leftDiagonal, rightDiagonal));
            }
        }

        // Answer = max value from last row
        int answer = Integer.MIN_VALUE;
        for (int j = 0; j < n; j++) {
            answer = Math.max(answer, dp[m - 1][j]);
        }

        System.out.println(answer);
    }
}
