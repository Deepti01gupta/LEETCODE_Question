class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int n=nums.size();

        boolean[] inc=new boolean[n];

        for(int i=0; i<=n-k; i++){
            boolean ok=true;

            for(int j=i; j<i+k-1; j++){
                if(nums.get(j)>=nums.get(j+1)){
                    ok=false;
                    break;
                }
            }

            inc[i]=ok;
        }

        for(int i=0; i<=n-2*k; i++){
            if(inc[i] && inc[i+k]){
                return true;
            }
        }

        return false;
    }
}