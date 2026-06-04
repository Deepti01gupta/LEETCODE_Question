class Solution {
    public int totalWaviness(int num1, int num2) {
        int t=0;
        for(int i=num1; i<=num2; i++){
            t+=solve(i);
        }
        return t;
    }
    private int solve(int n){
        String s=String.valueOf(n);
        if(s.length()<3) return 0;
        int c=0;
        for(int i=1; i<s.length()-1; i++){
            if((s.charAt(i)-'0'>s.charAt(i+1)-'0') && (s.charAt(i)-'0'>s.charAt(i-1)-'0')){
                c++;
            }
            if((s.charAt(i)-'0'<s.charAt(i+1)-'0') && (s.charAt(i)-'0'<s.charAt(i-1)-'0')){
                c++;
            }
        }
        return c;
    }
}