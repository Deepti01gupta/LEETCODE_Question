class Solution {
    static final int mod=1_000_000_007;
    static final long inv2=500000004L;

    public int minimumPossibleSum(int n, int target) {

        long k=Math.min((long)n,target/2L);
        long sum_left=k%mod * (k+1) % mod * inv2 % mod;

        long rem=n-k;
        long start=target;
        long end=target+rem-1;

        long sum_right=((end%mod) * ((end+1)%mod)%mod - ((start-1+mod)%mod) * (start%mod)%mod+mod)%mod * inv2%mod;

        return (int)((sum_left+sum_right)%mod);
    }

    // public int minimumPossibleSum(int n, int target) {

    //     Set<Integer> set=new HashSet<>();
    //     int idx=1;
    //     long sum=0;

    //     while(n>0){
    //         if(!set.contains(target-idx)){
    //             set.add(idx);
    //             sum=(sum+idx)%mod;
    //             n--;
    //         }
    //         idx++;
    //     }

    //     return (int)sum;
    // }
}
