class Solution {
    public int longestOnes(int[] nums, int k) {
        // tc: O(n) sc : O(1)
        int zero_c=0;
        int l=0;
        int max=0;

        for(int r=0; r<nums.length; r++){
           if(nums[r]==0){
            zero_c++;
           }
           while(zero_c>k){
            if(nums[l]==0){
                zero_c--;
            }
            l++;
           }
           max=Math.max(max,r-l+1);
        }
        return max;
    }
}