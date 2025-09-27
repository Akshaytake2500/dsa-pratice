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

        int answer = Integer.MIN_VALUE;
        for (int col = 0; col < n; col++) {
            answer = Math.max(answer, maxPathSum(m - 1, col, matrix));
        }

        System.out.println(answer);
    }

    public static int maxPathSum(int row, int col, int[][] matrix) {
        if (col < 0 || col >= matrix[0].length) return Integer.MIN_VALUE;

        if (row == 0) return matrix[row][col];

        int leftDiagonal  = matrix[row][col] + maxPathSum(row - 1, col - 1, matrix);
        int straight      = matrix[row][col] + maxPathSum(row - 1, col, matrix);
        int rightDiagonal = matrix[row][col] + maxPathSum(row - 1, col + 1, matrix);

        return Math.max(straight, Math.max(leftDiagonal, rightDiagonal));
    }
}
