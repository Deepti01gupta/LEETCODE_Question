class Solution {

    public int minPathSum(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[] prev=new int[m];
        for(int i=0; i<n; i++){
            int[] cur=new int[m];
            for(int j=0; j<m; j++){
                if(i==0 && j==0){
                    cur[j]=grid[i][j];
                }
                else{
                    int up=grid[i][j];
                    int left=grid[i][j];
                    if(i>0){
                        up+=prev[j];
                    }
                    else{
                        up=Integer.MAX_VALUE;
                    }
                    if(j>0){
                        left+=cur[j-1];
                    }
                    else{
                        left=Integer.MAX_VALUE;
                    }

                    cur[j]=Math.min(left, up);
                }
            }
            prev=cur;
        }
        return prev[m-1];
    }



    // public int minPathSum(int[][] grid) {
    //     int n=grid.length;
    //     int m=grid[0].length;
    //     int[][] dp=new int[n][m];
    //     for(int i=0; i<n; i++){
    //         for(int j=0; j<m; j++){
    //             if(i==0 && j==0){
    //                 dp[i][j]=grid[i][j];
    //             }
    //             else{
    //                 int up=grid[i][j];
    //                 int left=grid[i][j];
    //                 if(i>0){
    //                     up+=dp[i-1][j];
    //                 }
    //                 else{
    //                     up=Integer.MAX_VALUE;
    //                 }
    //                 if(j>0){
    //                     left+=dp[i][j-1];
    //                 }
    //                 else{
    //                     left=Integer.MAX_VALUE;
    //                 }
    //                 dp[i][j]=Math.min(left, up);
    //             }
    //         }
    //     }
    //     return dp[n-1][m-1];
    // }



    // public int minPathSum(int[][] grid) {
    //     int n=grid.length;
    //     int m=grid[0].length;
    //     int[][] dp=new int[n][m];
    //     for(int[] r:dp){
    //         Arrays.fill(r, -1);
    //     }
    //     return solve(n-1, m-1, grid, dp);
    // }
    // public int solve(int n, int m, int[][] arr, int[][] dp){
    //     if(n<0 || m<0){
    //         return Integer.MAX_VALUE;
    //     }
    //     if(n==0 && m==0){
    //         return arr[0][0];
    //     }
    //     if(dp[n][m]!=-1){
    //         return dp[n][m];
    //     }
    //     int up=solve(n-1, m, arr, dp);
    //     int left=solve(n, m-1, arr, dp);
    //     return dp[n][m] = arr[n][m] + Math.min(up, left);
    // }



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