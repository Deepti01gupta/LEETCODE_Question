class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> graph=new ArrayList<>();

        for(int i=0; i<n; i++){
            graph.add(new ArrayList<>());
        }

        for(int[] i:edges){
            graph.get(i[0]).add(i[1]);
            graph.get(i[1]).add(i[0]);
        }

        int[] vis=new int[n];
        int ans=0;
        for(int i=0; i<n; i++){
            if(vis[i]==0){
                ans+=bfs(i,vis,graph);
            }
        }
        return ans;
    }

    private int bfs(int i, int[] vis, ArrayList<ArrayList<Integer>> graph){

        Queue<Integer> q=new LinkedList<>();
        q.add(i);
        int m=0;
        int e=0;
        vis[i]=1;

        while(!q.isEmpty()){
            int rp=q.poll();
            m++;

            for(int nb:graph.get(rp)){
                if(vis[nb]==0){
                    q.add(nb);
                    vis[nb]=1;
                }
                e++;
            }

        }

        if((m*(m-1)/2)==(e/2)){
            return 1;
        }
        return 0;
    }
}