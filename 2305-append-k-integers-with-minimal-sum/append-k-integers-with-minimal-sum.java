class Solution {
    public long minimalKSum(int[] nums, int k) {
        Arrays.sort(nums);

        long sum=0;
        long cur=1;

        for(int i=0; i<nums.length && k>0; i++){
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }

            if(nums[i]>cur){
                long gap=nums[i]-cur;

                long take=Math.min(k,gap);

                sum+=take*cur+(take*(take-1))/2;

                k-=take;
                cur+=take;
            }

            if(nums[i]>=cur){
                cur=nums[i]+1;
            }
        }

        if(k>0){
            sum+=(long)k*cur+((long)k*(k-1))/2;
        }

        return sum;
    }
}