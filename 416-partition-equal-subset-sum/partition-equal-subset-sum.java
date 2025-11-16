class Solution {
    public boolean canPartition(int[] nums) {
        int n=nums.length;
        int total=0;
        for(int i:nums) total+=i;
        if(total%2!=0) return false;

        int k=total/2;
        int[][] dp=new int[n][k+1];
        for(int[] r:dp){
            Arrays.fill(r,-1);
        }
        return subsetSumToK(nums,n-1,k,dp);
    }

    public boolean subsetSumToK(int[] arr,int ind, int t, int[][] dp){
        if(t==0) return true;
        if(ind==0) return (arr[ind]==t);
        if(dp[ind][t]!=-1) return (dp[ind][t]==0)? false:true;

        boolean nottake=subsetSumToK(arr,ind-1,t,dp);
        boolean take=false;
        if(arr[ind]<=t){
            take=subsetSumToK(arr,ind-1,t-arr[ind],dp);
        }
        dp[ind][t]= (nottake || take)? 1:0;
        return nottake || take;
    }
}