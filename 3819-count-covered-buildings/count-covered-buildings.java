import java.util.*;
class b{
    int mn=Integer.MAX_VALUE;
    int mx=Integer.MIN_VALUE;
}
class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {
        // Set<String> set=new HashSet<>();
        // for(int[] b: buildings){
        //     set.add(b[0]+","+b[1]);
        // }
        // int c=0;
        // for(int[] b:buildings){
        //     int x=b[0];
        //     int y=b[1];
        //     boolean up = false, down = false, left = false, right = false;
        //     for (int d = 1; d < n; d++) {
        //         if (set.contains((x - d) + "," + y)) up = true;
        //         if (set.contains((x + d) + "," + y)) down = true;
        //         if (set.contains(x + "," + (y - d))) left = true;
        //         if (set.contains(x + "," + (y + d))) right = true;
        //     }
        //     if (up && down && left && right) {
        //         c++;
        //     }
        // }
        // return c;

        Map<Integer, b> rowb=new HashMap<>();
        Map<Integer, b> colb=new HashMap<>();

        for(int[] arr: buildings){
            int x=arr[0];
            int y=arr[1];

            rowb.putIfAbsent(x,new b());
            b rb=rowb.get(x);
            rb.mn=Math.min(rb.mn,y);
            rb.mx=Math.max(rb.mx,y);

            colb.putIfAbsent(y,new b());
            b cb=colb.get(y);
            cb.mn=Math.min(cb.mn, x);
            cb.mx=Math.max(cb.mx, x);
            
        }
        int c=0;
        for(int[] arr:buildings){
            int x=arr[0];
            int y=arr[1];
            b rb=rowb.get(x);
            b cb=colb.get(y);

            if(rb.mn <y && y<rb.mx && cb.mn<x && x<cb.mx){
                c++;
            }
        }
        return c;
    }
}