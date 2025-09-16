import java.util.*;
import java.lang.*;
class Main {
    public static void main(String[] args) {
        int[] arr={30,10,60,10,60,50};
        int index = arr.length;
        int[]dp = new int[index];
        System.out.println(f(arr,index,dp));
    }
    public static int f(int[] arr,int index,int[] dp){
        if(index==0) return 0;
        
       int prev=0, prev2=0;
       dp[0]=0;
       
       for(int i=1;i<index;i++){
           int left=prev + Math.abs(arr[i]-arr[i-1]);
           int right= Integer.MAX_VALUE;
           if(i>1){
               right = prev2 + Math.abs(arr[i]-arr[i-2]);
           }
           int curr=Math.min(left,right);
           prev2=prev;
           prev=curr;
       }
       return prev;
       
    }
}