class Solution {
    public int mirrorDistance(int n) {
        int rev=reverse(n);
        int ans=Math.abs(rev-n);
        return ans;
    }

    public int reverse(int n){
        int rev=0;
        while(n>0){
            int r=n%10;
            rev=rev*10+r;
            n=n/10;
        }

        return rev;
    }
}