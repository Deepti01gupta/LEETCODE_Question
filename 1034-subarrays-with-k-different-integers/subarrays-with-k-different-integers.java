class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return solve(nums, k) - solve(nums, k-1);
    }

    public int solve(int[] nums, int k) {
        Map<Integer, Integer> map=new HashMap<>();
        int left=0;
        int ans=0;

        for(int right=0; right<nums.length; right++){
            int val=nums[right];

            map.put(val, map.getOrDefault(val, 0)+1);

            while(map.size()>k){
                int temp=nums[left];
                map.put(temp, map.get(temp)-1);

                if(map.get(temp)==0){
                    map.remove(temp);
                }

                left++;
            }

            ans+=right-left+1;
        }

        return ans;
    }
}