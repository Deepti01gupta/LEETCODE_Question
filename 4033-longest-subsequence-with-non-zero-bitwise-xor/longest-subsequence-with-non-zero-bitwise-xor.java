class Solution {
    public int longestSubsequence(int[] nums) {
        int n=nums.length;
        int[] arr=nums;
        if(n==0){
            return 0;
        }

        int total=0;
        boolean flag=false;

        for(int i:arr){
            total^=i;
            if(i!=0){
                flag=true;
            }
        }

        if(total!=0){
            return n;
        }
        if(flag){
            return n-1;
        }
        else{
            return 0;
        }
    }
}