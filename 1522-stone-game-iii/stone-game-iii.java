class Solution {
    public String stoneGameIII(int[] stoneValue) {

        int n=stoneValue.length;
        Integer[] dp=new Integer[n];

        int diff=solve(0, stoneValue, dp);

        if(diff>0){
            return "Alice";
        }
        else if(diff<0){
            return "Bob";
        }

        return "Tie";
    }

    private int solve(int idx, int[] arr, Integer[] dp){
        if(idx>=arr.length){
            return 0;
        }

        if(dp[idx]!=null){
            return dp[idx];
        }

        int take=0;
        int best=Integer.MIN_VALUE;

        for(int k=0; k<3 && idx+k<arr.length; k++){
            
            take+=arr[idx+k];

            best=Math.max(best, take - solve(idx+k+1, arr, dp));

        }

        return dp[idx]=best;
    }
}