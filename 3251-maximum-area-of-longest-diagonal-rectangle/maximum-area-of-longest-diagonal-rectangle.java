class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        double max=Integer.MIN_VALUE;
        int ans=0;
        for(int i=0; i<dimensions.length; i++){
            int a=dimensions[i][0];
            int b=dimensions[i][1];
            
            int diagSq=a*a + b*b;
            int area=a*b;
            if(diagSq>max || (diagSq==max && area>ans)){
                max=diagSq;
                ans=area;
            }
        }
        return ans;
    }
}