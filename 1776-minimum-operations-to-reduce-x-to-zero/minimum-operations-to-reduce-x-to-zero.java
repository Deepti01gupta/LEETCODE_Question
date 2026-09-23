class Solution {

    public int minOperations(int[] nums, int x) {
        int total=0;
        for(int i:nums){
            total+=i;
        }
        int target=total-x;
        if(target==0){
            return nums.length;
        }

        int left=0;
        int sum=0;
        int maxlen=-1;
        for(int right=0; right<nums.length; right++){
            sum+=nums[right];
            while(left<=right && sum>target){
                sum-=nums[left];
                left++;
            }
            
            if(sum==target){
                maxlen=Math.max(maxlen, right-left+1);
            }
        }

        if(maxlen==-1){
            return -1;
        }

        return nums.length-maxlen;
    }



    // public int minOperations(int[] nums, int x) {
    //     int c=0;
    //     int left=0;
    //     int right=nums.length-1;
    //     while(left<=right){
    //         if(nums[left]>x && nums[right]>x){
    //             return -1;
    //         }
    //         if(nums[left]<nums[right]){
    //             if(nums[right]<=x){
    //                 x-=nums[right];
    //                 c++;
    //                 right--;
    //             }
    //             else{
    //                 x-=nums[left];
    //                 c++;
    //                 left++;
    //             }
    //         }
    //         else{
    //             if(nums[left]<=x){
    //                 x-=nums[left];
    //                 left++;
    //                 c++;
    //             }
    //             else{
    //                 x-=nums[right];
    //                 c++;
    //                 right--;
    //             }
    //         }
    //         if(x==0){
    //             return c;
    //         }
    //     }
    //     if(x==0){
    //         return c;
    //     }
    //     return -1;
    // }
}