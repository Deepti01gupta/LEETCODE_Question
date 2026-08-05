class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {

        Map<Integer, List<Integer>> map=new HashMap<>();
        
        for(int i=0; i<n; i++){
            map.put(i,new ArrayList<>());
        }

        for(int[] e:invocations){
            map.get(e[0]).add(e[1]);    
        }

        boolean[] vis=new boolean[n];
        Queue<Integer> q=new LinkedList<>();
        q.add(k);
        vis[k]=true;

        while(!q.isEmpty()){
            int cur=q.poll();

            for(int nb:map.get(cur)){
                if(!vis[nb]){
                    q.add(nb);
                    vis[nb]=true;
                }
            }
        }

        for(int i=0; i<n; i++){
            if(vis[i]!=true){
            
                for(int nb:map.get(i)){
                    if(vis[nb]){

                        List<Integer> ans=new ArrayList<>();
                        for(int j=0; j<n; j++){
                            ans.add(j);
                        }
                        return ans;
                    }
                }
            }
        }

        List<Integer> ans=new ArrayList<>();
        for(int i=0; i<n; i++){
            if(!vis[i]){
                ans.add(i);
            }
        }

        return ans;
    }
}