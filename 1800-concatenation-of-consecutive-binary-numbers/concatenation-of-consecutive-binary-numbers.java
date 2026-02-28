class Solution {
    public int concatenatedBinary(int n) {
        long ans=0;
        int mod=1_000_000_007;

        for(int i=1; i<=n; i++){
            int bit=Integer.toBinaryString(i).length();
            ans=((ans<<bit)+i)%mod;
        }

        return (int)ans%mod;
    }
}