class Solution {
    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[][] vis=new int[n][m];
        int ans=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j]=='1' && vis[i][j]!=1){
                    ans++;
                    dfs(i,j,grid,vis);
                }
            }
        }
        return ans;
    }
    public void dfs(int i, int j, char[][] grid, int[][] vis){
        Stack<int[]> st=new Stack<>();
        st.add(new int[]{i,j});
        vis[i][j]=1;
        int[] row={1,-1,0,0};
        int[] col={0,0,1,-1};
        while(!st.isEmpty()){
            int[] rp=st.pop();
            for(int idx=0; idx<4; idx++){
                int nr=rp[0]+row[idx];
                int nc=rp[1]+col[idx];
                if(nr>=0 && nr<grid.length && nc>=0 && nc<grid[0].length && grid[nr][nc]=='1' && vis[nr][nc]!=1){
                    st.push(new int[]{nr,nc});
                    vis[nr][nc]=1;
                }
            }
        }
    }
}