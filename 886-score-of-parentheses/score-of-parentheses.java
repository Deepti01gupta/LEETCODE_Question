class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> st=new Stack<>();
        int ans=0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='('){
                st.push(0);
            }
            else{
                int val=0;
                while(st.peek()!=0){
                    val+=st.pop();
                }
                st.pop();
                st.push(val==0? 1:2*val);
            }
        }
        while(!st.isEmpty()){
            ans+=st.pop();
        }
        return ans;
    }
}