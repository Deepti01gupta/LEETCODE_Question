class Solution {
    public int characterReplacement(String s, int k) {
        
        // tc: O(n) sc : O(26)=O(1)
        int[] freq=new int[26];
        int l=0;
        int maxf=0, maxl=0;

        for(int r=0; r<s.length(); r++){
            freq[s.charAt(r)-'A']++;
            maxf=Math.max(maxf,freq[s.charAt(r)-'A']);

            int len=r-l+1;

            if(len-maxf>k){
                freq[s.charAt(l)-'A']--;
                l++;
            }

            len=r-l+1;
            maxl=Math.max(maxl,len);
        }
        return maxl;
    }
}