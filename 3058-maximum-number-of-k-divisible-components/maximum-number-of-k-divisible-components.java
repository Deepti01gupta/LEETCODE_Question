class Solution {
    public static int count=0;

    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        HashMap<Integer, List<Integer>> map=new HashMap<>();
        for(int i=0; i<n; i++){
            map.put(i,new ArrayList<>());
        }

        for(int i=0; i<edges.length; i++){
            map.get(edges[i][0]).add(edges[i][1]);
            map.get(edges[i][1]).add(edges[i][0]);
        }

        count=0;
        dfs(0,-1, map, values,k);
        HashSet<Integer> vis=new HashSet<>();
        return count;
    }

    public int dfs(int curr, int parent, HashMap<Integer, List<Integer>> map, int[] values, int k){
        int sum=values[curr];
        for(int i:map.get(curr)){
            if(i!=parent){
                sum+=dfs(i,curr,map,values,k);
                sum%=k;
            }
        }
        sum%=k;
        if(sum==0){
            count++;
        }
        return sum;
    }
}