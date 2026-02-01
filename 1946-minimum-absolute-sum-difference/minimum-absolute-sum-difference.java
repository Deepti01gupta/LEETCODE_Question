class Solution {

    
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int mod=1_000_000_007;
        int n=nums1.length;

        int[] arr=nums1.clone();
        Arrays.sort(arr);

        long sum=0;
        int max=0;

        for(int i=0; i<n; i++){
            int cur=Math.abs(nums1[i]-nums2[i]);
            sum=(sum+cur)%mod;

            int idx=Arrays.binarySearch(arr,nums2[i]);
            if(idx<0){
                idx=-idx-1;
            }

            if(idx<n){
                max=Math.max(max,cur-Math.abs(arr[idx]-nums2[i]));
            }

            if(idx>0){
                max=Math.max(max,cur-Math.abs(arr[idx-1]-nums2[i]));
            }
        }

        return (int)((sum-max+mod)%mod);
    }

    // public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
    //     int mod=1_000_000_007;
    //     int sum=0;
    //     int rp=Integer.MIN_VALUE;
    //     int idx=-1;

    //     for(int i=0; i<nums1.length; i++){
    //         int v=Math.abs(nums1[i]-nums2[i]);
    //         sum=(sum+v)%mod;
    //         if(v>rp){
    //             rp=v;
    //             idx=i;
    //         }
    //     }

    //     int val=rp;
    
    //     for(int i=0; i<nums1.length; i++){

    //         int b=nums1[i];
    //         val=Math.min(val,Math.abs(nums2[idx]-b));
    //     }

    //     sum=(sum-rp+val+mod)%mod;
    //     return sum;

    // }
}