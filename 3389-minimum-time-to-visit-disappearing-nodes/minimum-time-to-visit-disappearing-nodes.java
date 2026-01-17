class Solution {
    List<List<int[]>> map;
    public int[] minimumTime(int n, int[][] edges, int[] disappear) {
        map=new ArrayList<>();
        for(int i=0; i<n; i++){
            map.add(i, new ArrayList<>());
        }

        for(int e[]:edges){
            map.get(e[0]).add(new int[]{e[1],e[2]});
            map.get(e[1]).add(new int[]{e[0],e[2]});
        }

        return dijkastra(n,disappear);
    }

    class pair{
        int vtx;
        int time;
        pair(int vtx, int time){
            this.vtx=vtx;
            this.time=time;
        }
    }

    private int[] dijkastra(int n, int[] disappear){
        
        PriorityQueue<pair> pq=new PriorityQueue<>((a,b)-> a.time-b.time);

        pq.add(new pair(0,0));
        int[] dis=new int[n];
        Arrays.fill(dis,Integer.MAX_VALUE);
        dis[0]=0;

        while(!pq.isEmpty()){
            pair rp=pq.poll();

            if(dis[rp.vtx]<rp.time){
                continue;
            }

            if(rp.time>=disappear[rp.vtx]){
                continue;
            }

            for(int[] nbrs:map.get(rp.vtx)){
                int nbr=nbrs[0];
                int t=nbrs[1];
                
                if(dis[nbr]>t+rp.time && t+rp.time<disappear[nbr]){
                    dis[nbr]=t+rp.time;
                    pq.add(new pair(nbr,dis[nbr]));
                }
            }
        }

        int[] ans=new int[n];

        for(int i=0; i<n; i++){
            if(dis[i]!=Integer.MAX_VALUE && dis[i]<disappear[i]){
                ans[i]=dis[i];
            }
            else{
                ans[i]=-1;
            }
        }
        return ans;
    }
}