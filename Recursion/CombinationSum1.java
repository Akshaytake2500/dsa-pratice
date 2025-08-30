import java.util.*;

class Main {
    public static void main(String[] args) {
        int[] arr = {2,3,6,7};
        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> ansList = new ArrayList<>();
        int target=7;
        f(0,arr,temp,ansList,target);
        System.out.println(ansList);
    }
    public static void f(int index,int[] arr,List<Integer> temp, List<List<Integer>> ansList,int target){
        if(index==arr.length){
            if(target==0){
                ansList.add(new ArrayList<>(temp));
            }
            return;
        }
        if(arr[index]<=target){
            temp.add(arr[index]);
            f(index,arr,temp,ansList,target-arr[index]);
            temp.remove(temp.size()-1);
        }
        f(index+1,arr,temp,ansList,target);
    }
}