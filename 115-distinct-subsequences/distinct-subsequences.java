class Solution {
    public int numDistinct(String s, String t) {
        // return Coin_change(s,t,0,0);


        int[][] dp=new int[s.length()][t.length()];
		for(int[] a:dp){
          Arrays.fill(a,-1);
		}
		return Coin_change1(s,t,0,0,dp);
    }

    public static int Coin_change1(String s, String t, int i, int j, int[][] dp) {
		if(j==t.length()) {
			return 1;	
		}
		if(i==s.length()) {
			return 0;
		}
		
		if(dp[i][j]!=-1) {
			return dp[i][j];
		}
		
		int inc=0, exc=0;
		if(s.charAt(i)==t.charAt(j)) {
			inc=Coin_change1(s,t,i+1,j+1,dp);
		}
		exc=Coin_change1(s,t,i+1,j,dp);
		return dp[i][j]=exc+inc;
	}



    public static int Coin_change(String s, String t, int i, int j) {
		if(j==t.length()) {
			return 1;
		}
		if(i==s.length()) {
			return 0;
		}
		
		int inc=0, exc=0;
		if(s.charAt(i)==t.charAt(j)) {
			inc=Coin_change(s,t,i+1,j+1);
		}
		exc=Coin_change(s,t,i+1,j);
		return inc+exc;
		
	}
}