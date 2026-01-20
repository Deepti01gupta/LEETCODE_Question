class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        int n=mat.length;
        int m=mat[0].length;
        int[][] arr=new int[n+1][m+1];
        arr[0][0]=mat[0][0];

        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                arr[i][j]=arr[i][j-1] + arr[i-1][j] - arr[i-1][j-1] + mat[i-1][j-1];
            }
        }

        int low=0, high=Math.min(n,m);
        while(low<high){
            int mid=(low+high+1)/2;

            if(isPossible(arr,mid,threshold)){
                low=mid;
            }
            else{
                high=mid-1;
            }
        }

        return low;
    }

    private boolean isPossible(int[][] arr, int k, int threshold){

        for(int i=k; i<arr.length; i++){
            for(int j=k; j<arr[0].length; j++){
                int sum=arr[i][j] - arr[i-k][j] - arr[i][j-k] + arr[i-k][j-k];

                if(sum<=threshold){
                    return true;
                }
            }
        }

        return false;
    }
}