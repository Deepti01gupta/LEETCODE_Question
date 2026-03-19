class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n=arr.length;

        // return solve(0,arr,k);

        int[] dp=new int[n];
        Arrays.fill(dp,-1);
        return solve2(0,arr,k,dp);
    }

    private int solve2(int idx, int[] arr, int k, int[] dp){
        int n=arr.length;
        if(idx==n){
            return 0;
        }

        if(dp[idx]!=-1){
            return dp[idx];
        }

        int len=0;
        int max=0;
        int ans=0;

        for(int i=idx; i<Math.min(n,idx+k); i++){
            len++;
            max=Math.max(max,arr[i]);
            int sum=(len*max) + solve2(i+1,arr,k,dp);
            ans=Math.max(ans, sum);
        }

        return dp[idx]=ans;
    }

    private int solve(int idx, int[] arr, int k){
        int n=arr.length;
        if(idx==n){
            return 0;
        }

        int len=0;
        int max=0;
        int ans=0;

        for(int i=idx; i<Math.min(n,idx+k); i++){
            len++;
            max=Math.max(max,arr[i]);
            int sum=(len*max) + solve(i+1,arr,k);
            ans=Math.max(ans, sum);
        }

        return ans;
    }
}