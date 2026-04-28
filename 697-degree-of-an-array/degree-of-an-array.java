class Solution {

    public int findShortestSubArray(int[] nums) {
        Map<Integer,Integer> count=new HashMap<>();
        Map<Integer,Integer> first=new HashMap<>();

        int degree=0;
        int ans=Integer.MAX_VALUE;

        for(int i=0; i<nums.length; i++){
            int num=nums[i];

            if(!first.containsKey(num)){
                first.put(num,i);
            }

            count.put(num, count.getOrDefault(num,0)+1);

            if(count.get(num)>degree){
                degree=count.get(num);
                ans=i-first.get(num)+1;
            }
            else if(count.get(num)==degree){
                ans=Math.min(ans, i-first.get(num)+1);
            }
        }

        return ans;
    }


    // public int findShortestSubArray(int[] nums) {
    //     int fre=0;
    //     int ele=0;
    //     Map<Integer, Integer> map=new HashMap<>();
    //     for(int i:nums){
    //         map.put(i,map.getOrDefault(i,0)+1);
    //         if(map.get(i)>fre){
    //             fre=map.get(i);
    //             ele=i;
    //         }
    //     }

    //     int ans=0;
    //     int l=0;
    //     int r=nums.length-1;
    //     while(l<nums.length && nums[l]!=ele){
    //         l++;
    //     }
    //     while(r>=0 && nums[r]!=ele){
    //         r--;
    //     }

    //     ans=r-l+1;
    //     return ans;
    // }
}