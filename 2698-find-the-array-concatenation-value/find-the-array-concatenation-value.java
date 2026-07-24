class Solution {
    public long findTheArrayConcVal(int[] nums) {
        int n=nums.length;

        int i=0;
        int j=n-1;

        long ans=0;
        while(i<=j){
            if(i==j){
                int v=nums[i];
                ans+=v;
                i++;
            }
            else{
                String s=""+nums[i]+nums[j];
                int v=Integer.parseInt(s);
                ans+=v;
                i++;
                j--;
            }
        }

        return ans;
    }
}