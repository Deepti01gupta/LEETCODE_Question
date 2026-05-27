class Solution {
    public int numberOfSpecialChars(String word) {
        int[] lower=new int[26];
        int[] upper=new int[26];

        for(int i=0; i<26; i++){
            lower[i]=-1;
            upper[i]=Integer.MAX_VALUE;
        }

        for(int i=0; i<word.length(); i++){
            char ch=word.charAt(i);

            if(Character.isLowerCase(ch)){
                lower[ch-'a']=i;
            }
            else{
                upper[ch-'A']=Math.min(upper[ch-'A'],i);
            }
        }

        int c=0;
        for(int i=0; i<26; i++){
            if(lower[i]!=-1 && upper[i]!=Integer.MAX_VALUE && lower[i]<upper[i]){
                c++;
            }
        }

        return c;
    }
}