class Solution {
    public int[] sumZero(int n) {
        int[] ans=new int[n];
        if(n%2==0){
            int k=1;
            int i=0;
            int j=n-1;
            while(i<j){
                ans[i]=k;
                ans[j]=-k;
                i++;
                j--;
                k++;
            }
        }
        else{
            int k=1;
            int i=1;
            int j=n-1;
            ans[0]=0;
            while(i<j){
                ans[i]=k;
                ans[j]=-k;
                i++;
                j--;
                k++;
            }
        }
        return ans;
    }
}