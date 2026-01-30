class Solution {
    public int timeRequiredToBuy(int[] arr, int k) {
        Queue<Integer> q=new LinkedList<>();
		for(int i=0; i<arr.length; i++) {
			q.add(i);
		}
		
		int c=0;
		while(!q.isEmpty()) {
			int idx=q.poll();
			c++;
			arr[idx]--;
			if(arr[idx]==0 && idx==k) {
				return c;
			}
			if(arr[idx]!=0) {
				q.add(idx);
			}
		}
		
		return c;
    }
}