class Solution {
    public boolean predictTheWinner(int[] arr) {
        int sum=0;
        int[][] dp=new int[arr.length][arr.length];
		for(int i=0; i<arr.length; i++) {
            sum+=arr[i];
			Arrays.fill(dp[i], -1);
		}
		int score = optimal_game_strategy_2(arr,0,arr.length-1,dp);
        if(score>=sum-score){
            return true;
        }
        return false;

	}
	
	
	public static int optimal_game_strategy_2(int[] arr, int i, int j, int[][] dp) {
		if(i>j) {
			return 0;
		}
		if(dp[i][j]!=-1) {
			return dp[i][j];
		}
		int f=arr[i] + Math.min(optimal_game_strategy_2(arr,i+2,j,dp) , optimal_game_strategy_2(arr,i+1,j-1,dp));
		int s=arr[j] + Math.min(optimal_game_strategy_2(arr,i+1,j-1,dp) , optimal_game_strategy_2(arr,i,j-2,dp));
		return dp[i][j]=Math.max(f, s);
    }
}