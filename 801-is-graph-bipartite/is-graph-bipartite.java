class Solution {
    public boolean isBipartite(int[][] graph) {
        int V=graph.length;
        int[] color=new int[V];
        Arrays.fill(color, -1);
        for(int i=0; i<V; i++){
            if(color[i]==-1){
                if(dfs(i, 1, color, graph)==false){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean dfs(int idx, int col, int[] color, int[][] graph){
        color[idx]=col;
        for(int i:graph[idx]){
            if(color[i]==-1){
                if(dfs(i, 1-col, color, graph)==false){
                    return false;
                }
            }
            else if(color[i]==col){
                return false;
            }
        }
        return true;
    }
}