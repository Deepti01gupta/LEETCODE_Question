class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp=new int[prices.length][2];
        for (int i = 0; i < prices.length; i++) {
            for (int j = 0; j < 2; j++) {
                dp[i][j]=-1;
            }
        }
        return profit(prices,0,1,dp);
    }
    
    public int profit(int[] arr,int idx,int turn,int[][]dp){
        if(idx>=arr.length){
            return 0;
        }
        if(dp[idx][turn]!=-1){
            return dp[idx][turn];
        }
        int buy=0;
        int sell=0;
        if(turn==1){
            buy= Math.max(-arr[idx]+profit(arr,idx+1,0,dp),profit(arr,idx+1,1,dp));
        }
        else{
            sell= Math.max(arr[idx]+profit(arr,idx+2,1,dp),profit(arr,idx+1,0,dp));
        }
        return dp[idx][turn]=Math.max(buy,sell);
    }
}