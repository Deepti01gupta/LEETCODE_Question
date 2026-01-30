class Solution {
    public int findTheWinner(int n, int k) {
        Queue<Integer> q=new LinkedList<>();
		for(int i=1; i<=n; i++) {
			q.add(i);
		}
		int c=0;
		while(q.size()>1) {
			int v=q.poll();
			c++;
			if(c==k) {
				c=0;
				continue;
			}
			
			q.add(v);
		}
		
		return q.peek();
    }
}