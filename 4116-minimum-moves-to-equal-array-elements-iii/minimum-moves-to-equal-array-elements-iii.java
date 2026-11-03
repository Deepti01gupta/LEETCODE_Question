class Solution {
    public int minMoves(int[] nums) {
        int ans=0;
        Arrays.sort(nums);
        int t=nums[nums.length-1];
        for(int i=0; i<nums.length-1; i++){
            ans+=t-nums[i];
        }
        return ans;
    }
}