class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return solve(nums.length-1, target, nums);
    }
    public int solve(int idx, int target, int[] arr){
        if(idx==0){
            if(target==0 && arr[0]==0){
                return 2;
            }
            if(target==arr[0] || target==-arr[0]){
                return 1;
            }
            else{
                return 0;
            }
        }
        int plus=solve(idx-1, target-arr[idx], arr);
        int minus=solve(idx-1, target+arr[idx], arr);
        return plus + minus;
    }
}