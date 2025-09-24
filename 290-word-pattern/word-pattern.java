class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] str=s.split(" ");
        if(pattern.length()!=str.length){
            return false;
        }
        Map<Character, String> mp1=new HashMap<>();
        Map<String, Character> mp2=new HashMap<>();

        for(int i=0; i<pattern.length(); i++){
            char ch=pattern.charAt(i);
            String word=str[i];

            if(mp1.containsKey(ch)){
                if(!mp1.get(ch).equals(word)){
                    return false;
                }
            }
            else{
                mp1.put(ch,word);
            }

            if(mp2.containsKey(word)){
                if(!mp2.get(word).equals(ch)){
                    return false;
                }
            }
            else{
                mp2.put(word,ch);
            }
        }
        return true;
    }
}