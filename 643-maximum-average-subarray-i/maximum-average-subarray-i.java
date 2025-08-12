class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int sum=0;
        for(int i=0; i<k; i++){
            sum+=nums[i];
        }
        double avg=(double)sum/k;
        double ans=avg;
        for(int i=k; i<nums.length; i++){
            sum=sum+nums[i]-nums[i-k];
            avg=(double)sum/k;
            ans=Math.max(ans,avg);
        }
        return ans;
    }
}