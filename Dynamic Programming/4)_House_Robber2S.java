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

    // Space-optimized linear rob
    public static int rob(int[] nums){
        int n = nums.length;
        if(n == 0) return 0;
        if(n == 1) return nums[0];

        int prev2 = 0;       // dp[i-2]
        int prev = nums[0];  // dp[i-1]

        for(int i = 1; i < n; i++){
            int left = nums[i] + prev2; // rob current + dp[i-2]
            int right = prev;           // skip current
            int curr = Math.max(left, right);

            prev2 = prev;
            prev = curr;
        }

        return prev;
    }
}
