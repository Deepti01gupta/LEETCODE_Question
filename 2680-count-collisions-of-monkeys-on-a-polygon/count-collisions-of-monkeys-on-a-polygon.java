class Solution {
    static final long mod=1_000_000_007;

    public int monkeyMove(int n) {
        long total= modPow(2,n,mod);
        long res=(total-2+mod)%mod;
        return (int)res;    
    }

    private long modPow(long base, long exp, long mod){
        long res=1;
        while(exp>0){
            if((exp & 1)==1){
                res=(res*base)%mod;
            }
            base=(base*base)%mod;
            exp>>=1;
        }

        return res;
    }
}