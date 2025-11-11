class Solution {

    // BRUTE FORCE APPROACH

    // public int minOperations(int[] nums) {
    //     Set<Integer> st=new HashSet<>();
    //     int n=nums.length;
    //     for(int i=0; i<n; i++){
    //         st.add(nums[i]);
    //     }
    //     int op=0;
    //     for(int t:st){
    //         if(t==0){
    //             continue;
    //         }
    //         boolean flag=false;
    //         for(int i=0; i<n; i++){
    //             if(nums[i]==t){
    //                 if(!flag){
    //                     flag=true;
    //                     op++;
    //                 }
    //             }
    //             else if(nums[i]<t){
    //                 flag=false;
    //             }
    //         }
    //     }
    //     return op;
    // }



    // OPTIMAL APPROACH

    public int minOperations(int[] nums) {
        Stack<Integer> st=new Stack<>();
        int op=0;
        for(int i=0; i<nums.length; i++){
            while(!st.isEmpty() && st.peek()>nums[i]){
                st.pop();
            }
            if(nums[i]==0){
                continue;
            }
            if(st.isEmpty() || st.peek()<nums[i]){
                op++;
                st.push(nums[i]);
            }
        }
        return op;
    }
}