class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m=grid.length;
        int n=grid[0].length;

        int total=n*m;
        k=k%total;

        int[][] ans=new int[m][n];
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                int idx=i*n+j;
                int newidx=(idx+k)%total;

                int r=newidx/n;
                int c=newidx%n;

                ans[r][c]=grid[i][j];
            }
        }

        List<List<Integer>> res=new ArrayList<>();
        for(int i=0; i<m; i++){
            List<Integer> ll=new ArrayList<>();
            for(int j=0; j<n; j++){
                ll.add(ans[i][j]);
            }
            res.add(ll);
        }

        return res;
    }
}