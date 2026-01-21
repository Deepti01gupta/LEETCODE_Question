class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int n=nums1.length;
        int m=nums2.length;

        int ans=0;
        if(n%2==0 && m%2==0){
            ans=0;
        }
        else if(n%2!=0 && m%2!=0){
            for(int i:nums1){
                ans^=i;
            }
            for(int i:nums2){
                ans^=i;
            }
        }
        else if(n%2==0){
            for(int i:nums1){
                ans^=i;
            }
        }
        else if(m%2==0){
            for(int i:nums2){
                ans^=i;
            }
        }
        return ans;
    }

}