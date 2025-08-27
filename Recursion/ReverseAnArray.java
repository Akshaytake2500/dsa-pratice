import java.util.Arrays;

class Main {
    public static void main(String[] args) {
        int[] arr={1,3,2,5,4};
        int n=arr.length;
        f(arr,0,n);
        System.out.println(Arrays.toString(arr));
    }
      public static void f(int[]arr,int i,int n){
          if(i>=n/2){
              return ;
          }
          swap(arr,i,n-i-1);
          f(arr,i+1,n);
      }
      public static void swap(int[]arr,int l,int r){
          int temp=arr[l];
          arr[l]=arr[r];
          arr[r]=temp;
      }
       
}