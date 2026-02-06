class Solution {
    public long maximumTripletValue(int[] nums) {
        int n=nums.length;

        long[] arr=new long[n];
        for(int i=0; i<n; i++){
            arr[i]=nums[i];
        }

        long[] left=new long[n];
        left[0]=arr[0];
        for(int i=1; i<n; i++){
            left[i]=Math.max(left[i-1],arr[i]);
        }

        long[] right=new long[n];
        right[n-1]=arr[n-1];
        for(int i=n-2; i>=0; i--){
            right[i]=Math.max(right[i+1],arr[i]);
        }

        long ans=0;
        for(int i=1; i<n-1; i++){
            long l=left[i-1];
            long r=right[i+1];

            ans=Math.max(ans,(l-arr[i])*r);
        }

        return ans;


    }
}