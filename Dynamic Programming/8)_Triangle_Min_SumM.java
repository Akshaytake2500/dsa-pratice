import java.util.*;
import java.lang.*;
class Main {
    public static void main(String[] args) {
        int[][] arr = {{2},{3,4},{6,5,7},{4,1,8,3}};
        int i = 0;
        int j = 0;
        int[][] dp = new int[arr.length][arr.length];
        for(int[] rows: dp){
            Arrays.fill(rows, -1);
        }
        int minSum = f(i,j,arr,dp);
        System.out.println(minSum);
    }
    public static int f(int i, int j, int[][] arr, int[][] dp){
        if(i==arr.length-1) return arr[i][j];
        if(dp[i][j] != -1) return dp[i][j];
        int down = arr[i][j] + f(i+1,j,arr,dp);
        int right = arr[i][j] + f(i+1,j+1,arr,dp);
        return dp[i][j] = Math.min(down,right);
    }
}