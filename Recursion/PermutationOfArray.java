import java.util.*;

class Main {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> ansList = new ArrayList<>();
        int[] freq = new int[arr.length];
        Arrays.sort(arr);
        f(arr,temp,ansList,freq);
        System.out.println(ansList);
    }
    public static void f(int[] arr,List<Integer> temp, List<List<Integer>> ansList,int[] freq){
        if(temp.size()==arr.length){
            ansList.add(new ArrayList<>(temp));
            return;
        }
        for(int i=0;i<arr.length;i++){
            if(freq[i]==0){
                freq[i]=1;
                temp.add(arr[i]);
                f(arr,temp,ansList,freq);
                temp.remove(temp.size()-1);
                freq[i]=0;
            }
        }
    }
}