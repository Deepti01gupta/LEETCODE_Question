class Solution {
    public boolean uniformArray(int[] nums1) {
        int even=Integer.MAX_VALUE;
        int odd=Integer.MAX_VALUE;

        for(int i:nums1){
            if(i%2==0){
                even=Math.min(even, i);
            }
            else{
                odd=Math.min(odd, i);
            }
        }

        boolean makeEven=true;

        for(int i:nums1){
            if(i%2!=0){

                if(odd==Integer.MAX_VALUE || odd>=i){
                    makeEven=false;
                    break;
                }
            }
        }

        if(makeEven){
            return true;
        }

        boolean makeOdd=true;

        for(int i:nums1){
            if(i%2==0){
                if(odd==Integer.MAX_VALUE || odd>=i){
                    makeOdd=false;
                    break;
                }
            }
        }

        return makeOdd;
    }
}