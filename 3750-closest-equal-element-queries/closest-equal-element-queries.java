class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        Map<Integer, List<Integer>> map=new HashMap<>();

        for(int i=0; i<nums.length; i++){
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        List<Integer> ans=new ArrayList<>();
        int n=nums.length;

        for(int q:queries){
            int v=nums[q];
            List<Integer> list=map.get(v);

            if(list.size()==1){
                ans.add(-1);
                continue;
            }

            int pos=Collections.binarySearch(list, q);

            int m=list.size();
            int minDist=Integer.MAX_VALUE;

            int left=list.get((pos - 1 + m) % m);

            int right=list.get((pos + 1) % m);

            int diff1=Math.abs(q - left);
            int diff2=Math.abs(q - right);

            minDist=Math.min(
                Math.min(diff1, n - diff1),
                Math.min(diff2, n - diff2)
            );

            ans.add(minDist);
        }

        return ans;
    }
}