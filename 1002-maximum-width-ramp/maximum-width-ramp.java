class Solution {
    public int maxWidthRamp(int[] nums) {
        int n=nums.length;

        Stack<Integer> st=new Stack<>();

        for(int i=0; i<n; i++){
            if(st.isEmpty() || nums[i]<nums[st.peek()]){
                st.push(i);
            }
        }

        int ans=0;

        for(int j=n-1; j>=0; j--){
            while(!st.isEmpty() && nums[st.peek()]<=nums[j]){
                ans=Math.max(ans, j-st.peek());
                st.pop();
            }
        }

        return ans;
    }
}