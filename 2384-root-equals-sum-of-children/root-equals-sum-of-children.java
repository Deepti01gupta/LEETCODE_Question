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
    public boolean checkTree(TreeNode root) {
        return fun(root);
    }

    public boolean fun(TreeNode root){
        if(root==null){
            return true;
        }
        if(root.left!=null && root.right!=null){
            if(root.val!=root.left.val+root.right.val){
                return false;
            }
        }
        boolean ans1=fun(root.left);
        boolean ans2=fun(root.right);   
        return ans1 && ans2;
    }
}