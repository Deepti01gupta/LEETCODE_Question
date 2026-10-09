class Solution {
    public int maxCoins(int[] nums) {
        int n=nums.length;
        int[] arr=new int[n+2];
        arr[0]=1;
        for(int i=0; i<n; i++){
            arr[i+1]=nums[i];
        }
        arr[n+1]=1;
        int[][] dp=new int[n+2][n+2];
        for(int[] r:dp){
            Arrays.fill(r, -1);
        }
        return solve(1,n,arr, dp);
    }
    public int solve(int i, int j, int[] arr, int[][] dp){
        if(i>j){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int ans=Integer.MIN_VALUE;
        for(int k=i; k<=j; k++){
            int steps=(arr[i-1]*arr[k]*arr[j+1]) + solve(i, k-1, arr, dp) + solve(k+1, j, arr, dp);
            ans=Math.max(ans, steps);
        }
        return dp[i][j]=ans;
    }



    // public int maxCoins(int[] nums) {
    //     int n=nums.length;
    //     int[] arr=new int[n+2];
    //     arr[0]=1;
    //     for(int i=0; i<n; i++){
    //         arr[i+1]=nums[i];
    //     }
    //     arr[n+1]=1;
    //     return solve(1,n,arr);
    // }
    // public int solve(int i, int j, int[] arr){
    //     if(i>j){
    //         return 0;
    //     }
    //     int ans=Integer.MIN_VALUE;
    //     for(int k=i; k<=j; k++){
    //         int steps=(arr[i-1]*arr[k]*arr[j+1]) + solve(i,k-1,arr) + solve(k+1, j, arr);
    //         ans=Math.max(ans, steps);
    //     }
    //     return ans;
    // }
}