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
        dp[0] = 0; 
        
        for(int i = 1; i <= index; i++){
            int minEnergy = Integer.MAX_VALUE;
            for(int jump = 1; jump <= k; jump++){
                if(i - jump >= 0){
                    int energy = dp[i - jump] + Math.abs(arr[i] - arr[i - jump]);
                    minEnergy = Math.min(minEnergy, energy);
                }
            }
            dp[i] = minEnergy;
        }
        
        return dp[index];
    }
}
