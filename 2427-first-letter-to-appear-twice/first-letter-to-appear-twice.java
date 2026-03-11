class Solution {
    public char repeatedCharacter(String s) {
        int[] arr=new int[26];

        for(int i=0; i<s.length(); i++){
            char ch=s.charAt(i);

            if(arr[ch-'a']>=1){
                return ch;
            }

            arr[ch-'a']++;
        }
        return ' ';
    }
}