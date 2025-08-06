class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {

        for(int i=0; i<flowerbed.length && n>0; i++){
            if(flowerbed[i]==0){
                boolean left= (i==0) || flowerbed[i-1]==0;
                boolean right = (i==flowerbed.length-1) || flowerbed[i+1]==0;
                if(left && right){
                    flowerbed[i]=1;
                    n--;
                }
            }
        }
        if(n<=0){
            return true;
        }
        return false;



        // for(int i=0; i<flowerbed.length; ){
        //     if(flowerbed[i]==1){
        //         i+=2;
        //     }
        //     else{
        //         n--;
        //         if(n==0){
        //             return true;
        //         }
        //         i+=2;
        //     }
        // }
        // return false;
    }
}