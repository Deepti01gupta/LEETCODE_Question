class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        for(int i=1; i<triangle.size(); i++){
            int k=0;
            for(int j=0; j<triangle.get(i).size(); j++){

                // upper-side wali value ko calculate krenge
                int left=j>0? triangle.get(i - 1).get(j - 1) : Integer.MAX_VALUE;

                // upper wali value ko calculate krenge
                int up=j<triangle.get(i-1).size()? triangle.get(i-1).get(j):Integer.MAX_VALUE;

                // dono k min ko value main add krke wapas store kr denge
                triangle.get(i).set(j,triangle.get(i).get(j)+Math.min(left,up));
            }
        }

        // last wali line m min find kr lenge
        int ans=Integer.MAX_VALUE;
        for(int val:triangle.get(triangle.size()-1)){
            ans=Math.min(ans, val);
        }
        return ans;
    }
}