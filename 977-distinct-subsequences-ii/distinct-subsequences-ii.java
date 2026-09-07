class Solution {
    static final int mod=1_000_000_007;
    int[] dp;
    String s;

    public int distinctSubseqII(String s) {
        this.s=s;
        int n=s.length();

        dp=new int[n];
        Arrays.fill(dp, -1);

        return (solve(n-1) - 1 + mod) % mod;
    }

    private int solve(int idx){
        if(idx<0){
            return 1;
        }
        if(dp[idx]!=-1){
            return dp[idx];
        }

        int ch=s.charAt(idx)-'a';

        long ans=(2L * solve(idx-1)) % mod;

        int prev=-1;

        for(int i=idx-1; i>=0; i--){
            if(s.charAt(i)-'a'==ch){
                prev=i;
                break;
            }
        }

        if(prev!=-1){
            ans=(ans - solve(prev-1) + mod) % mod;
        }

        return dp[idx]=(int)ans;
    }
}