class Solution {
    public int mirrorFrequency(String s) {
        Map<Character, Integer> map=new HashMap<>();

        for(char ch:s.toCharArray()){
            
            map.put(ch,map.getOrDefault(ch,0)+1);
        }

        int ans=0;

        for(char ch='a'; ch<='m'; ch++){
            char t=(char)('z'-(ch-'a'));

            int f1=map.getOrDefault(ch,0);
            int f2=map.getOrDefault(t,0);

            ans+=Math.abs(f1-f2);
        }

        for(char ch='0'; ch<='4'; ch++){
            char t=(char)('9'-(ch-'0'));

            int f1=map.getOrDefault(ch,0);
            int f2=map.getOrDefault(t,0);

            ans+=Math.abs(f1-f2);
        }

        return ans;
    }
}