class Solution {
    public long maxTotalValue(int[] nums, int k) {
        Arrays.sort(nums);
        int val=nums[nums.length-1]-nums[0];
        long ans=(long)val*k;
        return ans;
    }
}