class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n=nums.length;

        int[] even=new int[n/2];
        int[] odd=new int[n/2];

        int e=0, o=0;

        for(int i:nums){
            if(i>=0){
                even[e++]=i;
            }
            else{
                odd[o++]=i;
            }
        }

        int[] ans=new int[n];
        e=0;
        o=0;

        for(int i=0; i<n; i++){
            if(i%2==0) ans[i]=even[e++];
            else ans[i]=odd[o++];
        }

        return ans;
    }
}