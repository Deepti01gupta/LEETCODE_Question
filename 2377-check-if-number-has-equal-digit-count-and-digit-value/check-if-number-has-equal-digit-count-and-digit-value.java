class Solution {
    public boolean digitCount(String num) {
        int[] fre=new int[10];

        for(int i=0; i<num.length(); i++){
            fre[num.charAt(i)-'0']++;
        }

        for(int i=0; i<num.length(); i++){
            if((num.charAt(i)-'0')!=fre[i]){
                return false;
            }
        }

        return true;
    }
}