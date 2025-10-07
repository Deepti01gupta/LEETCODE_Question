class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean vis[]=new boolean[rooms.size()];
        Queue<Integer> q=new LinkedList<>();

        q.add(0);
        vis[0]=true;

        while(!q.isEmpty()){
            int nn=q.poll();
            for(int i=0; i<rooms.get(nn).size(); i++){
                if(!vis[rooms.get(nn).get(i)]){
                    q.add(rooms.get(nn).get(i));
                    vis[rooms.get(nn).get(i)]=true;
                }
            }
        }
        for(int i=0; i<vis.length; i++){
            if(vis[i]==false){
                return false;
            }
        }
        return true;
    }
}