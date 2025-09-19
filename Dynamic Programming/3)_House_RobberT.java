import java.util.*;
import java.lang.*;
class Main {
    public static void main(String[] args) {
        int[] arr = {2,1,9,4};
        int n=arr.length-1;
        
        int[] dp = new int[arr.length];
        Arrays.fill(dp,-1);
        
        System.out.println(f(n,arr,dp));
    }
    public static int f(int n, int[] arr,int[] dp){
        dp[0] = arr[0];
        if(n<0) return 0;
        
        for(int i=1;i<=n;i++)
        {
            int left =arr[i];
            if(i>1) left = left + dp[i-1];
            int right = dp[i-1];

            dp[i] = Math.max(left,right);
        }
        return dp[n-1];
    }
}