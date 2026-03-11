class Solution {
    Map<Integer, Boolean> map=new HashMap<>();

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if(desiredTotal<=0 ){
            return true;
        }

        int sum=maxChoosableInteger*(maxChoosableInteger+1)/2;
        if(sum<desiredTotal){
            return false;
        }

        return solve(maxChoosableInteger, desiredTotal, 0);
    }

    private boolean solve(int max, int total, int mask){
        if(map.containsKey(mask)){
            return map.get(mask);
        }

        for(int i=1; i<=max; i++){
            if((mask & (1<<i)) == 0){
                if(i>=total || !solve(max,total-i, mask | (1<<i))){
                    map.put(mask,true);
                    return true;
                }
            }
        }

        map.put(mask,false);
        return false;
    }
}