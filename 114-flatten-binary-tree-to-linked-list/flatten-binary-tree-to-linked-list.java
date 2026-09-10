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
    public void flatten(TreeNode root) {
        if(root==null){
            return ;
        }

        TreeNode cur=root;

        Stack<TreeNode> st=new Stack<>();
        st.add(root);

        while(!st.isEmpty()){
            TreeNode rp=st.pop();

            if(cur != rp){
                cur.right=rp;
                cur.left=null;
                cur=cur.right;
            }

            if(rp.right != null){
                st.add(rp.right);
            }

            if(rp.left != null){
                st.add(rp.left);
            }
        }
    }
}