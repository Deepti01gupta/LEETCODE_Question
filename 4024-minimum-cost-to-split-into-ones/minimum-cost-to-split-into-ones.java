class Solution {
    public int minCost(int n) {
        return solve(n);
    }

    private int solve(int n){
        if(n<1){
            return 0;
        }

        return (n-1)+solve(n-1);
    }
}