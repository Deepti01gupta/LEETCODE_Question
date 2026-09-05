class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int cur=0;
        int ans=0;
        int left=0;
        int count=0;

        for(int right=0; right<nums.length; right++){
            if(nums[right]%2!=0){
                cur++;
                count=0;
            }

            while(cur>k){
                if(nums[left]%2!=0){
                    cur--;
                }
                left++;
            }

            if(cur==k){
                while(nums[left]%2==0){
                    count++;
                    left++;
                }

                ans+=count+1;
            }
        }

        return ans;
    }
}