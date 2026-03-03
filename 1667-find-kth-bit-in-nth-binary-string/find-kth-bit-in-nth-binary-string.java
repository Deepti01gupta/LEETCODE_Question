class Solution {
    public char findKthBit(int n, int k) {
        StringBuilder sb=new StringBuilder();
        sb.append(0);
        for(int i=2; i<=n; i++){
            StringBuilder s=new StringBuilder(sb);
            s.append(1);
            for(int j=sb.length()-1; j>=0; j--){
                if(sb.charAt(j)=='0'){
                    s.append(1);
                }
                else{
                    s.append(0);
                }
            }
            sb=s;
        }

        return sb.charAt(k-1);
    }
}