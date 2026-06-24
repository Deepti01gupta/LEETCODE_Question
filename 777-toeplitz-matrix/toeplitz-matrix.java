class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;

        for(int x=0; x<m; x++){
            int v=matrix[0][x];
            int i=0;
            int j=x;
            while(i+1<n && j+1<m){
                if(matrix[i+1][j+1]!=v){
                    return false;
                }
                i++;
                j++;
            }
        }

        for(int x=1; x<n; x++){
            int v=matrix[x][0];
            int j=0;
            int i=x;
            while(i+1<n && j+1<m){
                if(matrix[i+1][j+1]!=v){
                    return false;
                }
                i++;
                j++;
            }
        }

        return true;
    }
}