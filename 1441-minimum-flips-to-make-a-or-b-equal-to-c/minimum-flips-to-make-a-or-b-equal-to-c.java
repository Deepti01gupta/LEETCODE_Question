class Solution {
    public int minFlips(int a, int b, int c) {
        int flip=0;

        while(a>0 || b>0 || c>0){
            int aa=a&1;
            int bb=b&1;
            int cc=c&1;

            if(cc==1){
                if(aa==0 && bb==0){
                    flip++;
                }
            }
            else{
                flip+=aa+bb;
            }

            a>>=1;
            b>>=1;
            c>>=1;
        }

        return flip;
    }
}