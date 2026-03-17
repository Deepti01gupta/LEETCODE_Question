class Solution {
    public int largestSubmatrix(int[][] matrix) {

        int n=matrix.length;
        int m=matrix[0].length;

        int[] col=new int[m];
        int ans=0;

        for(int i=0; i<n; i++){

            for(int j=0; j<m; j++){
                if(matrix[i][j]==1)
                    col[j]+=1;
                else
                    col[j]=0;
            }

            int[] arr = col.clone();
            Arrays.sort(arr);

            for(int j=m-1; j>=0; j--){
                int h=arr[j];
                int w=m-j;
                ans=Math.max(ans, h*w);
            }
        }

        return ans;
    }
}