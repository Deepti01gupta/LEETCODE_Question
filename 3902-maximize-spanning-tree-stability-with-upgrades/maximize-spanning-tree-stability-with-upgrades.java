class Solution {

    class DSU{
        int[] parent, rank;

        DSU(int n){
            parent=new int[n];
            rank=new int[n];

            for(int i=0; i<n; i++){
                parent[i]=i;
            }
        }

        int find(int x){
            if(parent[x]!=x){
                parent[x]=find(parent[x]);
            }

            return parent[x];
        }

        boolean union(int a, int b){
            int pa=find(a);
            int pb=find(b);

            if(pa==pb){
                return false;
            }

            if(rank[pa]<rank[pb]){
                parent[pa]=pb;
            }
            else if(rank[pb]<rank[pa]){
                parent[pb]=pa;
            }
            else{
                parent[pb]=pa;
                rank[pa]++;
            }

            return true;
        }
    }

    public int maxStability(int n, int[][] edges, int k) {
        int max=0;

        for(int[] e:edges){
            max=Math.max(max, e[2]);
        }

        int left=1;
        int right=2*max;
        int ans=-1;

        while(left<=right){
            int mid=(left+right)/2;

            if(check(n,edges,k,mid)){
                ans=mid;
                left=mid+1;
            }
            else{
                right=mid-1;
            }
        }

        return ans;
    }

    boolean check(int n, int[][] edges, int k, int x){
        DSU dsu=new DSU(n);

        int upgrades=0;
        int used=0;

        List<int[]> normal=new ArrayList<>();
        List<int[]> upgrade=new ArrayList<>();


        for(int[] e:edges){
            int u=e[0];
            int v=e[1];
            int s=e[2];
            int must=e[3];

            if(must==1){
                if(s<x){
                    return false;
                }

                if(!dsu.union(u,v)){
                    return false;
                }

                used++;
            }
            else{
                if(s>=x){
                    normal.add(e);
                }
                else if(s*2>=x){
                    upgrade.add(e);
                }
            }
        }

        for(int[] e:normal){
            if(dsu.union(e[0],e[1])){
                used++;
            }
        }

        for(int[] e:upgrade){
            if(dsu.find(e[0]) == dsu.find(e[1])){
                continue;
            }

            upgrades++;

            if(upgrades>k){
                return false;
            }

            dsu.union(e[0],e[1]);
            used++;
        }

        return used==n-1;
    }
}