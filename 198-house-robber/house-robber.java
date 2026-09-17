class Solution {
    // public int rob(int[] nums) {
        
    // }
    // public int rob(int[] nums) {
        
    // }

    public int rob(int[] nums) {
        int[] dp=new int[nums.length];
        Arrays.fill(dp,-1); 

        return solve(nums.length-1, nums, dp);
    }
    public int solve(int idx, int[] nums, int[] dp){
        if(idx==0){
            return nums[idx];
        }
        if(idx<0){
            return 0;
        }

        if(dp[idx]!=-1){
            return dp[idx];
        }

        int take=nums[idx] + solve(idx-2, nums, dp);
        int nottake=solve(idx-1, nums, dp);

        return dp[idx]=Math.max(take, nottake);
    }



    // public int rob(int[] nums) {
    //     return solve(nums.length-1, nums);
    // }
    // public int solve(int idx, int[] nums){
    //     if(idx==0){
    //         return nums[idx];
    //     }
    //     if(idx<0){
    //         return 0;
    //     }

    //     int take=nums[idx] + solve(idx-2, nums);
    //     int nottake=solve(idx-1, nums);

    //     return Math.max(take, nottake);
    // }
}