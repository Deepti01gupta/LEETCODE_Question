class Solution {
    public boolean canBeIncreasing(int[] nums) {
        int c=0;
        int n=nums.length;

        for(int i=0; i<n; i++){
            int prev=-1;
            boolean ok=true;

            for(int j=0; j<n; j++){
                if(j==i) continue;

                if(prev!=-1 && nums[prev]>=nums[j]){
                    ok=false;
                    break;
                }

                prev=j;
            }

            if(ok){
                return true;
            }
        }

        return false;
    }
}