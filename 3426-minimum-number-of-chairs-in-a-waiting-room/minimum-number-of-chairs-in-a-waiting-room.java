class Solution {
    public int minimumChairs(String s) {
        int ans=0;
        int c=0;

        for(char ch:s.toCharArray()){
            if(ch=='E'){
                c++;
                ans=Math.max(ans,c);
            }
            else{
                c--;
            }
        }

        return ans;
    }
}