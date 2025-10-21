class Solution {
    // public long countSubarrays(int[] nums, int k) {
    //     long ans=0;
    //     for(int i=0; i<nums.length; i++){
    //         int val=nums[i];
    //         for(int j=i; j<nums.length; j++){
    //             val &= nums[j];
    //             if(val==k){
    //                 ans++;
    //             }
    //             else if(val<k){
    //                 break;
    //             }
    //         }
    //     }
    //     return ans;
    // }

    public long countSubarrays(int[] nums, int k) {
        long ans=0;
        Map<Integer,Long> prev=new HashMap<>();

        for(int num:nums){
            Map<Integer,Long> curr=new HashMap<>();
            curr.put(num,curr.getOrDefault(num,0L)+1);

            for(int val:prev.keySet()){
                int newVal=val&num;
                curr.put(newVal, curr.getOrDefault(newVal,0L)+prev.get(val));
            }

            ans+=curr.getOrDefault(k,0L);
            prev=curr;
        }
        return ans;
    }
}