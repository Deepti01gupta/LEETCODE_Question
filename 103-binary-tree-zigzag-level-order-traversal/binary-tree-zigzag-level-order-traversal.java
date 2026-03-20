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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();

        if(root==null){
            return ans;
        }

        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        int flag=0;

        while(!q.isEmpty()){
            int n=q.size();
            List<Integer> ll=new ArrayList<>();

            for(int i=0; i<n; i++){
                TreeNode node=q.poll();
                ll.add(node.val);

                if(node.left!=null) q.add(node.left);
                if(node.right!=null) q.add(node.right);
            }

            if(flag==1){
                Collections.reverse(ll);
            }
            ans.add(new ArrayList<>(ll));
            flag=flag^1;
        }

        return ans;
    }

    // public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    //     List<List<Integer>> ans=new ArrayList<>();
    //     if(root==null){
    //         return ans;
    //     }

    //     List<Integer> currans=new ArrayList<>();

    //     Stack<TreeNode> main=new Stack<>();
    //     Stack<TreeNode> helper=new Stack<>();
    //     int level=0;
    //     main.push(root);
    //     while(main.size()>0){
    //         TreeNode currnode=main.pop();
    //         currans.add(currnode.val);

    //         if(level==0){
    //             if(currnode.left!=null){
    //                 helper.push(currnode.left);
    //             }

    //             if(currnode.right!=null){
    //                 helper.push(currnode.right);
    //             }
    //         }
    //         else{
    //             if(currnode.right!=null){
    //                 helper.push(currnode.right);
    //             }

    //             if(currnode.left!=null){
    //                 helper.push(currnode.left);
    //             }
    //         }

    //         if(main.size()==0){
    //             ans.add(currans);
    //             currans=new ArrayList<>();
    //             level=1-level;

    //             main=helper;
    //             helper=new Stack<>();
    //         }
    //     } 
    //     return ans;
    // }
}