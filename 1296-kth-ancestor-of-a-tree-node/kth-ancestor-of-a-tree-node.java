class TreeAncestor {

    int[][] dp;
    int log;

    public TreeAncestor(int n, int[] parent) {
        log=0;
        while((1<<log)<=n){
            log++;
        }

        dp=new int[n][log];

        for(int i=0; i<n; i++){
            dp[i][0]=parent[i];
        }

        for(int j=1; j<log; j++){
            for(int i=0; i<n; i++){
                int mid=dp[i][j-1];
                if(mid!=-1){
                    dp[i][j]=dp[mid][j-1];
                }
                else{
                    dp[i][j]=-1;
                }
            }
        }
    }
    
    public int getKthAncestor(int node, int k) {
        for(int j=0; j<log; j++){
            if(((k>>j) & 1) == 1){
                node=dp[node][j];
                if(node==-1){
                    return -1;
                }
            }
        }
        return node;
    }
}

/**
 * Your TreeAncestor object will be instantiated and called as such:
 * TreeAncestor obj = new TreeAncestor(n, parent);
 * int param_1 = obj.getKthAncestor(node,k);
 */