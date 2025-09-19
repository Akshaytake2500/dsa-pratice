import java.util.*;
import java.lang.*;
class Main {
    public static void main(String[] args) {
        int[] arr = {2,1,9,4};
        int index=arr.length-1;
        
        int[] dp = new int[arr.length];
        Arrays.fill(dp,-1);
        
        System.out.println(f(index,arr,dp));
    }
    public static int f(int index, int[] arr,int[] dp){
        if(index==0) return arr[index];
        if(index<0) return 0;
        
        int left =arr[index] + f(index-2,arr,dp);
        int right = f(index-1,arr,dp);
        
        dp[index] = Math.max(left,right);
        
        return dp[index];
    }
}