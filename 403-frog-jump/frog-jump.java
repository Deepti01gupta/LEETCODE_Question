class Solution {

    public boolean canCross(int[] stones) {
        if(stones.length < 2 || stones[1] != 1) {
            return false;
        }

        Set<Integer> set=new HashSet<>();
        for(int i:stones){ 
            set.add(i); 
        }

        Map<String, Boolean> dp=new HashMap<>();

        return solve(1, 1, stones[stones.length-1], set, dp);
    }

    public boolean solve(int idx, int prev, int max, Set<Integer> set, Map<String, Boolean> dp){

        if(idx==max){
            return true;
        }

        if(dp.containsKey(idx + "," + prev)){
            return dp.get(idx + "," + prev);
        }

        String key=idx + "," + prev;

        boolean first=false;
        boolean second=false;
        boolean third=false;

        if(prev-1<=0){
            first=false;
        }
        else{
            int v1=idx+prev-1;
            if(set.contains(v1)){
                first=solve(v1, prev-1, max, set, dp);
            }
        }

        int v2=idx+prev;
        if(set.contains(v2)){
            second=solve(v2, prev, max, set, dp);
        }

        int v3=idx+prev+1;
        if(set.contains(v3)){
            third=solve(v3, prev+1, max, set, dp);
        }

        boolean ans = first || second || third;

        dp.put(key, ans);

        return ans;
        
    }



    // TLE
    // public boolean canCross(int[] stones) {
    //     List<Integer> ll=new ArrayList<>();
    //     for(int i:stones){
    //         ll.add(i);
    //     }

    //     if(!ll.contains(1)){
    //         return false;
    //     }

    //     return solve(1,1, ll);
    // }

    // public boolean solve(int idx, int prev, List<Integer> ll){

    //     if(idx==ll.get(ll.size()-1)){
    //         return true;
    //     }

    //     boolean first=false;
    //     boolean second=false;
    //     boolean third=false;

    //     if(prev-1<=0){
    //         first=false;
    //     }
    //     else{
    //         int v1=idx+prev-1;
    //         if(ll.contains(v1)){
    //             first=solve(v1, prev-1, ll);
    //         }
    //     }

    //     int v2=idx+prev;
    //     if(ll.contains(v2)){
    //         second=solve(v2, prev, ll);
    //     }

    //     int v3=idx+prev+1;
    //     if(ll.contains(v3)){
    //         third=solve(v3, prev+1, ll);
    //     }

    //     return first || second || third;
        
    // }
}