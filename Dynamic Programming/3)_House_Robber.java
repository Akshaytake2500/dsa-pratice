import java.lang.*; 
class Main { 
    public static void main(String[] args) { 
        int[] arr = {2,1,9,4}; 
        int index=arr.length-1; 
        
        System.out.println(f(index,arr)); 
    } 
    public static int f(int index, int[] arr){
        if(index==0) return arr[index];
        if(index<0) return 0;
        
        int left =arr[index] + f(index-2,arr); 
        int right = f(index-1,arr); 
        
        return Math.max(left,right); 
    } 
}