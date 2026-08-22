class Solution {
    public boolean checkDivisibility(int n) {
        int sum=sum_of_digit(n)+pro_of_digit(n);
        return n%sum==0;
    }
    private int sum_of_digit(int n){
        int ans=0;
        while(n>0){
            int r=n%10;
            ans+=r;
            n=n/10;
        }
        return ans;
    }

    private int pro_of_digit(int n){
        int ans=1;
        while(n>0){
            int r=n%10;
            ans*=r;
            n=n/10;
        }
        return ans;
    }
}