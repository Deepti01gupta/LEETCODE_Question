class Solution {
    public int countElements(int[] nums) {
        int n=nums.length;
        if(n<3){
            return 0;
        }
        Arrays.sort(nums);

        int min=nums[0];
        int max=nums[n-1];

        int c1=0;
        while(c1<n && nums[c1]==min){
            c1++;
        }

        int c2=n-1;
        while(c2>=0 && nums[c2]==max){
            c2--;
        }

        int ans=Math.max(0, c2 - c1 + 1);
        return ans;
    }
}