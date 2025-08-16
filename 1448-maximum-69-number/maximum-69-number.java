class Solution {
    public int maximum69Number (int num) {
        String s = Integer.toString(num);
        StringBuilder sb=new StringBuilder();
        int flag=1;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='6' && flag==1){
                sb.append('9');
                flag=0;
            }
            else{
                sb.append(s.charAt(i));
            }
        }
        return Integer.parseInt(sb.toString());
    }
}