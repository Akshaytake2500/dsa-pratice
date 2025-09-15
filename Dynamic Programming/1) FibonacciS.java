import java.util.*;
class Main {
    public static void main(String[] args) {
        int num = 8;
        int ans = fibonacci(num);
        System.out.println(ans);
    }

    public static int fibonacci(int num){
      int prev2 = 0;          //second previous
      int prev = 1;        //first previous
      for(int i=2;i<=num;i++){
          int curr = prev+prev2;   //curr = current number
          prev2 = prev;
          prev = curr;
      }
      return prev;
    }
}
