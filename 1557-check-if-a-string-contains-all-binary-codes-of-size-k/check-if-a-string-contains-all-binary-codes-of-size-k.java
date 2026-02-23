class Solution {
    public boolean hasAllCodes(String s, int k) {
        Set<String> st=new HashSet<>();

        for(int i=k; i<=s.length(); i++){
            st.add(s.substring(i-k,i));

            if(st.size()==(1<<k)){
                return true;
            }
        }

        if(st.size()==(1<<k)){
            return true;
        }
        return false;
    }
}