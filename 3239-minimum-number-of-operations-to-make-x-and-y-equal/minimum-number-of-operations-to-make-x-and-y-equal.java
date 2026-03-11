class Solution {

    Map<Integer, Integer> map=new HashMap<>();

    public int minimumOperationsToMakeEqual(int x, int y) {
        return solve(x,y);
    }

    private int solve(int x, int y){
        if(x<=y){
            return y-x;
        }

        if(map.containsKey(x)){
            return map.get(x);
        }

        int ans=x-y;

        int r1=x%11;
        ans=Math.min(ans,r1+1+solve(x/11,y));

        ans=Math.min(ans,(11-r1)+1+solve(x/11+1,y));

        int r5=x%5;
        ans=Math.min(ans,r5+1+solve(x/5,y));

        ans=Math.min(ans,(5-r5)+1+solve(x/5+1,y));

        map.put(x,ans);
        return ans;
    }
}