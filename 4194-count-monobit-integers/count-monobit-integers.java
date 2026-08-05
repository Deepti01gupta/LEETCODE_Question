class Solution {
    public int countMonobit(int n) {
        int ans=1;

        for(int i=1; i<=n; i++){
            if(find(i)){
                ans++;
            }
        }

        return ans;
    }

    public boolean find(int n){
        int prev=n%2;

        n=n/2;
        while(n>0){
            int r=n%2;
            
            if(r!=prev){
                return false;
            }

            n=n/2;
        }

        return true;
    }
}