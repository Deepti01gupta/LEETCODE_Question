class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int[] ans=new int[nums.size()];

        for(int i=0; i<nums.size(); i++){
            int idx=-1;
            for(int j=0; j<=1000; j++){
                if((j|(j+1))==nums.get(i)){
                    idx=j;
                    break;
                }
            }
            ans[i]=idx;
        }

        return ans;
    }
}