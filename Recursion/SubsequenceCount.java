import java.util.*;

class Main {
    public static void main(String[] args) {
        int target = 3;
        int[] arr = {1, 2, 1,3};
        int n = arr.length;
        System.out.println(f(arr, n, target, 0, 0));
    }

    public static int f(int[] arr, int n, int target, int sum, int index) {
        if (index == n) {
            if (sum == target) {
                return 1;
            }
            return 0;
        }
        
        sum += arr[index];
        int left = f(arr, n, target, sum, index + 1);
        sum -= arr[index];
        int right=f(arr, n, target, sum, index + 1);
        return left+right;
    }
}
