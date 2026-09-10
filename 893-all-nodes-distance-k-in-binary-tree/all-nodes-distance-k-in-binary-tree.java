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
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> parent=new HashMap<>();
        mark(root, parent);

        Map<TreeNode, Boolean> vis=new HashMap<>();
        Queue<TreeNode> q=new LinkedList<>();
        q.add(target);
        vis.put(target, true);
        int dis=0;

        while(!q.isEmpty()){
            int n=q.size();
            if(dis==k){
                break;
            }

            dis++;
            for(int i=0; i<n; i++){
                TreeNode nn=q.poll();

                if(nn.left!=null && vis.get(nn.left)==null){
                    q.add(nn.left);
                    vis.put(nn.left, true);
                }

                if(nn.right!=null && vis.get(nn.right)==null){
                    q.add(nn.right);
                    vis.put(nn.right, true);
                }

                if(parent.get(nn)!=null &&  vis.get(parent.get(nn))==null){
                    q.add(parent.get(nn));
                    vis.put(parent.get(nn), true);
                }
            }
        }

        List<Integer> ans=new ArrayList<>();
        while(!q.isEmpty()){
            TreeNode cur=q.poll();
            ans.add(cur.val);
        }

        return ans;
    }

    private void mark(TreeNode root, Map<TreeNode, TreeNode> parent){
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            TreeNode cur=q.poll();

            if(cur.left!=null){
                parent.put(cur.left, cur);
                q.add(cur.left);
            }
            if(cur.right!=null){
                parent.put(cur.right, cur);
                q.add(cur.right);
            }
        }
    }
}