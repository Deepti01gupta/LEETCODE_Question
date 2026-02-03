class Solution {
    static final int mod=1_000_000_007;

    public int numberOfStableArrays(int zero, int one, int limit){
        long[][][] dp=new long[zero+1][one+1][2];

        // base case
        for(int i=1; i<=Math.min(zero,limit); i++){
            dp[i][0][0]=1;
        }

        for(int i=1; i<=Math.min(one,limit); i++){
            dp[0][i][1]=1;
        }

        // main solution
        for(int i=1; i<=zero; i++){
            for(int j=1; j<=one; j++){

                dp[i][j][0]=(dp[i-1][j][0] + dp[i-1][j][1]) % mod;
                if(i>limit){
                    dp[i][j][0]=(dp[i][j][0] + mod - dp[i-limit-1][j][1]) % mod;
                }

                dp[i][j][1]=(dp[i][j-1][0] + dp[i][j-1][1]) % mod;
                if(j>limit){
                    dp[i][j][1]=(dp[i][j][1] + mod - dp[i][j-limit-1][0]) % mod;
                }
            }
        }
        return (int)((dp[zero][one][0] + dp[zero][one][1]) % mod);
    }
}

// MEMORIZATION

// class Solution {
//     static final int mod=1_000_000_007;
//     int limit;
//     Integer[][][][] dp;

//     public int numberOfStableArrays(int zero, int one, int limit) {
//         this.limit=limit;
//         dp=new Integer[zero+1][one+1][2][limit+1];

//         long ans=0;

//         if(zero>0){
//             ans+=dfs(zero-1,one,0,1);
//         }

//         if(one>0){
//             ans+=dfs(zero,one-1,1,1);
//         }

//         return (int)(ans%mod);
//     }

//     public int dfs(int z, int o, int last, int c){
//         if(c>limit){
//             return 0;
//         }

//         if(z==0 && o==0){
//             return 1;
//         }

//         if(dp[z][o][last][c]!=null){
//             return dp[z][o][last][c];
//         }

//         long ways=0;

//         if(z>0){
//             if(last==0){
//                 ways+=dfs(z-1,o,0,c+1);
//             }
//             else{
//                 ways+=dfs(z-1,o,0,1);
//             }
//         }

//         if(o>0){
//             if(last==1){
//                 ways+=dfs(z,o-1,1,c+1);
//             }
//             else{
//                 ways+=dfs(z,o-1,1,1);
//             }
//         }

//         return dp[z][o][last][c]=(int)(ways%mod);
//     }
// }