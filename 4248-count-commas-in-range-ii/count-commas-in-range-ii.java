class Solution {
    public long countCommas(long n) {
        if(n<1000){
            return 0;
        }

        long ans=0;

        long start=1000;
        int commas=1;

        while(start <= n){
            long end=Math.min(n, start*1000 - 1);

            ans+=(end-start+1)*commas;

            start*=1000;
            commas++;
        }

        return ans;
    }
}