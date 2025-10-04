class Solution {
    public String pushDominoes(String s) {
        int n=s.length();
        int[] pre=new int[n]; // left
        int i=0;
        if(s.charAt(0)=='.'){
            pre[0]=-1;
            i=1;
        }
        for(; i<n; i++){
            if(s.charAt(i)=='L'){
                pre[i]=-1;
            }
            else if(s.charAt(i)=='R'){
                pre[i]=i;
            }
            else{
                pre[i]=pre[i-1];
            }
        }
        int[] suf=new int[n]; // right
        i=n-1;
        if(s.charAt(n-1)=='.'){
            suf[n-1]=-1;
            i=n-2;
        }
        for(; i>=0; i--){
            if(s.charAt(i)=='R'){
                suf[i]=-1;
            }
            else if(s.charAt(i)=='L'){
                suf[i]=i;
            }
            else{
                suf[i]=suf[i+1];
            }
        }

        StringBuilder sb=new StringBuilder();
        for( i=0; i<n; i++){
            int l=Math.abs(i-pre[i]);
            int r=Math.abs(i-suf[i]);
            if((pre[i]==-1 && suf[i]==-1)){
                sb.append('.');
            }
            else if(pre[i]==-1){
                sb.append('L');
            }
            else if(suf[i]==-1){
                sb.append('R');
            }
            else if(l>r){
                sb.append('L');
            }
            else if(r>l){
                sb.append('R');
            }else if(l == r) sb.append(".");
        }
        return sb.toString();
    }
}