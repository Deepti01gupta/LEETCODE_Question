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

    // -1 = camera needed
    // 1 = camera install
    // 0 = camera is convering

    int camera=0;
    public int minCameraCover(TreeNode root) {
        int c=minCamera(root);
        if(c==-1){
            camera++;
        }
        return camera;
    }

    public int minCamera(TreeNode root){
        if(root==null){
            return 0;
        }
        
        int left=minCamera(root.left);
        int right=minCamera(root.right);
        if(left==-1 || right==-1){  // is node par camera ki need hai
            camera++;
            return 1;  // camera setup krna h is node pr
        }
        else if(left==1 || right==1){  // inme se koi ek k pass ye dono k pass camera hai or ek k pass camera hai or dusra convered hai 
            return 0;
        }
        else{
            return -1; // dono child covered hai but mujhe camera chahiye
        }
    }
}