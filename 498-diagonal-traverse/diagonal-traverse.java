class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        if (mat == null || mat.length == 0) return new int[0];
        
        int m = mat.length, n = mat[0].length;
        int[] result = new int[m * n];
        int row = 0, col = 0;
        boolean up = true;
        
        for (int i = 0; i < m * n; i++) {
            result[i] = mat[row][col];
            
            if (up) { // moving up-right
                if (col == n - 1) { // hit right wall
                    row++;
                    up = false;
                } else if (row == 0) { // hit top wall
                    col++;
                    up = false;
                } else {
                    row--;
                    col++;
                }
            } else { // moving down-left
                if (row == m - 1) { // hit bottom wall
                    col++;
                    up = true;
                } else if (col == 0) { // hit left wall
                    row++;
                    up = true;
                } else {
                    row++;
                    col--;
                }
            }
        }
        
        return result;
    }
}
