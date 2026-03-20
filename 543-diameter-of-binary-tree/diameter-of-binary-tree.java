/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
// class Solution {

//     // O(N^2)
//     public int diameterOfBinaryTree(TreeNode root) {
//         if(root == null){
//             return 0;
//         }
//         int ld=diameterOfBinaryTree(root.left);
//         int rd=diameterOfBinaryTree(root.right);
//         int sd=height(root.left) + height(root.right) +2;
//         return Math.max(sd,Math.max(rd,ld));
//     }

//     public int height(TreeNode root){
//         if(root==null){
//             return -1;
//         }
//         int lh=height(root.left);
//         int rh=height(root.right);
//         return Math.max(lh,rh)+1;
//     }
// }
public class DiaPair {
		int d = 0;
		int ht = -1;

}

class Solution {

    int ans=0;

	public int diameterOfBinaryTree(TreeNode root) {
		// return diameter(root).d;

        solve(root);
        return ans;
	}

    private int solve(TreeNode root){
        if(root==null){
            return 0;
        }

        int lh=solve(root.left);
        int rh=solve(root.right);

        ans=Math.max(ans,lh+rh);
        return Math.max(lh,rh)+1;
    }

	public DiaPair diameter(TreeNode root) {
		if (root == null) {
			return new DiaPair();
		}

		DiaPair ldp = diameter(root.left);
		DiaPair rdp = diameter(root.right);
		DiaPair sdp = new DiaPair();

		sdp.ht = Math.max(ldp.ht, rdp.ht) + 1;
		int dia = ldp.ht + rdp.ht + 2;
		sdp.d = Math.max(dia, Math.max(ldp.d, rdp.d));

		return sdp;
	}
}