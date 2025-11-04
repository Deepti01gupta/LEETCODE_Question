class Solution {
    // public int totalSteps(int[] nums) {
    //     int n=nums.length;
    //     List<Integer> ll=new ArrayList<>();
    //     for(int i:nums){
    //         ll.add(i);
    //     }
    //     int c=0;
    //     while(true){
    //         List<Integer> arr=new ArrayList<>();
    //         arr.add(ll.get(0));
    //         for(int i=1; i<ll.size(); i++){
    //             if(ll.get(i)>=ll.get(i-1)){
    //                 arr.add(ll.get(i));
    //             }
    //         }
    //         if(arr.size()==ll.size()){
    //             return c;
    //         }
    //         c++;
    //         ll=arr;
    //     }
    // }

    public int totalSteps(int[] nums) {
        int n=nums.length;
        Stack<int[]> st=new Stack<>();
        int ans=0;
        
        for(int i:nums){
            int step=0;

            while(!st.isEmpty() && i>=st.peek()[0]){
                step=Math.max(step,st.pop()[1]);
            }

            if(!st.isEmpty()){
                step+=1;
            }
            else{
                step=0;
            }

            ans=Math.max(ans,step);
            st.add(new int[]{i,step});
        }
        return ans;

        
    }
}