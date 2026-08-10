class Solution {
public:
    bool isPalindrome(int x) {
        if(x<0) return false;

        int t=x;
        long rev=0;
        while(x>0){
            int r=x%10;
            rev=rev*10+r;
            x=x/10;
        }

        return (rev==t);
    }
};