class Solution {
    public double findMedianSortedArrays(int[] a, int[] b) {
        
        if(a.length>b.length){
            int[] t=a;
            a=b;
            b=t;
        }
        int lo=0;
        int hi=a.length;
        int total=(a.length+b.length);
        int hf=(total+1)/2;

        while(lo<=hi){
            int al=(lo+hi)/2;
            int bl=hf-al;

            // alm1 : a left minus 1 , a[al-1]
            // blm1 : b left minus 1 , b[bl-1]
            // aleft : a k left , a[al]
            // bleft : b k left , b[bl]
            int alm1 = (al==0)? Integer.MIN_VALUE: a[al-1];
            int aleft = (al==a.length)? Integer.MAX_VALUE: a[al];
            int blm1 = (bl==0)? Integer.MIN_VALUE: b[bl-1];
            int bleft = (bl==b.length)? Integer.MAX_VALUE: b[bl];


            if( alm1<=bleft && blm1<=aleft){
                double ans;
                if(total%2==0){
                    ans=(Math.max(alm1,blm1) + Math.min(aleft,bleft))/2.0;
                }
                else{
                    ans=Math.max(alm1,blm1);
                }
                return ans;
            }
            else if(blm1>aleft){
                lo=al+1;
            }
            else if(alm1>bleft){
                hi=al-1;
            }
        }
        return -1;
    }
}