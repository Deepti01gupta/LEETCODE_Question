class Solution {
    public int minDistance(String s, String t) {

        // return  min(s,t,0,0);

        int[][] dp=new int[s.length()][t.length()];
        for(int i=0; i<dp.length; i++){
            Arrays.fill(dp[i],-1);
        }
        return min1(s,t,0,0,dp);
    }

    public int min1(String s, String t, int i, int j, int[][] dp){
        if(i==s.length()){
            return t.length()-j;
        }
        if(j==t.length()){
            return s.length()-i;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int ans=0;
        if(s.charAt(i)==t.charAt(j)){
            ans=min1(s,t,i+1,j+1,dp);
        }
        else{
            int I=min1(s,t,i,j+1,dp);
            int R=min1(s,t,i+1,j+1,dp);
            int D=min1(s,t,i+1,j,dp);
            ans=Math.min(I,Math.min(D,R))+1;
        }
        return dp[i][j]=ans;
    }

    public int min(String s, String t, int i, int j){
        if(i==s.length()){
            return t.length()-j;
        }
        if(j==t.length()){
            return s.length()-i;
        }
        int ans=0;
        if(s.charAt(i)==t.charAt(j)){
            ans=min(s,t,i+1,j+1);
        }
        else{
            int I=min(s,t,i,j+1);
            int R=min(s,t,i+1,j+1);
            int D=min(s,t,i+1,j);
            ans=Math.min(I,Math.min(R,D))+1;
        }
        return ans;
    }
}