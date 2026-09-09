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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();

        if(root==null){
            return ans;
        }

        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int n=q.size();
            List<Integer> ll=new LinkedList<>();

            for(int i=0; i<n; i++){
                TreeNode rp=q.poll();
                ll.add(rp.val);

                if(rp.left!=null){
                    q.add(rp.left);
                }
                if(rp.right!=null){
                    q.add(rp.right);
                }
            }

            ans.add(new ArrayList<>(ll));
        }

        return ans;
    }
}