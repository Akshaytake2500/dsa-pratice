//recurrence code
class Solution {
    public int cherryPickup(int[][] grid) {
        return Math.max(0, f(0, 0, grid[0].length - 1, grid));
    }

    public static int f(int r, int c1, int c2, int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // Out of bounds check
        if (c1 < 0 || c1 >= n || c2 < 0 || c2 >= n)
            return Integer.MIN_VALUE;

        // Pick cherries from current cells
        int cherries = grid[r][c1];
        if (c1 != c2) cherries += grid[r][c2]; // avoid double count

        // Reached last row
        if (r == m - 1)
            return cherries;

        int maxNext = Integer.MIN_VALUE;

        // Both robots have 3 moves: left(-1), stay(0), right(+1)
        for (int move1 = -1; move1 <= 1; move1++) {
            for (int move2 = -1; move2 <= 1; move2++) {
                int nextC1 = c1 + move1;
                int nextC2 = c2 + move2;
                int temp = f(r + 1, nextC1, nextC2, grid);
                maxNext = Math.max(maxNext, temp);
            }
        }

        if (maxNext == Integer.MIN_VALUE) return Integer.MIN_VALUE; // no valid path
        return cherries + maxNext;
    }
}
