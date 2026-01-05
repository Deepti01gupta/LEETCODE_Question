class Solution {
    int[][] dp;
    public int calculateMinimumHP(int[][] dungeon) {
        int n=dungeon.length;
        int m=dungeon[0].length;
        dp=new int[n][m];
        for(int i=0; i<n; i++){
            Arrays.fill(dp[i],-1);
        }
        return path(dungeon,0,0);
    }

    private int path(int[][] arr, int i, int j){
        if(i>=arr.length || j>=arr[0].length){
            return Integer.MAX_VALUE;
        }

        if(i==arr.length-1 && j==arr[0].length-1){
            return Math.max(1,1-arr[i][j]);
        }

        if(dp[i][j]!=-1){
            return dp[i][j];
        }

        int ans=Math.min( path(arr,i+1,j) , path(arr,i,j+1));

        int req=ans-arr[i][j];

        return dp[i][j]=Math.max(1,req);
    }
}