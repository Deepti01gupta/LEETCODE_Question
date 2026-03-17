class Solution {
    public int maxProfit(int k, int[] prices) {
        int[][][] dp=new int[prices.length][2][k];
        for (int i = 0; i < prices.length; i++) {
            for (int j = 0; j < 2; j++) {
                for (int l= 0; l < k; l++) {
                    dp[i][j][l] = -1;
                }
            }
        }
        return profit(prices,0,1,0,k,dp);
    }
    public int profit(int[] arr,int idx,int turn,int cap, int k, int[][][]dp){
        if(idx>=arr.length || cap==k){
            return 0;
        }
        if(dp[idx][turn][cap]!=-1){
            return dp[idx][turn][cap];
        }
        int buy=0;
        int sell=0;
        if(turn==1){
            buy= Math.max(-arr[idx]+profit(arr,idx+1,0,cap,k,dp),profit(arr,idx+1,1,cap,k,dp));
        }
        else{
            sell= Math.max(arr[idx]+profit(arr,idx+1,1,cap+1,k,dp),profit(arr,idx+1,0,cap,k,dp));
        }
        return dp[idx][turn][cap]=Math.max(buy,sell);
    }
}