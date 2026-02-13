class Solution {
    public int longestBalanced(String s) {
        int n=s.length();
        int ans=0;

        for(int i=0; i<n; i++){
            int[] fre=new int[26];
            int dis=0;
            int max=0;

            for(int j=i; j<n; j++){
                int idx=s.charAt(j)-'a';

                if(fre[idx]==0){
                    dis++;
                }

                fre[idx]++;
                max=Math.max(max,fre[idx]);

                int length=j-i+1;

                if(length==dis*max){
                    ans=Math.max(ans,length);
                }
            }
        }
        return ans;
    }
    // public int longestBalanced(String s) {
    //     int ans=0;
    //     for(int i=0; i<s.length(); i++){
    //         for(int j=i+1; j<=s.length(); j++){
    //             if(solve(s.substring(i,j))){
    //                 ans=Math.max(j-i,ans);
    //             }
    //         }
    //     }

    //     return ans;
    // }

    // public boolean solve(String s){

    //     Map<Character, Integer> map=new HashMap<>();

    //     for(char ch:s.toCharArray()){
    //         map.put(ch,map.getOrDefault(ch,0)+1);
    //     }

    //     int freq=-1;

    //     for(int value:map.values()){
    //         if(freq==-1){
    //             freq=value;
    //         }
    //         else if(freq!=value){
    //             return false;
    //         }
    //     }
    //     return true;        
    // }
}