class Solution {
    public void gameOfLife(int[][] board) {
        int n=board.length;
        int m=board[0].length;

        int[] row={-1,-1,-1,0,0,1,1,1};
        int[] col={-1,0,1,-1,1,-1,0,1};

        int[][] ans=new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                int count=0;
                for(int k=0; k<8; k++){
                    if(row[k]+i>=0 && row[k]+i<n && col[k]+j>=0 && col[k]+j<m && board[row[k]+i][col[k]+j]==1){
                        count++;
                    }
                }

                if(board[i][j]==1){
                    if(count<2 || count>3){
                        ans[i][j]=0;
                    }
                    else{
                        ans[i][j]=1;
                    }
                }
                else{
                    if(count==3){
                        ans[i][j]=1;
                    }
                }
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                board[i][j]=ans[i][j];
            }
        }
    }
}