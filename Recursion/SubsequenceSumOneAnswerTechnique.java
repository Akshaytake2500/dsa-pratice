import java.util.*;

class Main {
    public static void main(String[] args) {
        int target = 2;
        int[] arr = {1, 2, 1};
        int n = arr.length;
        List<Integer> temp = new ArrayList<>();
        f(arr, temp, n, target, 0, 0);
    }

    public static boolean f(int[] arr, List<Integer> temp, int n, int target, int sum, int index) {
        if (index == n) {
            if (sum == target) {
                System.out.println(temp);
                return true; // stop after first valid subsequence
            }
            return false;
        }

        // include
        temp.add(arr[index]);
        sum += arr[index];
        if (f(arr, temp, n, target, sum, index + 1)) {
            return true;
        }
        // backtrack
        sum -= arr[index];
        temp.remove(temp.size() - 1);

        // exclude
        if (f(arr, temp, n, target, sum, index + 1)) {
            return true;
        }

        return false;
    }
}
