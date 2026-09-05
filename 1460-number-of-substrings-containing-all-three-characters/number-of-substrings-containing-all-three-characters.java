class Solution {
    public int numberOfSubstrings(String s) {
        int[] fre=new int[3];
        int ans=0;
        int left=0;

        for(int right=0; right<s.length(); right++){
            char ch=s.charAt(right);
            fre[ch-'a']++;

            while(fre[0]>0 && fre[1]>0 && fre[2]>0){
                ans+=(s.length()-right);

                fre[s.charAt(left)-'a']--;
                left++;
            }
        }

        return ans;
    }
}