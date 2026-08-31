class Solution {
    public int maxDepth(String s) {
        int cur=0;
        int ans=0;

        for(int i=0; i<s.length(); i++){
            char ch=s.charAt(i);
            if(ch=='('){
                cur++;
            }
            else if(ch==')'){
                cur--;
            }
            ans=Math.max(ans,cur);
        }

        return ans;
    }
}