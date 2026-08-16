class Solution {

    // SOLUTION 1   
    public boolean stoneGameIX(int[] stones) {
        int c0=0, c1=0, c2=0;

        for(int i:stones){
            int v=i%3;

            if(v==0) c0++;
            if(v==1) c1++;
            if(v==2) c2++;
        }

        if(c1==0 && c2==0){
            return false;
        }
        if(c0%2==0){
            return c1>0 && c2>0;
        }
        return Math.abs(c1-c2)>2;
    }
}