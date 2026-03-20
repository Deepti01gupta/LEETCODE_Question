class Solution {
    public int[][] minAbsDiff(int[][] grid, int k) {
        int m=grid.length, n=grid[0].length;
        int[][] res=new int[m-k+1][n-k+1];

        for(int i=0; i<=m-k; i++){
            for(int j=0; j<=n-k; j++){
                TreeSet<Integer> set=new TreeSet<>();

                for(int a=i; a<i+k; a++){
                    for(int b=j; b<j+k; b++){
                        set.add(grid[a][b]);
                    }
                }

                Integer pre=null;
                int mindif=Integer.MAX_VALUE;


                for(int v : set){
                    if(pre != null){
                        mindif = Math.min(mindif, v-pre);
                    }
                    pre=v;
                }
                res[i][j] = (mindif == Integer.MAX_VALUE)? 0:mindif;
            }
        }
        return res;
    }
}