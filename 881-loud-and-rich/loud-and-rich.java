class Solution {
    List<Integer>[] map;
    int[] ans;
    int[] quiet;

    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int n=quiet.length;
        this.quiet=quiet;

        map=new ArrayList[n];
        for(int i=0; i<n; i++){
            map[i]=new ArrayList<>();
        }    

        for(int[] e:richer){
            map[e[1]].add(e[0]);
        }

        ans=new int[n];
        Arrays.fill(ans,-1);

        for(int i=0; i<n; i++){
            dfs(i);
        }

        return ans;
    }

    private int dfs(int node){
        if(ans[node]!=-1){
            return ans[node];
        }

        ans[node]=node;

        for(int next:map[node]){
            int can=dfs(next);
            if(quiet[can]<quiet[ans[node]]){
                ans[node]=can;
            }
        }

        return ans[node];
    }
}