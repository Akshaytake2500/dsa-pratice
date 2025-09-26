import java.util.*;
import java.lang.*;
class Main {
    public static void main(String[] args) {
        int[][] arr = {{2},{3,4},{6,5,7},{4,1,8,3}};
        int[][] dp = new int[arr.length][];

        for(int i = 0; i < arr.length; i++) {
            dp[i] = new int[arr[i].length];
            Arrays.fill(dp[i], -1);
        }

        int minSum = f(arr, dp);
        System.out.println(minSum);
    }

    public static int f(int[][] arr, int[][] dp) {
        int n = arr.length;

        // Fill last row of dp
        for(int j = 0; j < arr[n-1].length; j++) {
            dp[n-1][j] = arr[n-1][j];
        }

        // Fill dp from bottom to top
        for(int i = n - 2; i >= 0; i--) {
            for(int j = 0; j < arr[i].length; j++) {
                dp[i][j] = arr[i][j] + Math.min(dp[i+1][j], dp[i+1][j+1]);
            }
        }
        return dp[0][0];
    }
}
