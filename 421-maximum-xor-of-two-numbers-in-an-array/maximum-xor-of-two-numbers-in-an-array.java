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


    public int findMaximumXOR(int[] nums) {
        // int ans=0;
        // for(int i=0; i<nums.length; i++){
        //     for(int j=i+1; j<nums.length; j++){
        //         ans=Math.max(ans,nums[i]^nums[j]);
        //     }
        // }
        // return ans;

        Trie t=new Trie();
		for(int x:nums) {
			t.add(x);
		}
		
		int ans=0;
		for(int x:nums) {
			ans=Math.max(ans, t.getMaxXor(x));
		}

        return ans;
    }
}