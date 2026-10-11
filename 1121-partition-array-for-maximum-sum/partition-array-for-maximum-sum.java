class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int[] dp=new int[arr.length+1];
        for(int idx=arr.length-1; idx>=0; idx--){
            int len=0;
            int max=Integer.MIN_VALUE;
            int ans=Integer.MIN_VALUE;
            for(int j=idx; j<Math.min(idx+k, arr.length); j++){
                len++;
                max=Math.max(max, arr[j]);
                int sum=len*max + dp[j+1];
                ans=Math.max(ans, sum);
            }
            dp[idx]=ans;
        }
        return dp[0];
    }



    // public int maxSumAfterPartitioning(int[] arr, int k) {
    //     int[] dp=new int[arr.length];
    //     Arrays.fill(dp, -1);
    //     return solve(0, arr, k, dp);
    // }
    // public int solve(int idx, int[] arr, int k, int[] dp){
    //     if(idx==arr.length){
    //         return 0;
    //     }
    //     if(dp[idx]!=-1){
    //         return dp[idx];
    //     }
    //     int len=0;
    //     int max=Integer.MIN_VALUE;
    //     int ans=Integer.MIN_VALUE;
    //     for(int j=idx; j<Math.min(idx+k, arr.length); j++){
    //         len++;
    //         max=Math.max(max, arr[j]);
    //         int sum=len*max + solve(j+1, arr, k, dp);
    //         ans=Math.max(ans, sum);
    //     }
    //     return dp[idx]=ans;
    // }



    // public int maxSumAfterPartitioning(int[] arr, int k) {
    //     return solve(0, arr, k);
    // }
    // public int solve(int idx, int[] arr, int k){
    //     if(idx==arr.length){
    //         return 0;
    //     }
    //     int len=0;
    //     int max=Integer.MIN_VALUE;
    //     int ans=Integer.MIN_VALUE;
    //     for(int j=idx; j<Math.min(idx+k, arr.length); j++){
    //         len++;
    //         max=Math.max(max, arr[j]);
    //         int sum=len*max + solve(j+1, arr, k);
    //         ans=Math.max(ans, sum);
    //     }
    //     return ans;
    // }
}