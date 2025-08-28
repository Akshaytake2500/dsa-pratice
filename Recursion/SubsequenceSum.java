
import java.util.List;
import java.util.ArrayList;
import java.util.*;
class Main {
    public static void main(String[] args) {
        System.out.println("Try programiz.pro");
        int target=2;
        int[] arr={1,2,1};
        int n=arr.length;
        int sum=0;
        int index=0;
        List<Integer> temp = new ArrayList<>();
        f(arr,temp,n,target,sum,index);
    }
    public static void f(int[] arr, List<Integer> temp, int n, int target, int sum,int index){
        if(index==n){
            if(sum==target){
                System.out.println(temp);
            }
            return;
        }
        temp.add(arr[index]);
        sum+=arr[index];
        f(arr,temp,n,target,sum,index+1);
        temp.remove(temp.size()-1);
        sum-=arr[index];
        f(arr,temp,n,target,sum,index+1);
    }
}