class Solution {
    public int largestAltitude(int[] gain) {
        int ans=0;
        int curr=0;
        for(int i=0; i<gain.length; i++){
            int t=curr+gain[i];
            ans=Math.max(ans,t);
            curr=t;
        }
        return ans;
    }
}