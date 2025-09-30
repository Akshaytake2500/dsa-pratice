import java.util.*;

class Main {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        int n = arr.length;
        int k = 3;
        System.out.println(f(n - 1, k, arr));
    }

    public static boolean f(int index, int target, int[] arr) {
        if (target == 0) return true;
        if (index == 0) return arr[0] == target;

        boolean notTake = f(index - 1, target, arr);
        boolean take = false;
        if (arr[index] <= target) {
            take = f(index - 1, target - arr[index], arr);
        }
        return take || notTake;
    }
}
