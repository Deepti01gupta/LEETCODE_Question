class Solution {
    public int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);
        int[] arr=new int[cuts.length+2];
        arr[0]=0;
        for(int i=0; i<cuts.length; i++){
            arr[i+1]=cuts[i];
        }
        arr[arr.length-1]=n;
        int c=cuts.length;
        int[][] dp=new int[c+2][c+2];
        for(int i=c; i>=1; i--){
            for(int j=1; j<=c; j++){
                if(i>j){
                    continue;
                }
                int mini=Integer.MAX_VALUE;
                for(int idx=i; idx<=j; idx++){
                    int sum=arr[j+1] - arr[i-1] + dp[i][idx-1] + dp[idx+1][j];
                    mini=Math.min(mini, sum);
                }
                dp[i][j]=mini;
            }
        }
        return dp[1][cuts.length];
    }



    // public int minCost(int n, int[] cuts) {
    //     Arrays.sort(cuts);
    //     int[] arr=new int[cuts.length+2];
    //     arr[0]=0;
    //     for(int i=0; i<cuts.length; i++){
    //         arr[i+1]=cuts[i];
    //     }
    //     arr[arr.length-1]=n;
    //     int[][] dp=new int[arr.length][arr.length];
    //     for(int[] r:dp){
    //         Arrays.fill(r, -1);
    //     }
    //     return solve(1, cuts.length, arr, dp);
    // }
    // public int solve(int i, int j, int[] arr, int[][] dp){
    //     if(i>j){
    //         return 0;
    //     }
    //     if(dp[i][j]!=-1){
    //         return dp[i][j];
    //     }
    //     int mini=Integer.MAX_VALUE;
    //     for(int idx=i; idx<=j; idx++){
    //         int sum=arr[j+1] - arr[i-1] + solve(i, idx-1, arr, dp) + solve(idx+1, j, arr, dp);
    //         mini=Math.min(mini, sum);
    //     }
    //     return dp[i][j]=mini;
    // }



    // public int minCost(int n, int[] cuts) {
    //     Arrays.sort(cuts);
    //     int[] arr=new int[cuts.length+2];
    //     arr[0]=0;
    //     for(int i=0; i<cuts.length; i++){
    //         arr[i+1]=cuts[i];
    //     }
    //     arr[arr.length-1]=n;
    //     int[][] dp=new int[arr.length][arr.length];
    //     for(int[] r:dp){
    //         Arrays.fill(r, -1);
    //     }
    //     return solve(1, cuts.length, arr, dp);
    // }
    // public int solve(int i, int j, int[] arr, int[][] dp){
    //     if(i>j){
    //         return 0;
    //     }
    //     if(dp[i][j]!=-1){
    //         return dp[i][j];
    //     }
    //     int mini=Integer.MAX_VALUE;
    //     for(int idx=i; idx<=j; idx++){
    //         int sum=arr[j+1] - arr[i-1] + solve(i, idx-1, arr, dp) + solve(idx+1, j, arr, dp);
    //         mini=Math.min(mini, sum);
    //     }
    //     return dp[i][j]=mini;
    // }



    // public int minCost(int n, int[] cuts) {
    //     Arrays.sort(cuts);
    //     int[] arr=new int[cuts.length+2];
    //     arr[0]=0;
    //     for(int i=0; i<cuts.length; i++){
    //         arr[i+1]=cuts[i];
    //     }
    //     arr[arr.length-1]=n;
    //     return solve(1, cuts.length, arr);
    // }
    // public int solve(int i, int j, int[] arr){
    //     if(i>j){
    //         return 0;
    //     }
    //     int mini=Integer.MAX_VALUE;
    //     for(int idx=i; idx<=j; idx++){
    //         int sum=arr[j+1] - arr[i-1] + solve(i, idx-1, arr) + solve(idx+1, j, arr);
    //         mini=Math.min(mini, sum);
    //     }
    //     return mini;
    // }
}