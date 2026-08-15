class Solution {
    public int maxProfit(int[] prices) {
        int min=prices[0];
        int ans=0;

        for(int i=1; i<prices.length; i++){
            if(prices[i]>=min){
                int val=prices[i]-min;
                ans=Math.max(ans,val);
            }
            else{
                min=Math.min(min,prices[i]);
            }
        }

        return ans;
    }
}