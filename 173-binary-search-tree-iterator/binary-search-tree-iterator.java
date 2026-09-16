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
class BSTIterator {
    List<Integer> ll;
    public BSTIterator(TreeNode root) {
        ll=new ArrayList<>();
        solve(root);
    }

    public void solve(TreeNode root){
        if(root==null){
            return;
        }
        solve(root.left);
        ll.add(root.val);
        solve(root.right);
    }
    
    int idx=0;
    public int next() {
        int val=ll.get(idx);
        idx++;
        return val;
    }
    
    public boolean hasNext() {
        return idx<ll.size();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */