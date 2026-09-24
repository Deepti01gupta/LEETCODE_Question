class Solution {
    public int findNumberOfLIS(int[] arr) {
        int n=arr.length;
        int[] dp=new int[n];
        int[] cnt=new int[n];
        int max=0;

        for(int i=0; i<n; i++){
            dp[i]=1;
            cnt[i]=1;
            for(int prev=0; prev<i; prev++){
                if(arr[prev]<arr[i] && 1+dp[prev]>dp[i]){
                    dp[i]=1+dp[prev];
                    cnt[i]=cnt[prev];
                }
                else if(arr[prev]<arr[i] && 1+dp[prev]==dp[i]){
                    cnt[i]+=cnt[prev];
                }
            }
            max=Math.max(max, dp[i]);
        }

        int ans=0;
        for(int i=0; i<n; i++){
            if(dp[i]==max){
                ans+=cnt[i];
            }
        }
        return ans;
    }
}