class Solution {
    // public List<Integer> largestDivisibleSubset(int[] nums) {
    //     int n=nums.length;
    //     List<Integer> ll=new ArrayList<>();

    //     for(int i=0; i<n; i++){
    //         boolean flag=true;
    //         for(int j=0; j<ll.size(); j++){
    //             if(nums[i]%ll.get(j)!=0 && ll.get(j)%nums[i]!=0){
    //                 flag=false;
    //                 break;
    //             }
    //         }
    //         if(flag){
    //             ll.add(nums[i]);
    //         }
    //     }

    //     return ll;
    // }

    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);

        int[] dp=new int[n];
        Arrays.fill(dp,1);

        int[] hash=new int[n];
        hash[0]=-1;

        int max=1;
        int idx=0;

        for(int i=1; i<n; i++){
            hash[i]=-1;
            for(int j=0; j<i; j++){
                if(nums[i]%nums[j]==0 && dp[i]<dp[j]+1){
                    dp[i]=dp[j]+1;
                    hash[i]=j;
                }
            }
            if(dp[i]>max){
                max=dp[i];
                idx=i;
            }
        }

        List<Integer> ll=new ArrayList<>();
        while(idx!=-1){
            ll.add(nums[idx]);
            idx=hash[idx];
        }

        return ll;
    }
}