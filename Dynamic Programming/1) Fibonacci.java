import java.util.*;
class Main {
    public static void main(String[] args) {
        int num=8;
        int[] dp = new int[num+1];
        for(int i=0;i<dp.length;i++){
            dp[i]=-1;
        }
        int ans = fibonacci(num,dp);
        System.out.println(ans);
        System.out.println(Arrays.toString(dp));
    }
    public static int fibonacci(int num,int[] dp){
        if(num<=1){
            return num;
        }
        
        if(dp[num]!=-1){
            return dp[num];
        }

        dp[num]= fibonacci(num-1,dp)+fibonacci(num-2,dp);
        return dp[num];
    }
}