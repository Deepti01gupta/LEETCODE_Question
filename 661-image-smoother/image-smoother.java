class Solution {
    public int[][] imageSmoother(int[][] img) {
        int n=img.length;
        int m=img[0].length;

        int[][] ans=new int[n][m];

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                int[] v=find(img,i,j,n,m);
                ans[i][j]=(int)Math.floor(v[0]/v[1]);

            }
        }

        return ans;

    }

    public int[] find(int[][] arr, int r, int c, int n, int m){
        int sum=0;
        int count=0;

        sum+=arr[r][c];
        count++;

        if(r-1>=0 && c-1>=0){
            sum+=arr[r-1][c-1];
            count++;
        }

        if(r-1>=0){
            sum+=arr[r-1][c];
            count++;
        }

        if(r-1>=0 && c+1<m){
            sum+=arr[r-1][c+1];
            count++;
        }

        if(c+1<m){
            sum+=arr[r][c+1];
            count++;
        }

        if(r+1<n && c+1<m){
            sum+=arr[r+1][c+1];
            count++;
        }

        if(r+1<n){
            sum+=arr[r+1][c];
            count++;
        }

        if(r+1<n && c-1>=0){
            sum+=arr[r+1][c-1];
            count++;
        }

        if(c-1>=0){
            sum+=arr[r][c-1];
            count++;
        }

        return new int[]{sum,count};
    }
}