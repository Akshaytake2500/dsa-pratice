import java.util.ArrayList;
import java.util.List;

public class Main {
    
    public static void main(String[] args) {
        int[] arr = {3, 1, 2};
        List<Integer> temp = new ArrayList<>();
        generateSubsequences(arr, 0, temp);
    }

    public static void generateSubsequences(int[] arr, int index, List<Integer> temp) {
        if (index >= arr.length) {
            System.out.println(temp); // print current subsequence
            return;
        }

        // Include current element
        temp.add(arr[index]);
        generateSubsequences(arr, index + 1, temp);

        // Backtrack: remove last element and move to next
        temp.remove(temp.size() - 1);

        // Exclude current element
        generateSubsequences(arr, index + 1, temp);
    }
}
