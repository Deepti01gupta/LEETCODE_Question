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
        int l;
        int v;
        pair(TreeNode node, int l, int v){
            this.node=node;
            this.l=l;
            this.v=v;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();

        TreeMap<Integer, List<pair>> map=new TreeMap<>();
        Queue<pair> q=new LinkedList<>();
        q.add(new pair(root, 0, 0));

        while(!q.isEmpty()){
            pair rp=q.poll();
            if(!map.containsKey(rp.v)){
                map.put(rp.v, new ArrayList<>());
            }
            map.get(rp.v).add(rp);

            if(rp.node.left != null){
                q.add(new pair(rp.node.left, rp.l+1, rp.v-1));
            }
            if(rp.node.right != null){
                q.add(new pair(rp.node.right, rp.l+1, rp.v+1));
            }
        }

        for(int key:map.keySet()){
            List<pair> ll=map.get(key);
            Collections.sort(ll, new Comparator<pair>(){
                @Override
                public int compare(pair p1, pair p2){
                    if(p1.l == p2.l){
                        return p1.node.val - p2.node.val;
                    }
                    return 0;
                }
            });

            List<Integer> res=new ArrayList<>();
            for(pair v:ll){
                res.add(v.node.val);
            }

            ans.add(res);
        }

        return ans;

    }
}