import java.util.*;
import java.lang.*;
class Main {
    public static void main(String[] args) {
        int[][] task = {
                        {1, 2, 5},
                        {3, 1, 1},
                        {3, 3, 3}
                    };
        int n = task.length;
        System.out.println(f(n - 1, 3, task));
    }
    public static int f(int day, int last, int[][] task) {
        if (day == 0) {
            int maxi = 0;
            for (int i = 0; i < 3; i++) {
                if (i != last) {
                    maxi = Math.max(maxi, task[0][i]);
                }
            }
            return maxi;
        }

        int maxi = 0;
        for (int i = 0; i < 3; i++) {
            if (i != last) {
                int points = task[day][i] + f(day - 1, i, task);
                maxi = Math.max(maxi, points);
            }
        }
        return maxi;
    }

}