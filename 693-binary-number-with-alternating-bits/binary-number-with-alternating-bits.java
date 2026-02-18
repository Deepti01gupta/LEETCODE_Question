class Solution {
    public boolean hasAlternatingBits(int n) {
        int flag=n&1;
        n=n>>1;
        while(n!=0){
            int r=n&1;
            if(r==flag){
                return false;
            }
            flag=r;
            n=n>>1;
        }
        return true;

    }
}