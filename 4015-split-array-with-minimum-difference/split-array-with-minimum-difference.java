class Solution {
    public long splitArray(int[] nums) {
        int n=nums.length;

        boolean[] inc=new boolean[n];
        inc[0]=true;
        for(int i=1; i<n; i++){
            
            inc[i]=inc[i-1] && (nums[i]>nums[i-1]);
        }

        boolean[] dec=new boolean[n];
        dec[n-1]=true;
        for(int i=n-2; i>=0; i--){
            
            dec[i]=dec[i+1] && (nums[i]>nums[i+1]);
        }

        long[] prefix=new long[n];
        prefix[0]=nums[0];

        for(int i=1; i<n; i++){

            prefix[i]=prefix[i-1] + nums[i];
        }

        long total=prefix[n-1];
        long ans=Long.MAX_VALUE;

        for(int i=0; i<n-1; i++){
            if(inc[i] && dec[i+1]){
                long left=prefix[i];
                long right=total-left;

                ans=Math.min(ans, Math.abs(left-right));
            }
        }

        return ans==Long.MAX_VALUE? -1:ans;



    }
}