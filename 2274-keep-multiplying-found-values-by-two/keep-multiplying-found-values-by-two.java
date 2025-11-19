class Solution {
    public int findFinalValue(int[] nums, int original) {
        Set<Integer> st=new HashSet<>();
        for(int i:nums){
            st.add(i);
        }
        while(true){
            if(!st.contains(original)){
                return original;
            }
            original*=2;
        }
    }
}