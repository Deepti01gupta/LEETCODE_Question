class Solution {
    public int snakesAndLadders(int[][] board) {
        return solve(board);
    }

    public int solve(int[][] board){
        int n=board.length;
        Queue<Integer> q=new LinkedList<>();
        q.add(1);
        int ans=0;

        boolean[] vis=new boolean[n*n+1];
        vis[1]=true;

        while(!q.isEmpty()){
            int size=q.size();
            
            for(int i=0; i<size; i++){
                int cur=q.poll();

                if(cur==n*n){
                    return ans;
                }

                for(int dice=1; dice<=6; dice++){
                    int next=cur+dice;

                    if(next>n*n){
                        break;
                    }

                    int[] pos=get(next,n);
                    int r=pos[0];
                    int c=pos[1];

                    if(board[r][c]!=-1){
                        next=board[r][c];
                    }

                    if(!vis[next]){
                        vis[next]=true;
                        q.offer(next);
                    }
                }
            }

            ans++;
        }

        return -1;
    }

    private int[] get(int num, int n){
        int r=(num-1)/n;
        int c=(num-1)%n;

        int row=n-1-r;

        int col;
        if(r%2==0){
            col=c;
        }
        else{
            col=n-1-c;
        }

        return new int[]{row,col};
    }
}