class Solution {
    public int minPathSum(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[][] dp=new int[n][m];
        for(int[] r:dp){
            Arrays.fill(r, -1);
        }
        return solve(n-1, m-1, grid, dp);
    }
    public int solve(int n, int m, int[][] arr, int[][] dp){
        if(n<0 || m<0){
            return Integer.MAX_VALUE;
        }
        if(n==0 && m==0){
            return arr[0][0];
        }
        if(dp[n][m]!=-1){
            return dp[n][m];
        }
        int up=solve(n-1, m, arr, dp);
        int left=solve(n, m-1, arr, dp);
        return dp[n][m] = arr[n][m] + Math.min(up, left);
    }



    // public int minPathSum(int[][] grid) {
    //     int n=grid.length;
    //     int m=grid[0].length;
    //     return solve(n-1, m-1, grid);
    // }
    // public int solve(int n, int m, int[][] arr){
    //     if(n<0 || m<0){
    //         return Integer.MAX_VALUE;
    //     }
    //     if(n==0 && m==0){
    //         return arr[0][0];
    //     }
    //     int up=solve(n-1, m, arr);
    //     int left=solve(n, m-1, arr);
    //     return arr[n][m] + Math.min(up, left);
    // }
}