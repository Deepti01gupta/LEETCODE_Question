class Solution {
    public int maxCoins(int[] nums) {
        int[] a=new int[nums.length+2];
		a[0]=a[a.length-1]=1;
		for(int i=0; i<nums.length; i++) {
			a[i+1]=nums[i];
		}
		// return burst_coin(a,0,a.length-1);

        int[][] dp=new int[a.length][a.length];
		for(int i=0; i<a.length; i++) {
			Arrays.fill(dp[i], -1);
		}
		return burst_coin_2(a, 0, a.length-1, dp);

	}
	
	
	public static int burst_coin_2(int[] a, int i, int j, int[][] dp) {
		if(i+1==j) {
			return 0;
		}
		if(dp[i][j]!=-1) {
			return dp[i][j];
		}
		int ans=Integer.MIN_VALUE;
		for(int k=i+1; k<j; k++) {
			int left=burst_coin_2(a,i,k,dp);
			int right=burst_coin_2(a,k,j,dp);
			int self=a[i]*a[j]*a[k];
			ans=Math.max(ans, left+right+self);
		}
		return dp[i][j]=ans;

	}
	
	// public static int burst_coin(int[] a, int i, int j) {
	// 	if(i+1==j) {
	// 		return 0;
	// 	}
		
	// 	int ans=Integer.MIN_VALUE;
	// 	for(int k=i+1; k<j; k++) {
	// 		int left=burst_coin(a,i,k);
	// 		int right=burst_coin(a,k,j);
	// 		int self=a[i]*a[j]*a[k];
	// 		ans=Math.max(ans, left+right+self);
	// 	}
	// 	return ans;
    // }
}