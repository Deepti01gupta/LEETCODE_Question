class Solution {
    public int numberOfSpecialChars(String word) {
        Set<Character> ans=new HashSet<>();

        Set<Character> upper=new HashSet<>();
        Set<Character> lower=new HashSet<>();

        for(int i=0; i<word.length(); i++){
            char ch=word.charAt(i);

            if(Character.isUpperCase(ch)){

                if(lower.contains(Character.toLowerCase(ch))){
                    ans.add(Character.toLowerCase(ch));
                }

                upper.add(ch);
            }

            else if(Character.isLowerCase(ch)){

                if(upper.contains(Character.toUpperCase(ch))){
                    ans.add(ch);
                }

                lower.add(ch);
            }
        }

        return ans.size();
    }
}