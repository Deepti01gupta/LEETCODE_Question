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
    class pair{
        TreeNode node;
        int idx;
        pair(TreeNode node, int idx){
            this.node=node;
            this.idx=idx;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        Queue<pair> q=new LinkedList<>();
        int wid=0;
        q.add(new pair(root, 0));

        while(!q.isEmpty()){
            pair start=q.peek();
            pair end=null;

            int s=q.size();
            for(int i=0; i<s; i++){
                end=q.poll();

                if(end.node.left!=null){
                    q.add(new pair(end.node.left, 2*end.idx+1));
                }
                if(end.node.right!=null){
                    q.add(new pair(end.node.right, 2*end.idx+2));
                }
            }

            wid=Math.max(wid, end.idx - start.idx +1);
        }

        return wid;
    }
}