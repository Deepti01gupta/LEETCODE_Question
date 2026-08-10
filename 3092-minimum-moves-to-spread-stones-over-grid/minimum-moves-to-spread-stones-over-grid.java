class Solution {

    int ans=Integer.MAX_VALUE;

    public int minimumMoves(int[][] grid) {

        List<int[]> empty=new ArrayList<>();
        List<int[]> extra=new ArrayList<>();

        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(grid[i][j]==0){
                    empty.add(new int[]{i,j});
                }

                if(grid[i][j]>1){
                    for(int k=1; k<grid[i][j]; k++){
                        extra.add(new int[]{i,j});
                    }
                }
            }
        }

        boolean[] used=new boolean[empty.size()];

        solve(0,empty,extra,used,0);

        return ans;
    }

    private void solve(int idx, List<int[]> empty, List<int[]> extra, boolean[] used, int cost){

        if(idx==extra.size()){
            ans=Math.min(ans,cost);
            return;
        }

        for(int i=0; i<empty.size(); i++){

            if(used[i]){
                continue;
            }

            int[] stone=extra.get(idx);
            int[] cell=empty.get(i);

            int dis=Math.abs(stone[0]-cell[0]) + Math.abs(stone[1]-cell[1]);

            used[i]=true;

            solve(idx+1, empty, extra, used, cost+dis);

            used[i]=false;
        }
    }
}