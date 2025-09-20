import java.util.*;
import java.lang.*;

class Main {
    public static void main(String[] args) {
        int[] nums = {2, 1, 9, 4};
        System.out.println(f(nums));
    }

    public static int f(int[] nums){
        int n = nums.length;
        if(n == 0) return 0;
        if(n == 1) return nums[0];

        int[] skipFirstHouse = Arrays.copyOfRange(nums, 1, n);
        int[] skipLastHouse = Arrays.copyOfRange(nums, 0, n-1);

        int case1 = rob(skipFirstHouse);
        int case2 = rob(skipLastHouse);

        return Math.max(case1, case2);
    }

    public static int rob(int[] nums){
        int n = nums.length;
        if(n == 0) return 0;
        int[] dp = new int[n];
        dp[0] = nums[0];
        int right = 0;

        for(int i = 1; i < n; i++){
            int left = nums[i];
            if(i > 1){
                left = left + dp[i-2];
            }
            right = dp[i-1];
            dp[i] = Math.max(left, right);
        }

        return dp[n-1];
    }
}
