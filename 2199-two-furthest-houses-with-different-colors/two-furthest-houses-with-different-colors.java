class Solution {
    public int maxDistance(int[] colors) {
        int ans=0;
        int n=colors.length;

        for(int i=0; i<n; i++){
            for(int j=i; j<n; j++){
                if(i==j) continue;

                if(colors[i]!=colors[j]){
                    ans=Math.max(ans,j-i);
                }
            }
        }

        return ans;
    }
}