class Solution {
    public int minMirrorPairDistance(int[] nums) {
        Map<Integer, Integer> map=new HashMap<>();
        int ans=Integer.MAX_VALUE;

        for(int i=0; i<nums.length; i++){
            if(map.containsKey(nums[i])) {
                ans=Math.min(ans, i-map.get(nums[i]));
            }
            int rev=reverse(nums[i]);
            map.put(rev, i);
        }

        return ans==Integer.MAX_VALUE? -1:ans;
    }

    public int reverse(int n){
        int rev=0;
        while(n>0){
            int r=n%10;
            rev=rev*10+r;
            n/=10;
        }
        return rev;
    }
}