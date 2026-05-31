class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {

        Arrays.sort(asteroids);

        long cur=mass;

        for(int i:asteroids){
            if(cur>=i){
                cur+=i;
            }
            else{
                return false;
            }
        }

        return true;
    }
}