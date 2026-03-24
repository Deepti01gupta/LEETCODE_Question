class Solution {
    // public int numberOfSubarrays(int[] nums, int k) {
    //     int ans=0;
    //     int c=0;
    //     int left=0;
    //     int even=0;
    //     for(int right=0; right<nums.length; right++){
    //         if(nums[right]%2==1){
    //             c++;
    //             even=0;
    //         }
    //         while(c==k){
    //             if(nums[left]%2==1){
    //                 c--;
    //             }
    //             left++;
    //             even++;
    //         }
    //         ans+=even;
    //     }
    //     return ans;
    // }

    public int numberOfSubarrays(int[] nums, int k) {

        Map<Integer, Integer> freq = new HashMap<>();
        freq.put(0, 1);

        int oddCount = 0;
        int result = 0;

        for (int num : nums) {

            if (num % 2 == 1) oddCount++;

            if (freq.containsKey(oddCount - k)) {
                result += freq.get(oddCount - k);
            }

            freq.put(oddCount, freq.getOrDefault(oddCount, 0) + 1);
        }
        
        return result;
    }
}