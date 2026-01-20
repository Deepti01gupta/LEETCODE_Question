class Solution {
    public long minMaxSubarraySum(int[] nums, int k) {
        int n=nums.length;
        long ans=0;

        ans+=solve(nums,k,true);
        ans+=solve(nums,k,false);

        return ans;
    }

    private long solve(int[] nums, int k, boolean ismin){
        int n=nums.length;
        int[] left=new int[n];
        int[] right=new int[n];
        Stack<Integer> st=new Stack<>();

        for(int i=0; i<n; i++){
            while(!st.isEmpty() && (ismin? nums[st.peek()]>nums[i] : nums[st.peek()]<nums[i])){
                st.pop();
            }

            left[i]=st.isEmpty()? i+1:i-st.peek();
            st.push(i);
        }

        st.clear();

        for(int i=n-1; i>=0; i--){
            while(!st.isEmpty() && (ismin? nums[st.peek()]>=nums[i] : nums[st.peek()]<=nums[i])){
                st.pop();
            }
            right[i]=st.isEmpty()? n-i : st.peek()-i;
            st.push(i);
        }

        long ans=0;
        for(int i=0; i<n; i++){
            long cnt=count(left[i],right[i],k);
            ans+=cnt*nums[i];
        }

        return ans;
    }

    private long count(int l, int r, int k){
        int x=Math.min(l, k);
        if(x<=0) return 0;

        int full=Math.max(0, k-r+1);
        full=Math.min(full, x);

        long ans=(long) full*r;

        int rem=x-full;
        if(rem>0){
            long first=k-full;
            long last=k-x+1;
            ans+=(first+last)*rem/2;
        }

        return ans;
    }
}