class Solution {
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        long max=0;
        for(int i:workerTimes){
            max=Math.max(i,max);
        }

        long lo=0;
        long hi = ((long)mountainHeight * (mountainHeight + 1) / 2) * max;
        
        long res=0;
        
        while(lo<=hi){
            long mid=lo+(hi-lo)/2;

            if(check(mid, mountainHeight, workerTimes)){
                res=mid;
                hi=mid-1;
            }
            else{
                lo=mid+1;
            }
        }

        return res;
    }

    private boolean check(long mid, int mh, int[] worker){
        long  sum=0;

        for(int i:worker){
            long time = (long)((Math.sqrt(1 + (8.0 * mid)/i) - 1) / 2);

            sum += time;
        }

        if(sum>=mh){
            return true;
        }
        return false;
    }
}