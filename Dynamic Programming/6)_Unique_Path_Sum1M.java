import java.util.Arrays;

class Main {
    public static void main(String[] args) {
        int m = 4, n = 4;
        int[][] dp = new int[m][n];
        
        // initialize dp with -1
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        System.out.println(f(m - 1, n - 1, dp)); // start from bottom-right
    }

    public static int f(int m, int n, int[][] dp) {
        if (m == 0 && n == 0) return 1;
        if (m < 0 || n < 0) return 0;

        if (dp[m][n] != -1) return dp[m][n];

        int up = f(m - 1, n, dp);
        int left = f(m, n - 1, dp);

        return dp[m][n] = up + left; // store in correct cell
    }
}
