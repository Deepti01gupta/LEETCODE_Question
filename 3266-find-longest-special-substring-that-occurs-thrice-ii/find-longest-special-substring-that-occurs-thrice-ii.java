class Solution {
    public int maximumLength(String s) {
        int n=s.length();
        int ans=-1;

        for(char ch='a'; ch<='z'; ch++){
            int[] fre=new int[n+1];
            int i=0;

            while(i<n){
                if(s.charAt(i)!=ch){
                    i++;
                    continue;
                }

                int j=i;
                while(j<n && s.charAt(j)==ch){
                    j++;
                }

                int len=j-i;

                for(int l=1; l<=len; l++){
                    fre[l]+=(len-l+1);
                }

                i=j;
            }

            for(int l=1; l<=n; l++){
                if(fre[l]>=3){
                    ans=Math.max(ans,l);
                }
            }
        }
        return ans;
    }
}