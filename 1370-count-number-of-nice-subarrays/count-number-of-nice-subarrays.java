class Solution {
    public int numberOfSubarrays(int[] nums, int k){
        return solve(nums, k) - solve(nums, k-1);
    }

    public int solve(int[] nums, int k) {
        if(k<0){
            return 0;
        }

        int cur=0;
        int ans=0;
        int left=0;

        for(int right=0; right<nums.length; right++){
            if(nums[right]%2!=0){
                cur++;
            }

            while(cur>k){
                if(nums[left]%2!=0){
                    cur--;
                }
                left++;
            }

            ans+=right-left+1;
        }

        return ans;
    }
}