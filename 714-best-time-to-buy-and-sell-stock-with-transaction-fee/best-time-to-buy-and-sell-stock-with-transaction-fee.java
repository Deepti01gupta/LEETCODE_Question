class Solution {

    public int maxProfit(int[] prices, int fee) {
        int[][] dp=new int[prices.length][2];
        for(int[] r:dp) Arrays.fill(r, -1);
        return solve(0, 1, fee, prices, dp);
    }
    public int solve(int idx, int turn, int fee, int[] arr, int[][] dp){
        if(idx==arr.length){
            return 0;
        }
        if(dp[idx][turn]!=-1){
            return dp[idx][turn];
        }
        int ans=0;
        if(turn==1){
            ans=Math.max(-arr[idx] + solve(idx+1, 0, fee, arr, dp) , solve(idx+1, 1, fee, arr, dp));
        }
        else{
            ans=Math.max(arr[idx] - fee + solve(idx+1, 1, fee, arr, dp) , solve(idx+1, 0, fee, arr, dp));
        }
        return dp[idx][turn]=ans;
    }


    
    // public int maxProfit(int[] prices, int fee) {
    //     return solve(0, 1, fee, prices);
    // }
    // public int solve(int idx, int turn, int fee, int[] arr){
    //     if(idx==arr.length){
    //         return 0;
    //     }
    //     int ans=0;
    //     if(turn==1){
    //         ans=Math.max(-arr[idx] + solve(idx+1, 0, fee, arr) , solve(idx+1, 1, fee, arr));
    //     }
    //     else{
    //         ans=Math.max(arr[idx] - fee + solve(idx+1, 1, fee, arr) , solve(idx+1, 0, fee, arr));
    //     }
    //     return ans;
    // }
}