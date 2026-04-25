class Solution {
    public int pivotIndex(int[] nums) {
        int rsum=0;
        for(int ele:nums){
            rsum+=ele;
        }
        int lsum=0;
        for(int i=0; i<nums.length; i++){
            if(lsum == rsum - nums[i] ){
                return i;
            }
            lsum += nums[i];
            rsum -= nums[i];
        }
        return -1;
    }
}