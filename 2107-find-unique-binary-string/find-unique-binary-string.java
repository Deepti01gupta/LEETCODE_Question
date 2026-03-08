class Solution {
    public String findDifferentBinaryString(String[] nums) {
        int n=nums.length;

        Set<String> st=new HashSet<>();
        StringBuilder sb=new StringBuilder();
        for(int i=0; i<n; i++){
            sb.append('0');
            st.add(nums[i]);
        }

        return fun(st,0,sb);
    }

    private String fun(Set<String> st, int idx, StringBuilder s){
        if(idx==s.length()){
            if(!st.contains(s.toString())){
                return s.toString();
            }

            return null;
        }

        s.setCharAt(idx,'0');
        String res=fun(st,idx+1,s);
        if(res!=null){
            return res;
        }

        s.setCharAt(idx,'1');
        res=fun(st,idx+1,s);
        if(res!=null){
            return res;
        }

        return null;
    }
}