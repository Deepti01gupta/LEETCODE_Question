

// This problem has two main observations:
// Even index → 5 choices
// Odd index  → 4 choices
// Therefore: answer = 5^((n+1)/2) × 4^(n/2)
    
    class Solution {

    static final int mod=1_000_000_007;

    public int countGoodNumbers(long n) {
        long c=n%2;

        long even=cal(5, n/2+c);
        long odd=cal(4, n/2);

        return (int)((even*odd)%mod);
    }

    public long cal(long x, long n){
        long ans=1;

        while(n>0){
            if(n%2==1){
                ans=(ans*x)%mod;
                n=n-1;
            }
            else{
                x=(x*x)%mod;
                n=n/2;
            }
        }

        return ans;
    }
}