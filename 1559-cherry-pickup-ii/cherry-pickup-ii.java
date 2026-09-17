class Solution {
    public int cherryPickup(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[][][] dp=new int[n][m][m];
        for(int[][] x:dp){
            for(int[] y:x){
                Arrays.fill(y, -1);
            }
        }
        return solve(0, 0, m-1, grid, dp);
    }
    public int solve(int i, int j1, int j2, int[][] grid, int[][][] dp){
        if(j1<0 || j1>=grid[0].length || j2<0 || j2>=grid[0].length){
            return (int)(-1e9);
        }
        if(i==grid.length-1){
            if(j1==j2){
                return grid[i][j1];
            }
            else{
                return grid[i][j1] + grid[i][j2];
            }
        }
        if(dp[i][j1][j2]!=-1){
            return dp[i][j1][j2];
        }
        int max=0;
        for(int d1=-1; d1<=1; d1++){
            for(int d2=-1; d2<=1; d2++){
                int val=0;
                if(j1==j2){
                    val+=grid[i][j1];
                }
                else{
                    val+=(grid[i][j1] + grid[i][j2]);
                }
                val+=solve(i+1, j1+d1, j2+d2, grid, dp);
                max=Math.max(max, val);
            }
        }
        return dp[i][j1][j2]=max;
    }



    // public int cherryPickup(int[][] grid) {
    //     int n=grid.length;
    //     int m=grid[0].length;
    //     return solve(0, 0, m-1, grid);
    // }
    // public int solve(int i, int j1, int j2, int[][] grid){
    //     if(j1<0 || j1>=grid[0].length || j2<0 || j2>=grid[0].length){
    //         return (int)(-1e9);
    //     }
    //     if(i==grid.length-1){
    //         if(j1==j2){
    //             return grid[i][j1];
    //         }
    //         else{
    //             return grid[i][j1] + grid[i][j2];
    //         }
    //     }
    //     int max=0;
    //     for(int d1=-1; d1<=1; d1++){
    //         for(int d2=-1; d2<=1; d2++){
    //             int val=0;
    //             if(j1==j2){
    //                 val+=grid[i][j1];
    //             }
    //             else{
    //                 val+=(grid[i][j1] + grid[i][j2]);
    //             }
    //             val+=solve(i+1, j1+d1, j2+d2, grid);
    //             max=Math.max(max, val);
    //         }
    //     }
    //     return max;
    // }
}