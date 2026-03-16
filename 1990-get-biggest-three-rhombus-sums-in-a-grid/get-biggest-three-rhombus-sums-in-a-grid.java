class Solution {
    public int[] getBiggestThree(int[][] grid) {
        TreeSet<Integer> set=new TreeSet<>((a,b)->b-a);
        int n=grid.length;
        int m=grid[0].length;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){

                set.add(grid[i][j]);

                for(int k=1; i-k>=0 && i+k<n && j-k>=0 && j+k<m; k++){
                    int sum = 0;
                    int x=i-k, y=j;

                    // top → right
                    for(int d=0; d<k; d++){
                        sum+=grid[x+d][y+d];
                    }

                    // right → bottom
                    x=i; y=j+k;
                    for(int d=0; d<k; d++){
                        sum+=grid[x+d][y-d];
                    }

                    // bottom → left
                    x=i+k; y=j;
                    for(int d=0; d<k; d++){
                        sum+=grid[x-d][y-d];
                    }

                    // left → top
                    x=i; y=j-k;
                    for(int d=0; d<k; d++){
                        sum+=grid[x-d][y+d];
                    }

                    set.add(sum);
                }
            }
        }

        int size = Math.min(3, set.size());
        int[] ans = new int[size];

        int k = 0;
        for(int val : set){
            if(k == size) break;
            ans[k++] = val;
        }
        return ans;
    }
}