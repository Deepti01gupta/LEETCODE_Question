class Solution {
    public boolean hasSameDigits(String s) {
        while(s.length()>2){
            StringBuilder sb=new StringBuilder();
            for(int i=0; i<s.length()-1; i++){
                int a=s.charAt(i)-'0';
                int b=s.charAt(i+1)-'0';
                int v=(a+b)%10;
                sb.append(""+v);
            }
            s=sb.toString();
        }
        if(s.charAt(0)!=s.charAt(1)){
            return false;
        }
        return true;
    }
}