import java.util.*;
class Main {
    public static void main(String[] args) {
        int num = 8;
        int ans = fibonacci(num);
        System.out.println(ans);
    }

    public static int fibonacci(int num){
        int[] dp = new int[num + 1];
        Arrays.fill(dp,-1);
        dp[0] = 0;
        dp[1] = 1;

        for(int i = 2; i <= num; i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[num];
    }
}
