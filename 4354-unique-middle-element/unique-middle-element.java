class Solution {
    public boolean isMiddleElementUnique(int[] nums) {
        int n=nums.length;
        int mid=n/2;
        int val=nums[mid];
        for(int i=0; i<n; i++){
            if(i==mid) continue;
            if(nums[i]==val) return false;
        }
        return true;
    }
}