class Solution {
    public int countPartitions(int[] nums) {
        int n=nums.length;
        int total=0;
        for(int i:nums) total+=i;
        int ans=0;
        int sum=0;
        for(int i=0; i<n-1; i++){
            sum+=nums[i];
            if((sum%2)==((total-sum)%2)){
                ans++;
            }
        }
        return ans;
    }
}