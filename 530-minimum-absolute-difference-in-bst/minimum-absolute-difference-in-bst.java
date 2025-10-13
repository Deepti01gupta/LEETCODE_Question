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
    public int getMinimumDifference(TreeNode root) {
        List<Integer> ll=new ArrayList<>();
        fun(root,ll);
        Collections.sort(ll);
        int ans=Integer.MAX_VALUE;
        for(int i=0; i<ll.size()-1; i++){
            ans=Math.min(ans,Math.abs(ll.get(i)-ll.get(i+1)));
        }
        return ans;
    }

    public void fun(TreeNode root, List<Integer> ll){
        if(root==null){
            return;
        }
        ll.add(root.val);
        fun(root.left,ll);
        fun(root.right,ll);
    }
}