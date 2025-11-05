class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        int min=nums[0];
        int max=nums[n-1];
        List<Integer> ll=new ArrayList<>();
        for(int i=0; i<n-1; i++){
            for (int j=nums[i]+1; j<nums[i+1]; j++){
                ll.add(j);
            }
        }
        return ll;
    }
}