import java.util.*;
import java.lang.*;

class Main {
    public static void main(String[] args) {
        int[] nums = {2,1,9,4};
        
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
        int case1 = rob(skipFirstHouse, skipFirstHouse.size()-1);
        int case2 = rob(skipLastHouse, skipLastHouse.size()-1);
        
        return Math.max(case1, case2);
    }
    public static int rob(List<Integer> arr, int index){
        if(index==0) return arr.get(index);
        if(index<0) return 0;
        
        int left = arr.get(index) + rob(arr,index-2);
        int right = rob(arr,index-1);
        
        return Math.max(left,right);
    }
}