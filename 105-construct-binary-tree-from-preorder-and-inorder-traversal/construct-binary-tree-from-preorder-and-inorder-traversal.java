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

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return solve(preorder, inorder, 0, inorder.length-1, 0, preorder.length-1);
    }

    public TreeNode solve(int[] pre, int[] in, int ilo, int ihi, int plo, int phi){
        if(ilo>ihi || plo>phi){
            return null;
        }

        TreeNode node=new TreeNode(pre[plo]);
        int idx=find(in, ilo, ihi, pre[plo]);
        int c=idx-ilo;

        node.left=solve(pre, in, ilo, idx-1, plo+1, plo+c);
        node.right=solve(pre, in, idx+1, ihi, plo+c+1, phi);

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