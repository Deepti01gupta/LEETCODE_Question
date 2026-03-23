class Solution {
    static class Pair {
        long max, min;
        Pair(long max, long min) {
            this.max = max;
            this.min = min;
        }
    }

    public int maxProductPath(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        Pair[][] dp = new Pair[n][m];

        Pair res = solve(grid, 0, 0, dp);

        if (res.max < 0) return -1;
        return (int)(res.max % 1000000007);
    }

    private Pair solve(int[][] grid, int i, int j, Pair[][] dp) {
        int n = grid.length, m = grid[0].length;

        // out of bounds → return null (NOT extreme values)
        if (i >= n || j >= m) return null;

        // destination
        if (i == n - 1 && j == m - 1) {
            return new Pair(grid[i][j], grid[i][j]);
        }

        if (dp[i][j] != null) return dp[i][j];

        Pair right = solve(grid, i, j + 1, dp);
        Pair down  = solve(grid, i + 1, j, dp);

        long val = grid[i][j];

        long maxVal = Long.MIN_VALUE;
        long minVal = Long.MAX_VALUE;

        // process RIGHT if valid
        if (right != null) {
            long a = right.max * val;
            long b = right.min * val;
            maxVal = Math.max(maxVal, Math.max(a, b));
            minVal = Math.min(minVal, Math.min(a, b));
        }

        // process DOWN if valid
        if (down != null) {
            long a = down.max * val;
            long b = down.min * val;
            maxVal = Math.max(maxVal, Math.max(a, b));
            minVal = Math.min(minVal, Math.min(a, b));
        }

        return dp[i][j] = new Pair(maxVal, minVal);
    }
}