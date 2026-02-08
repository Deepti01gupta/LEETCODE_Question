class Solution {
    public int countSquares(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        
        int[][] arr=new int[m][n]; 
        for(int i=0; i<m; i++){
            arr[i][0]=matrix[i][0];
        }
        for(int j=0; j<n; j++){
            arr[0][j]=matrix[0][j];
        }
        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                if(matrix[i][j]==0){
                    arr[i][j]=0;
                }
                else{
                    int v=Math.min(arr[i-1][j],Math.min(arr[i-1][j-1],arr[i][j-1]));
                    arr[i][j]=v+1;
                }
            }
        }

        int sum=0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                sum+=arr[i][j];
            }
        }

        return sum;
    }
}