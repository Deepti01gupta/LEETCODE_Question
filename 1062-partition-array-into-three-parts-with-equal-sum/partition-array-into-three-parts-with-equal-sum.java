class Solution {
    public boolean canThreePartsEqualSum(int[] arr) {
        int total=0;
        for(int i:arr) total+=i;

        int t=total/3;
        if(total%3!=0) return false;

        int c=0;
        int sum=0;
        for(int i:arr){
            sum+=i;
            if(sum==t){
                sum=0;
                c++;
            }
        }

        return c>=3;
    }
}