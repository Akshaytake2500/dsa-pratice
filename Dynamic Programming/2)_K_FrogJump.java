import java.util.*;
import java.lang.*;
class Main{
    public static void main(String[] args){
        int[] arr = {10, 30, 40, 50, 20};
        int k = 3;
        int index = arr.length-1;
        System.out.println(f(index,arr,k));
    }
    public static int f(int index,int[] arr, int k){
        if(index==0) return 0;
        
        int minEnergy = Integer.MAX_VALUE;
        
        for(int jump=1;jump<=k;jump++){
            if(index-jump>=0){
            int energy = f(index-jump,arr,k) + Math.abs(arr[index]-arr[index-jump]);
            minEnergy = Math.min(minEnergy,energy);
            }
        }
        return minEnergy;
    }
}