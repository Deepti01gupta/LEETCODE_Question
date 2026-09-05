class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map=new HashMap<>();
        int ans=0;
        int left=0;

        for(int right=0; right<s.length(); right++){
            char ch=s.charAt(right);

            map.put(ch, map.getOrDefault(ch, 0)+1);

            while(map.get(ch)>1){
                char temp=s.charAt(left);
                map.put(temp, map.get(temp)-1);
                left++;
            }

            ans=Math.max(ans, right-left+1);
        }

        return ans;
    }
}