/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return solve(root, p, q);
    }

    public TreeNode solve(TreeNode root, TreeNode p, TreeNode q){
        if(root==null){
            return null;
        }

        int cur=root.val;
        if(cur<p.val && cur<q.val){
            return solve(root.right, p, q);
        }
        if(cur>p.val && cur>q.val){
            return solve(root.left, p, q);
        }

        return root;
        
    }
}