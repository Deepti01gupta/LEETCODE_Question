class Solution {
    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        int n=nums.length;

        int[] ans=new int[n-k+1];

        int[] fre=new int[51];

        for(int i=0; i<k; i++){
            if(nums[i]<0){
                fre[-nums[i]]++;
            }
        }

        for(int i=0; i<n-k+1; i++){
            int c=0;
            int beauty=0;

            for(int val=50; val>=1; val--){
                c+=fre[val];
                if(c>=x){
                    beauty-=val;
                    break;
                }
            }

            ans[i]=beauty;

            if(i+k<n){
                if(nums[i]<0){
                    fre[-nums[i]]--;
                }
                if(nums[i+k]<0){
                    fre[-nums[i+k]]++;
                }
            }
        }

        return ans;
    }
}