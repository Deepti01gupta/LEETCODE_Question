class Solution {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        
        Arrays.sort(hBars);
        Arrays.sort(vBars);

        int hx=find(hBars);
        int hy=find(vBars);

        int side=Math.min(hx,hy);

        return side*side;
    }

    public int find(int[] arr){
        int max=1;
        int cur=1;

        for(int i=1; i<arr.length; i++){

            if(arr[i]==arr[i-1]+1){
                cur++;
            }
            else{
                cur=1;
            }

            max=Math.max(cur,max);
        }

        return max+1;
    }
}