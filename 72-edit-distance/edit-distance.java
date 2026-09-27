class Solution {
    public int minDistance(String word1, String word2) {
        int n=word1.length();
        int m=word2.length();
        int[][] dp=new int[n][m];
        for(int[] r:dp){
            Arrays.fill(r, -1);
        }
        return solve(n-1, m-1, word1, word2, dp);
    }
    public int solve(int i, int j, String s, String t, int[][] dp){
        if(i<0){
            return j+1;
        }
        if(j<0){
            return i+1;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        if(s.charAt(i)==t.charAt(j)){
            return dp[i][j]=0 + solve(i-1, j-1, s, t, dp);
        }
        int I=solve(i, j-1, s, t, dp);
        int D=solve(i-1, j, s, t, dp);
        int R=solve(i-1, j-1, s, t, dp);
        return dp[i][j]=1 + Math.min(I, Math.min(R, D));
    }



    // public int minDistance(String word1, String word2) {
    //     int n=word1.length();
    //     int m=word2.length();
    //     return solve(n-1, m-1, word1, word2);
    // }
    // public int solve(int i, int j, String s, String t){
    //     if(i<0){
    //         return j+1;
    //     }
    //     if(j<0){
    //         return i+1;
    //     }
    //     if(s.charAt(i)==t.charAt(j)){
    //         return 0 + solve(i-1, j-1, s, t);
    //     }
    //     int I=solve(i, j-1, s, t);
    //     int D=solve(i-1, j, s, t);
    //     int R=solve(i-1, j-1, s, t);
    //     return 1 + Math.min(I, Math.min(R, D));
    // }
}