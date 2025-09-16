import java.util.*;
import java.lang.*;
class Main {
    public static void main(String[] args) {
        int[] arr={30,10,60,10,60,50};
        int index = arr.length-1;
        System.out.println(f(arr,index));
    }
    public static int f(int[] arr,int index){
        if(index==0) return 0;
        int left = f(arr,index-1)+Math.abs(arr[index]-arr[index-1]);
        int right = Integer.MAX_VALUE;
        if(index>1){
        right = f(arr,index-2)+Math.abs(arr[index]-arr[index-2]);
        }
        return Math.min(left,right);
    }
}