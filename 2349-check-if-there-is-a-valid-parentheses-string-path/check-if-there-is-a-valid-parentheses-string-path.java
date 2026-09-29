class Solution {
    public boolean hasValidPath(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        if((n+m-1)%2!=0){
            return false;
        }
        if(grid[0][0]==')'){
            return false;
        }
        Boolean[][][] dp=new Boolean[n][m][n+m];
        return solve(0, 0, n, m, 1, grid, dp);
    }
    public boolean solve(int i, int j, int n, int m, int val, char[][] grid, Boolean[][][] dp){
        if(val<0){
            return false;
        }
        if(i==n-1 && j==m-1){
            return val==0;
        }
        if(dp[i][j][val]!=null){
            return dp[i][j][val];
        }
        boolean ans=false;
        if(i+1<n){
            int newval=val;
            if(grid[i+1][j]=='('){
                newval++;
            }
            else{
                newval--;
            }
            if(solve(i+1, j, n, m, newval, grid, dp)){
                ans=true;
            }
        }
        if(j+1<m){
            int newval=val;
            if(grid[i][j+1]=='('){
                newval++;
            }
            else{
                newval--;
            }
            if(solve(i, j+1, n, m, newval, grid, dp)){
                ans=true;
            }
        }
        return dp[i][j][val]=ans;
    }



    // public boolean hasValidPath(char[][] grid) {
    //     int n=grid.length;
    //     int m=grid[0].length;
    //     if((n+m-1)%2!=0){
    //         return false;
    //     }
    //     if(grid[0][0]==')'){
    //         return false;
    //     }
    //     return solve(0, 0, n, m, 1, grid);
    // }
    // public boolean solve(int i, int j, int n, int m, int val, char[][] grid){
    //     if(val<0){
    //         return false;
    //     }
    //     if(i==n-1 && j==m-1){
    //         return val==0;
    //     }
    //     boolean ans=false;
    //     if(i+1<n){
    //         int newval=val;
    //         if(grid[i+1][j]=='('){
    //             newval++;
    //         }
    //         else{
    //             newval--;
    //         }
    //         if(solve(i+1, j, n, m, newval, grid)){
    //             ans=true;
    //         }
    //     }
    //     if(j+1<m){
    //         int newval=val;
    //         if(grid[i][j+1]=='('){
    //             newval++;
    //         }
    //         else{
    //             newval--;
    //         }
    //         if(solve(i, j+1, n, m, newval, grid)){
    //             ans=true;
    //         }
    //     }
    //     return ans;
    // }
}