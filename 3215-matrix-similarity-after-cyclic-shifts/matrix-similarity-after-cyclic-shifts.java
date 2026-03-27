class Solution {
    public boolean areSimilar(int[][] mat, int k) {
        int n=mat.length;
        int m=mat[0].length;
        k=k%m;

        for(int i=0; i<n; i++){
            int[] arr=new int[m];

            if(i%2==0){
                for(int j=0; j<m; j++){
                    arr[j]=mat[i][(j+k)%m];
                }
            }
            else{
                for(int j=0; j<m; j++){
                    arr[j]=mat[i][(j-k+m)%m];
                }
            }

            if(!check(arr,i,mat)){
                return false;
            }
        }

        return true;
    }

    private boolean check(int[] arr, int idx, int[][] mat){

        for(int i=0; i<mat[0].length; i++){
            if(arr[i]!=mat[idx][i]){
                return false;
            }
        }

        return true;
    }
}