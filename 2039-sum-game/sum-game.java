class Solution {
    public boolean sumGame(String num) {
        int left=0;
        int a=0;
        int right=0;
        int b=0;
        for(int i=0; i<num.length()/2; i++){
            if(num.charAt(i)=='?') a++;
            else{
                left+=(num.charAt(i)-'0');
            }
        }

        for(int i=num.length()/2; i<num.length(); i++){
            if(num.charAt(i)=='?') b++;
            else{
                right+=(num.charAt(i)-'0');
            }
        }

        return 2 * (left - right) + 9 * (a - b) != 0;

    }
}