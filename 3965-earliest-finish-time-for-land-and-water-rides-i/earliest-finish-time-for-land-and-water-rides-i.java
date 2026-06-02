class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int n=landStartTime.length;
        int m=waterStartTime.length;

        int min=Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                int land_end=landStartTime[i]+landDuration[i];
                int water_start=Math.max(land_end,waterStartTime[j]);
                int seq1=water_start+waterDuration[j];
                min=Math.min(min,seq1);

                int water_end=waterStartTime[j]+waterDuration[j];
                int land_start=Math.max(water_end,landStartTime[i]);
                int seq2=land_start+landDuration[i];
                min=Math.min(min,seq2);
            }
        }
        return min;
    }
}