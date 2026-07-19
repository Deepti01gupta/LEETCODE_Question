class Solution {
    public int findChampion(int[][] grid) {
        int n=grid.length;

        for(int col=0; col<n; col++){

            boolean defeated=false;

            for(int row=0; row<n; row++){

                if(grid[row][col]==1){
                    defeated=true;
                    break;
                }
            }

            if(!defeated) return col;
        }

        return -1;
    }
}