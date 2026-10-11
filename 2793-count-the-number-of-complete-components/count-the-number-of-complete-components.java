class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        Map<Integer, List<Integer>> map=new HashMap<>();
        for(int i=0; i<n; i++){
            map.put(i, new ArrayList<>());
        }
        for(int[] ad:edges){
            int u=ad[0];
            int v=ad[1];
            map.get(v).add(u);
            map.get(u).add(v);
        }
        int[] vis=new int[n];
        Arrays.fill(vis, -1);
        int ans=0;
        for(int i=0; i<n; i++){
            if(vis[i]==-1){
                List<Integer> nodes=bfs(map, i, vis);
                int degreeSum=0;

                for(int node:nodes){
                    degreeSum+=map.get(node).size();
                }

                int size=nodes.size();
                if(degreeSum == size * (size-1)){
                    ans++;
                }
            }
        }
        return ans;
    }
    public List<Integer> bfs(Map<Integer, List<Integer>> map, int idx, int[] vis) {
        Queue<Integer> q=new LinkedList<>();
        List<Integer> nodes = new ArrayList<>();
        q.add(idx);
        vis[idx]=1;
        while(!q.isEmpty()){
            int rp=q.poll();
            nodes.add(rp);
            vis[rp]=1;
            for(int nb:map.get(rp)){
                if(vis[nb]==-1){
                    q.add(nb);
                    vis[nb]=1;
                }
            }
        }
        return nodes; 
    }
}