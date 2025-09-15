class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        int ans=0;
        String[] arr=text.split(" ");
        char[] ch=brokenLetters.toCharArray();
        for(String word:arr){
            boolean flag=true;
            for(char c:ch){
                if(word.contains(String.valueOf(c))){
                    flag=false;
                    break;
                }
            }
            if(flag) ans++;
        }
        return ans;
    }
}