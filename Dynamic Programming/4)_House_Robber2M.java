import java.util.*;
import java.lang.*;

class Main {
    public static void main(String[] args) {
        int[] nums = {2,3,2};
        
        System.out.println(f(nums));
    }
    public static int f(int[] nums){
        int n=nums.length;
        List<Integer> skipFirstHouse = new ArrayList<>();
        List<Integer> skipLastHouse = new ArrayList<>();
        for(int i=1;i<n;i++){
            skipFirstHouse.add(nums[i]);
        }
        for(int i=0;i<n-1;i++){
            skipLastHouse.add(nums[i]);
        }
        int[] dp1 = new int[n];
        Arrays.fill(dp1,-1);
        
        int[] dp2 = new int[n];
        Arrays.fill(dp2,-1);
        
        int case1 = rob(skipFirstHouse, skipFirstHouse.size()-1,dp1);
        int case2 = rob(skipLastHouse, skipLastHouse.size()-1,dp2);
        
        return Math.max(case1, case2);
    }
    public static int rob(List<Integer> arr, int index,int[] dp){
        if(index==0) return arr.get(index);
        if(index<0) return 0;
        
        int left = arr.get(index) + rob(arr,index-2,dp);
        int right = rob(arr,index-1,dp);
        
        dp[index] = Math.max(left,right);
        return dp[index];
    }
}