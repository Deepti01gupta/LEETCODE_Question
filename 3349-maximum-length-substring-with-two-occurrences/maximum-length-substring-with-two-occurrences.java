class Solution {
    public int maximumLengthSubstring(String s) {
        int ans=0;

        int left=0;
        Map<Character, Integer> map=new HashMap<>();
        
        for(int right=0; right<s.length(); right++){
            char ch=s.charAt(right);

            map.put(ch,map.getOrDefault(ch,0)+1);

            while(map.get(ch)>2){
                char temp=s.charAt(left);

                map.put(temp,map.get(temp)-1);
                left++;
            }

            ans=Math.max(right-left+1, ans);
        }

        return ans;
    }
}