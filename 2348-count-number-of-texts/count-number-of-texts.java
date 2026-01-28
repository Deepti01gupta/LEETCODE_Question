class Solution {
    static final int mod=1_000_000_007;
    String s;
    int n;
    Long[] dp;

    public int countTexts(String pressedKeys) {
        this.s=pressedKeys;
        this.n=s.length();
        dp=new Long[n+1];
        
        return (int) solve(0);
    }

    private long solve(int i){
        if(i==n){
            return 1;
        }
        if(dp[i]!=null){
            return dp[i];
        }

        char cur=s.charAt(i);
        int press=(cur=='7' || cur=='9')? 4:3;

        long ans=0;
        for(int len=1; len<=press && i+len<=n; len++){
            if(s.charAt(i+len-1) != cur){
                break;
            }
            ans=(ans+solve(i+len))%mod;
        }

        return dp[i]=ans;
    }
}