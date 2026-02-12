class Solution {

    static class Trie{
		class Node{
			Node zero;
			Node one;
			
		}
		
		private Node root=new Node();
		
		public void add(int val) {
			Node cur=root;
			
			for(int i=31; i>=0; i--) {
				int bit=val & (1<<i);
				if(bit==0) {
					if(cur.zero!=null) {
						cur=cur.zero;
					}
					else {
						Node nn=new Node();
						cur.zero=nn;
						cur=nn;
					}
				}
				else {
					if(cur.one!=null) {
						cur=cur.one;
					}
					else {
						Node nn=new Node();
						cur.one=nn;
						cur=nn;
					}
				}
			}
		}
		
		public int getMaxXor(int x) {
			int ans=0;
			Node cur=root;
			for(int i=31; i>=0; i--) {
				int bit=x & (1<<i);
				if(bit==0) {
					if(cur.one!=null) {
						ans=ans | (1<<i);
						cur=cur.one;
					}
					else {
						cur=cur.zero;
					}
				}
				else {
					if(cur.zero!=null) {
						ans=ans | (1<<i);
						cur=cur.zero;
					}
					else {
						cur=cur.one;
					}
				}
			}
			return ans;
		}
	}

    public int[] maximizeXor(int[] arr, int[][] queries) {

        int n=queries.length;
        int[][] q=new int[n][3];
	
		for(int i=0; i<n; i++) {
			q[i][0]=queries[i][0];
			q[i][1]=queries[i][1];
			q[i][2]=i;
		}
		
		Arrays.sort(q,(a,b)->a[1]-b[1]);
		Arrays.sort(arr);
		
		int[] ans=new int[n];
		Trie t=new Trie();
		int j=0;
		for(int[] a:q) {
			while(j<arr.length && arr[j]<=a[1]) {
				t.add(arr[j]);
				j++;
			}
			
			if(j==0) {
				ans[a[2]]=-1;
			}
			else {
				int v=t.getMaxXor(a[0]);
				ans[a[2]]=v;
			}
		}

        return ans;   
    }
}