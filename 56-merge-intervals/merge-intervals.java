class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length<=1){
            return intervals;
        }

        List<int[]> ll=new ArrayList<>();

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int start=intervals[0][0];
        int end=intervals[0][1];

        for(int i=1; i<intervals.length; i++){
            if(intervals[i][0]<=end){
                end=Math.max(end,intervals[i][1]);
            }
            else{
                ll.add(new int[]{start,end});
                start=intervals[i][0];
                end=intervals[i][1];
            }
        }
        ll.add(new int[]{start,end});

        int[][] ans=new int[ll.size()][2];
        for(int i=0; i<ll.size(); i++){
            ans[i][0]=ll.get(i)[0];
            ans[i][1]=ll.get(i)[1];
        }

        return ans;
    }
}