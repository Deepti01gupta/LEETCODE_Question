class Solution {

    public int numberOfStableArrays(int zero, int one, int limit) {
        int mod=1_000_000_007;

        int[][][] dp=new int[zero+1][one+1][2];

        for(int i=1; i<=Math.min(zero,limit); i++){
            dp[i][0][0]=1;
        }

        for(int j=1; j<=Math.min(one,limit); j++){
            dp[0][j][1]=1;
        }

        for(int i=1; i<=zero; i++){
            for(int j=1; j<=one; j++){
                
                dp[i][j][0]=(dp[i-1][j][0] + dp[i-1][j][1]) % mod;

                if(i-limit-1>=0){
                    dp[i][j][0] = (dp[i][j][0] - dp[i-limit-1][j][1] + mod) % mod;
                }

                dp[i][j][1]=(dp[i][j-1][0] + dp[i][j-1][1]) % mod;

                if(j-limit-1>=0){
                    dp[i][j][1] = (dp[i][j][1] - dp[i][j-limit-1][0] + mod) % mod;
                }
            }
        }

        long ans=(dp[zero][one][0] + dp[zero][one][1]) % mod;
        return (int)ans;
    }


    // public int numberOfStableArrays(int zero, int one, int limit) {
    //     Long[][][][] dp=new Long[zero+1][one+1][2][limit+1];

    //     long ans=0;

    //     if(zero>0){
    //         ans+=dfs(zero-1,one,0,1,limit,dp);
    //     }

    //     if(one>0){
    //         ans+=dfs(zero,one-1,1,1,limit,dp);
    //     }

    //     return (int)ans%1_000_000_007;
    // }

    // private long dfs(int zero, int one, int last, int count, int limit, Long[][][][] dp){
    //     if(zero==0 && one==0){
    //         return 1;
    //     }

    //     if(dp[zero][one][last][count]!=null){
    //         return dp[zero][one][last][count];
    //     }

    //     long ans=0;

    //     if(zero>0){
    //         if(last==0){
    //             if(count<limit){
    //                 ans+=dfs(zero-1,one,0,count+1,limit,dp);
    //             }
    //         }
    //         else{
    //             ans+=dfs(zero-1,one,0,1,limit,dp);
    //         }
    //     }

    //     if(one>0){
    //         if(last==1){
    //             if(count<limit){
    //                 ans+=dfs(zero,one-1,1,count+1,limit,dp);
    //             }
    //         }
    //         else{
    //             ans+=dfs(zero,one-1,1,1,limit,dp);
    //         }
    //     }
    //     return dp[zero][one][last][count]=ans%1_000_000_007;
    // }
}