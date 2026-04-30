class Solution {
    public int equalPairs(int[][] grid) {
        int ans=0;
        int n=grid.length;
        int m=grid[0].length;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                boolean flag=true;

                for(int k=0; k<n; k++){
                    if(grid[i][k]!=grid[k][j]){
                        flag=false;
                        break;
                    }
                }

                if(flag){
                    ans++;
                }
            }
        }

        return ans;
    }
}