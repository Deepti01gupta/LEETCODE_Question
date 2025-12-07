class Solution {
    // public int countOdds(int low, int high) {
    //     int c=0;
    //     for(int i=low; i<=high; i++){
    //         if(i%2==1) c++;
    //     }
    //     return c;
    // }

    public int countOdds(int low, int high) {
        int c1=(high+1)/2;
        int c2=low/2;
        return c1-c2;
    }
}