class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int ans=0;
        int cur=0;

        for(int i:nums){
            if(i==1) cur++;
            else{
                cur=0;
            }
            ans=Math.max(ans,cur);
        }

        return ans;
    }
}