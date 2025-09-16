class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp=new int[m][n];
        dp[0][0]=1;
        for(int i=0; i<m; i++){
            Arrays.fill(dp[i],-1);
        }
        return bottomup(m-1,n-1,dp);
    }
    public int bottomup(int m, int n, int[][] dp){
        if(m==0 && n==0){
            return 1;
        }
        if(m<0 || n<0){
            return 0;
        }
        if(dp[m][n]!=-1){
            return dp[m][n];
        }
        int up= bottomup(m-1,n,dp);
        int left= bottomup(m,n-1,dp);
        return dp[m][n]=up+left;
    }
}