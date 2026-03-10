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
    int count=0;

    public int pseudoPalindromicPaths (TreeNode root) {
        Set<Integer> set=new HashSet<>();
        solve(root,set);
        return count;
    }

    private void solve(TreeNode root, Set<Integer> set){
        if(root==null){
            return;
        }
        if(set.contains(root.val)){
            set.remove(root.val);
        }
        else{
            set.add(root.val);
        }

        if(root.left==null && root.right==null){
            if(set.size()==0 || set.size()==1){
                count++;
            }
        }

        solve(root.left, new HashSet(set));
        solve(root.right, new HashSet(set));
    }
}