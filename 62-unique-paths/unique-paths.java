class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp=new int[m][n];
        for(int[] r:dp){
            Arrays.fill(r, -1);
        }

        return solve(m-1, n-1, dp);
    }

    public int solve(int m, int n, int[][] dp){
        if(n==0 && m==0){
            return 1;
        }
        if(n<0 || m<0){
            return 0;
        }
        if(dp[m][n]!=-1){
            return dp[m][n];
        }

        int up=solve(m-1, n, dp);
        int left=solve(m, n-1, dp);

        return dp[m][n]=up+left;
    }

    // public int uniquePaths(int m, int n) {
    //     return solve(m-1, n-1);
    // }

    // public int solve(int n, int m){
    //     if(n==0 && m==0){
    //         return 1;
    //     }
    //     if(n<0 || m<0){
    //         return 0;
    //     }

    //     int up=solve(m-1, n);
    //     int left=solve(m, n-1);

    //     return up+left;
    // }
}