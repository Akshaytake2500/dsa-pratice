import java.util.*;

class Main {
    public static void main(String[] args){
        int[] arr = {10, 30, 40, 50, 20};
        int k = 3;
        int index = arr.length - 1;
        int[] dp = new int[index + 1];
        Arrays.fill(dp, -1);
        System.out.println(f(index, arr, k, dp));
    }

    public static int f(int index, int[] arr, int k, int[] dp){
        if(index == 0) return 0;

        if(dp[index] != -1) return dp[index];

        int minEnergy = Integer.MAX_VALUE;

        for(int jump = 1; jump <= k; jump++){
            if(index - jump >= 0){
                int energy = f(index - jump, arr, k, dp) + Math.abs(arr[index] - arr[index - jump]);
                minEnergy = Math.min(minEnergy, energy);
            }
        }

        return dp[index] = minEnergy;
    }
}
