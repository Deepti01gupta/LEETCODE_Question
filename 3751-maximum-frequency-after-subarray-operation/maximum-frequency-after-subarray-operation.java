class Solution {
    public int maxFrequency(int[] nums, int k) {
        int count=0;
        for(int i:nums){
            if(i==k){
                count++;
            }
        }

        int ans=0;
        for(int m=1; m<=50; m++){
            if(m==k){
                continue;
            }

            int cur=0, max=0;
            for(int i:nums){
                cur+=(i==m)? 1:(i==k)?-1:0;
                cur=Math.max(cur,0);
                max=Math.max(max,cur);
            }

            ans=Math.max(ans,max);
        }
        return ans+count;
    }
}