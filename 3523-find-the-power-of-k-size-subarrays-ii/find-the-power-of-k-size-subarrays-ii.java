class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int n=nums.length;
        
        if(k==1){
            return nums;
        }

        int[] ans=new int[n-k+1];
        int streak=1;
        int x=0;

        for(int i=1; i<n; i++){
            if(nums[i]==nums[i-1]+1){
                streak++;
            }
            else{
                streak=1;
            }

            if(i>=k-1){
                if(streak>=k){
                    ans[x]=nums[i];
                }
                else{
                    ans[x]=-1;
                }
                x++;
            }
        }
        return ans;
    }
}