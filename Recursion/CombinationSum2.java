import java.util.*;

class Main {
    public static void main(String[] args) {
        int[] arr = {1,2,1,1,2};
        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> ansList = new ArrayList<>();
        int target=4;
        Arrays.sort(arr);
        f(0,arr,temp,ansList,target);
        System.out.println(ansList);
    }
    public static void f(int index,int[] arr,List<Integer> temp, List<List<Integer>> ansList,int target){
            if(target==0){
                ansList.add(new ArrayList<>(temp));
                return;
        }
        for(int i=index;i<arr.length;i++){
            if(i>index && arr[i] == arr[i-1]) continue;
            if(arr[i]>target) break;
            
            temp.add(arr[i]);
            f(i+1,arr,temp,ansList,target-arr[i]);
            temp.remove(temp.size()-1);
        }
    }
}