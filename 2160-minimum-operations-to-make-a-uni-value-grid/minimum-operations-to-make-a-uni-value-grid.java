class Solution {
    public int minOperations(int[][] grid, int x) {
        List<Integer> ll=new ArrayList<>();
        for(int[] a:grid){
            for(int i:a){
                ll.add(i);
            }
        }

        Collections.sort(ll);
        int n=ll.size();
        int mid=n/2;

        int ans=0;
        int v=ll.get(mid);
        for(int i:ll){
            if(Math.abs(i-v)%x != 0){
                return -1;
            }
            ans+=Math.abs(i-v)/x;
        }

        return ans;

    }
}