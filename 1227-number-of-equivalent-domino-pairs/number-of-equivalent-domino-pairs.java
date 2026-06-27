class Solution {

    // TLE:

    // public int numEquivDominoPairs(int[][] dominoes) {
    //     int ans=0;

    //     for(int i=0; i<dominoes.length; i++){
    //         for(int j=i+1; j<dominoes.length; j++){
    //             if((dominoes[i][0]==dominoes[j][0] && dominoes[i][1]==dominoes[j][1]) || (dominoes[i][0]==dominoes[j][1] && dominoes[i][1]==dominoes[j][0])){
    //                 ans++;
    //             }
    //         }
    //     }

    //     return ans;
    // }

    public int numEquivDominoPairs(int[][] dominoes){
        HashMap<Integer, Integer> map=new HashMap<>();
        int ans=0;

        for(int[] domino: dominoes){
            int a=Math.min(domino[0], domino[1]);
            int b=Math.max(domino[0], domino[1]);

            int key=a*10+b;

            ans+=map.getOrDefault(key,0);

            map.put(key, map.getOrDefault(key,0)+1);
        }

        return ans;
    }
}