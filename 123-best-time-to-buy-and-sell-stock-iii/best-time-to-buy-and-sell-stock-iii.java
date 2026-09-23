class Solution {
    // public int maxProfit(int[] prices) {
    //     int n=prices.length;
    //     int[] prev=new int[2];
    //     for(int idx=n-1; idx>=0; idx--){
    //         int[] cur=new int[2];
    //         for(int turn=0; turn<=1; turn++){
    //             int ans=0;
    //             if(turn==1){
    //                 ans=Math.max(-prices[idx] + prev[0] , prev[1]);
    //             }
    //             else{
    //                 ans=Math.max(prices[idx] + prev[1] , prev[0]);
    //             }
    //             cur[turn]=ans;
    //         }
    //         prev=cur;
    //     }
    //     return prev[1];
    // }



    public int maxProfit(int[] prices) {
        int n=prices.length;
        int[][][] dp=new int[n+1][2][3];
        
        for(int idx=n-1; idx>=0; idx--){
            for(int turn=0; turn<=1; turn++){
                for(int cap=1; cap<=2; cap++){
                    int ans=0;
                    if(turn==1){
                        ans=Math.max(-prices[idx] + dp[idx+1][0][cap] , dp[idx+1][1][cap]);
                    }
                    else{
                        ans=Math.max(prices[idx] + dp[idx+1][1][cap-1] , dp[idx+1][0][cap]);
                    }
                    dp[idx][turn][cap]=ans;
                }
            }
        }
        return dp[0][1][2];
    }
    



    // public int maxProfit(int[] prices) {
    //     int[][][] dp=new int[prices.length][2][3];
    //     for(int[][] r:dp){
    //         for(int[] c:r){
    //             Arrays.fill(c, -1);
    //         }
    //     }
    //     return solve(0, 1, 2, prices, dp);
    // }
    // public int solve(int idx, int turn, int cap, int[] arr, int[][][] dp){
    //     if(idx==arr.length || cap==0){
    //         return 0;
    //     }
    //     if(dp[idx][turn][cap]!=-1){
    //         return dp[idx][turn][cap];
    //     }
    //     int ans=0;
    //     if(turn==1){
    //         ans=Math.max(-arr[idx] + solve(idx+1, 0, cap, arr, dp) , solve(idx+1, 1, cap, arr, dp));
    //     }
    //     else{
    //         ans=Math.max(arr[idx] + solve(idx+1, 1, cap-1, arr, dp) , solve(idx+1, 0, cap, arr, dp));
    //     }
    //     return dp[idx][turn][cap]=ans;
    // }



    // public int maxProfit(int[] prices) {
    //     return solve(0, 1, 2, prices);
    // }
    // public int solve(int idx, int turn, int cap, int[] arr){
    //     if(idx==arr.length || cap==0){
    //         return 0;
    //     }
    //     int ans=0;
    //     if(turn==1){
    //         ans=Math.max(-arr[idx] + solve(idx+1, 0, cap, arr) , solve(idx+1, 1, cap, arr));
    //     }
    //     else{
    //         ans=Math.max(arr[idx] + solve(idx+1, 1, cap-1, arr) , solve(idx+1, 0, cap, arr));
    //     }
    //     return ans;
    // }
}