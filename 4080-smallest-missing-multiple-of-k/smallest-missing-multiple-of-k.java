class Solution {
    public int missingMultiple(int[] nums, int k) {
        Set<Integer> st=new HashSet<>();
        for(int i:nums){
            st.add(i);
        }
        for(int i=1; i<Integer.MAX_VALUE; i++){
            if(!st.contains(i*k)){
                return i*k;
            }
        }
        return -1;
    }
}