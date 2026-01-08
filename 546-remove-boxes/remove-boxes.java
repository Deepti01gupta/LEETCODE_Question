class Solution {
    public int removeBoxes(int[] boxes) {
        int n=boxes.length;
        int[][][] dp=new int[n][n][n];

        for(int[][] r:dp){
            for(int[] i:r){
                Arrays.fill(i,-1);
            }
        }

        return solve(boxes,0,n-1,0,dp);
    }

    private int solve(int[] boxes, int l, int r, int k, int[][][] dp){
        if(l>r){
            return 0;
        }

        if(dp[l][r][k]!=-1){
            return dp[l][r][k];
        }

        int curr_l=l;
        int curr_k=k;

        while(l+1<=r && boxes[l]==boxes[l+1]){
            l++;
            k++;
        }

        int ans=(k+1)*(k+1) + solve(boxes,l+1,r,0,dp);

        for(int m=l+1; m<=r; m++){
            if(boxes[m]==boxes[l]){
                ans=Math.max(ans, solve(boxes,l+1, m-1, 0,dp) + solve(boxes, m,r,k+1,dp));
            }
        }

        return dp[curr_l][r][curr_k]=ans;
    }
}