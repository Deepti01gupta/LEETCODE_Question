class Solution {
    public List<String> commonChars(String[] words) {
        
        int[] min=new int[26];
        Arrays.fill(min, Integer.MAX_VALUE);

        for(String s:words){
            int[] fre=new int[26];

            for(int i=0; i<s.length(); i++){
                fre[s.charAt(i)-'a']++;
            }

            for(int i=0; i<26; i++){
                min[i]=Math.min(min[i],fre[i]);
            }
        }

        List<String> ans=new ArrayList<>();
        for(int i=0; i<26; i++){
            while(min[i]>0){
                ans.add(String.valueOf((char)('a'+i)));
                min[i]--;
            }
        }

        return ans;
    }
}