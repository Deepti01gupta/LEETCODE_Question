class Solution {
    public long sumAndMultiply(int n) {
        String s=String.valueOf(n);

        long sum=0;
        StringBuilder sb=new StringBuilder();
        for(int i=0; i<s.length(); i++){
            char ch=s.charAt(i);
            if(ch!='0'){
                sum+=ch-'0';
                sb.append(ch);
            }
        }
        long val=sb.length()==0? 0:Long.parseLong(sb.toString());
        long ans=val*sum;
        return ans;
    }
}