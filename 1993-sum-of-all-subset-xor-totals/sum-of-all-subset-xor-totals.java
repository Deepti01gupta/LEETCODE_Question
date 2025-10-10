class Solution {
    public int subsetXORSum(int[] nums) {
        return dfs(nums,0,0);
    }

    public int dfs(int[] nums, int i, int xor){
        if(i==nums.length){
            return xor;
        }
        int inc=dfs(nums,i+1,xor^nums[i]);
        int exc=dfs(nums,i+1,xor);
        return inc+exc;
    }
}