class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        int[][] dp=new int[n][n];
        for(int j=0; j<n; j++){
            dp[n-1][j]=triangle.get(n-1).get(j);
        }
        for(int i=n-2; i>=0; i--){
            for(int j=i; j>=0; j--){
                int down=triangle.get(i).get(j) + dp[i+1][j];
                int right=triangle.get(i).get(j) + dp[i+1][j+1];
                dp[i][j]=Math.min(down, right);
            }
        }
        return dp[0][0];
    }



    // public int minimumTotal(List<List<Integer>> triangle) {
    //     int n=triangle.size();
    //     int[][] dp=new int[n][n];
    //     for(int[] r:dp){
    //         Arrays.fill(r, -1);
    //     }
    //     return solve(0, 0, triangle, dp);
    // }
    // public int solve(int i, int j, List<List<Integer>> ll, int[][] dp){
    //     if(i==ll.size()-1){
    //         return ll.get(i).get(j);
    //     }
    //     if(dp[i][j]!=-1){
    //         return dp[i][j];
    //     }
    //     int down=ll.get(i).get(j) + solve(i+1, j, ll, dp);
    //     int right=ll.get(i).get(j) + solve(i+1, j+1, ll, dp);
    //     return dp[i][j]=Math.min(down, right);
    // }



    // public int minimumTotal(List<List<Integer>> triangle) {
    //     int n=triangle.size();
    //     return solve(0, 0, triangle);
    // }
    // public int solve(int i, int j, List<List<Integer>> ll){
    //     if(i==ll.size()-1){
    //         return ll.get(i).get(j);
    //     }
    //     int down=ll.get(i).get(j) + solve(i+1, j, ll);
    //     int right=ll.get(i).get(j) + solve(i+1, j+1, ll);
    //     return Math.min(down, right);
    // }
}