import java.util.*;
import java.lang.*;
class Main {
    public static void main(String[] args) {
        int[] arr={30,10,60,10,60,50};
        int index = arr.length-1;
        int[]dp = new int[arr.length];
        Arrays.fill(dp,-1);
        System.out.println(f(arr,index,dp));
    }
    public static int f(int[] arr,int index,int[] dp){
        if(index==0) return 0;
        
        if(dp[index]!=-1) return dp[index];
        
        int left = f(arr,index-1,dp)+Math.abs(arr[index]-arr[index-1]);
        int right = Integer.MAX_VALUE;
        if(index>1){
        right = f(arr,index-2,dp)+Math.abs(arr[index]-arr[index-2]);
        }
        
        return dp[index] = Math.min(left,right);
    }
}