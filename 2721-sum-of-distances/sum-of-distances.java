class Solution {
    public long[] distance(int[] nums) {
        int n=nums.length;
        long[] ans=new long[n];

        Map<Integer, List<Integer>> map=new HashMap<>();
        for(int i=0; i<n; i++){
            map.putIfAbsent(nums[i], new ArrayList<>());
            map.get(nums[i]).add(i);
        }

        for(List<Integer> list : map.values()){
            int size=list.size();

            long prefixSum=0;
            long totalSum=0;

            for(int idx:list){
                totalSum+=idx;
            }

            for(int i=0; i<size; i++){
                int idx=list.get(i);

                long left=(long) idx*i - prefixSum;
                long right=(totalSum-prefixSum-idx) - (long) idx*(size-i-1);

                ans[idx]=left+right;

                prefixSum+=idx;
            }
        }

        return ans;
    }
}