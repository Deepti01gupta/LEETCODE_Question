class Solution {
    // public int maxProfit(int[] prices) {
    //     // int sum=0;
    //     int max=0;
    //     for(int i=1; i<prices.length; i++){
    //         if (prices[i] > prices[i - 1]) {
    //             max += prices[i] - prices[i - 1];
    //         }
    //     }
    //     return max;
    // }
    public int maxProfit(int[] prices) {
        int n=prices.length;

        int[][] dp=new int[n+1][2];
        for(int[] r:dp) Arrays.fill(r,-1);

        return solve(0,1,n,prices,dp);
    }

    private int solve(int idx, int turn, int n, int[] arr, int[][] dp){
        if(idx==n){
            return 0;
        }

        if(dp[idx][turn]!=-1){
            return dp[idx][turn];
        }

        int buy=0;
        int sell=0;
        if(turn==1){
            buy=Math.max(-arr[idx]+solve(idx+1,0,n,arr,dp) , solve(idx+1,1,n,arr,dp));
        }
        else{
            sell=Math.max(+arr[idx]+solve(idx+1,1,n,arr,dp) , solve(idx+1,0,n,arr,dp));
        }

        return dp[idx][turn]=Math.max(buy,sell);
    }
}