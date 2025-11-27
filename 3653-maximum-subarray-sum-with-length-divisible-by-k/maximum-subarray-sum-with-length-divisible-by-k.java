class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        int n=nums.length;
        long[] pre=new long[n];
        pre[0]=nums[0];
        for(int i=1; i<n; i++){
            pre[i]=pre[i-1]+nums[i];
        }

        long res=Long.MIN_VALUE;

        for(int start=0; start<k; start++){
            long curr=0;
            int i=start;

            while(i+k-1<n){
                int j=i+k-1;

                long subsum=pre[j]-((i>0)? pre[i-1]:0);
                curr=Math.max(subsum,curr+subsum);

                res=Math.max(res,curr);
                i+=k;
            }
        }
        return res;
    }
}