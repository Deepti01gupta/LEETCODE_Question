class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1){
            return nums[0];
        }
		int[] dp1=new int[nums.length];
        Arrays.fill(dp1,-1);
        int case1=Robber2(nums,0,n-2,dp1);

        int[] dp2=new int[nums.length];
        Arrays.fill(dp2,-1);
        int case2=Robber2(nums,1,n-1,dp2);

        return Math.max(case1,case2);
        
    }
	
	public int Robber2(int[] arr, int i, int end, int[] dp) {
		if(i>end) {
			return 0;
		}
		if(dp[i]!=-1) {
			return dp[i];
		}
		
		int rob = arr[i] + Robber2(arr,i+2, end,dp);
		int dont_rob = Robber2(arr,i+1,end, dp);
		return dp[i]=Math.max(rob, dont_rob);
	}

}