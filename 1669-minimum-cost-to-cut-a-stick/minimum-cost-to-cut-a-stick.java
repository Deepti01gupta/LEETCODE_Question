class Solution {
    public int minCost(int n, int[] cuts) {
        int c=cuts.length;
        int[] arr=new int[c+2];
        Arrays.sort(cuts);
        for(int i=0; i<c; i++){
            arr[i+1]=cuts[i];
        }
        arr[c+1]=n;

        int[][] dp=new int[c+2][c+2];
        for(int[] r:dp){
            Arrays.fill(r,-1);
        }

        return solve(1,c,arr,dp);
    }

    private int solve(int i, int j, int[] arr, int[][] dp){
        if(i>j){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }

        int ans=Integer.MAX_VALUE;
        for(int k=i; k<=j; k++){
            ans=Math.min(ans, (arr[j+1]-arr[i-1]) + solve(i,k-1,arr,dp) + solve(k+1,j,arr,dp));
        }

        return dp[i][j]=ans;
    }
}