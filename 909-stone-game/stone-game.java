class Solution {
    public boolean stoneGame(int[] piles) {
        int n=piles.length;

        int total=0;
        for(int i:piles){
            total+=i;
        }

        int[][] dp=new int[n][n];

        for(int[] row : dp){
            Arrays.fill(row, -1);
        }

        int score=solve(piles,0,n-1,dp);
        if(score>=total-score){
            return true;
        }
        return false;
    }

    public int solve(int[] piles, int i, int j, int[][] dp){
        if(i>j){
            return 0;
        }

        if(dp[i][j]!=-1){
            return dp[i][j];
        }

        int takeLeft = piles[i] + Math.min(solve(piles, i+2, j, dp), solve(piles, i+1, j-1, dp));

        int takeRight = piles[j] + Math.min(solve(piles, i+1, j-1, dp), solve(piles, i, j-2, dp));

        return dp[i][j] = Math.max(takeLeft, takeRight);
    }
}