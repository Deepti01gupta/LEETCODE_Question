class Solution {
    public int numberOfGoodSubarraySplits(int[] nums) {
        long count=1;
        int left=-1;
        int MOD = 1000000007;
        for(int i=0; i<nums.length; i++){
            if(nums[i]==1){
                left=i;
                break;
            }
        }
        if(left==-1){
            return 0;
        }
        for(int right=left+1; right<nums.length; right++){
            if(nums[right]==1){
                count=(count*(right-left))%MOD;
                left=right;
            }
        }
        return (int)count;
    }
}