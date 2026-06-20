class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int maxEnd=0;
        int minEnd=0;

        int maxSum=0;
        int minSum=0;

        for(int num:nums){
            maxEnd=Math.max(num, maxEnd+num);
            maxSum=Math.max(maxSum, maxEnd);

            minEnd=Math.min(num, minEnd+num);
            minSum=Math.min(minSum, minEnd);
        }

        return Math.max(maxSum, Math.abs(minSum));
    }
}