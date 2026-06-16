class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return solve(nums, target, 0, 0);
    }

    public int solve(int[] nums, int t, int idx, int sum){
        if(idx==nums.length){
            if(sum==t){
                return 1;
            }
            return 0;
        }

        int ans=0;
        ans+=solve(nums,t,idx+1,sum+nums[idx]);
        ans+=solve(nums,t,idx+1,sum-nums[idx]);

        return ans;
    }
}