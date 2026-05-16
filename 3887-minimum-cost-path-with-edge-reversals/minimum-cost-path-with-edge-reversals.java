class Solution {
    public int minCost(int n, int[][] edges) {
        Map<Integer, List<int[]>> map=new HashMap<>();
        
        for(int i=0; i<n; i++){
            map.put(i,new ArrayList<>());
        }

        for(int[] e:edges){
            int u=e[0];
            int v=e[1];
            int w=e[2];

            map.get(u).add(new int[]{v,w});
            map.get(v).add(new int[]{u,2*w});
        }

        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)-> a[1]-b[1]);

        int[] dis=new int[n];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[0]=0;
        pq.add(new int[]{0,0});

        while(!pq.isEmpty()){
            int[] cur=pq.poll();

            if(cur[0]==n-1){
                return cur[1];
            }

            if(cur[1]>dis[cur[0]]){
                continue;
            }

            for(int[] nb:map.get(cur[0])){

                if(cur[1]+nb[1] < dis[nb[0]]){
                    dis[nb[0]]=cur[1]+nb[1];

                    pq.add(new int[]{nb[0],dis[nb[0]]});
                }
            }
        }

        return -1;

    }
}