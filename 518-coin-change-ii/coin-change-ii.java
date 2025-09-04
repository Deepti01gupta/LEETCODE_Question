class Solution {
    public int change(int amount, int[] coins) {
        // return Coin_change(coins,amount,0);
		
		// int[][] dp=new int[amount+1][coins.length];
		// for(int[] a:dp){
        //   Arrays.fill(a,-1);
		// }
		// return Coin_change1(coins,amount,0,dp);

        return Coin_changeBU(coins,amount);
    }

    public static int Coin_changeBU(int[] coin, int amount) {
		int[][] dp=new int[coin.length+1][amount+1];
		for(int i=0; i<dp.length; i++) { // row
			dp[i][0]=1;	
		}
		for(int i=1; i<dp.length; i++) { // coin
			for(int am=1; am<dp[0].length; am++) { // amount
				int inc=0, exc=0;
				if(am>=coin[i-1]) {
					inc=dp[i][am-coin[i-1]];
				}
				exc=dp[i-1][am];
				dp[i][am]=inc+exc;
			}
		}
		return dp[dp.length-1][dp[0].length-1];
	}
    
    public static int Coin_change1(int[] coin, int amount, int i, int[][] dp) {
		if(amount==0) {
			return 1;	
		}
		if(i==coin.length) {
			return 0;
		}
		
		if(dp[amount][i]!=-1) {
			return dp[amount][i];
		}
		
		int inc=0, exc=0;
		if(amount>=coin[i]) {
			inc=Coin_change1(coin,amount-coin[i],i,dp);
		}
		exc=Coin_change1(coin,amount,i+1,dp);
		return dp[amount][i]=exc+inc;
	}

    public static int Coin_change(int[] coin, int amount, int i) {
		if(amount==0) {
			return 1;	
		}
		if(i==coin.length) {
			return 0;
		}
		
		int inc=0, exc=0;
		if(amount>=coin[i]) {
			inc=Coin_change(coin,amount-coin[i],i);
		}
		exc=Coin_change(coin,amount,i+1);
		return exc+inc;
	}
}