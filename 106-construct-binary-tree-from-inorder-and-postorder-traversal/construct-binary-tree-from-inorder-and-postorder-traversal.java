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
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return solve(inorder, postorder, 0, inorder.length-1, 0, postorder.length-1);
    }

    public TreeNode solve(int[] in, int[] post, int ilo, int ihi, int plo, int phi){
        if(ilo>ihi || plo>phi){
            return null;
        }

        TreeNode node=new TreeNode(post[phi]);
        int idx=find(in, ilo, ihi, post[phi]);
        int c=idx-ilo;

        node.left=solve(in, post, ilo, idx-1, plo, plo+c-1);
        node.right=solve(in, post, idx+1, ihi, plo+c, phi-1);

        return node;
    }

    public int find(int[] in, int i, int j, int val){
        for(int x=i; x<=j; x++){
            if(in[x]==val){
                return x;
            }
        }
        return -1;
    }
}