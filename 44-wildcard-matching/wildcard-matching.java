class Solution {
    public boolean isMatch(String s, String p) {
        int n=p.length();
        int m=s.length();
        Boolean[][] dp=new Boolean[n][m];
        return solve(n-1, m-1, s, p, dp);
    }
    public boolean solve(int i, int j, String s, String p, Boolean[][] dp){
        if(i<0 && j<0){
            return true;
        }
        if(i<0 && j>=0){
            return false;
        }
        if(j<0 && i>=0){
            for(int ii=0; ii<=i; ii++){
                if(p.charAt(ii)!='*'){
                    return false;
                }
            }
            return true;
        }
        if(dp[i][j]!=null){
            return dp[i][j];
        }
        if(p.charAt(i)==s.charAt(j) || p.charAt(i)=='?'){
            return dp[i][j]=solve(i-1, j-1, s, p, dp);
        }
        if(p.charAt(i)=='*'){
            return dp[i][j]=solve(i-1, j, s, p, dp) || solve(i, j-1, s, p, dp);
        }
        return dp[i][j]=false;
    }



    // public boolean isMatch(String s, String p) {
    //     int n=p.length();
    //     int m=s.length();
    //     return solve(n-1, m-1, s, p);
    // }
    // public boolean solve(int i, int j, String s, String p){
    //     if(i<0 && j<0){
    //         return true;
    //     }
    //     if(i<0 && j>=0){
    //         return false;
    //     }
    //     if(j<0 && i>=0){
    //         for(int ii=0; ii<=i; ii++){
    //             if(p.charAt(ii)!='*'){
    //                 return false;
    //             }
    //         }
    //         return true;
    //     }
    //     if(p.charAt(i)==s.charAt(j) || p.charAt(i)=='?'){
    //         return solve(i-1, j-1, s, p);
    //     }
    //     if(p.charAt(i)=='*'){
    //         return solve(i-1, j, s, p) || solve(i, j-1, s, p);
    //     }
    //     return false;
    // }
}