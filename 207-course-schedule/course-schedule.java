class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] adj=new ArrayList[numCourses];
        for(int i=0; i<numCourses; i++){
            adj[i]=new ArrayList<>();
        }
        int[] indegree=new int[numCourses];
        for(int[] i:prerequisites){
            int u=i[0];
            int v=i[1];
            indegree[v]++;
            adj[u].add(v);
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0; i<numCourses; i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        int count=0;
        while(!q.isEmpty()){
            int rp=q.poll();
            count++;
            for(int nb:adj[rp]){
                indegree[nb]--;
                if(indegree[nb]==0){
                    q.add(nb);
                }
            }
        }
        return count==numCourses;
    }
}