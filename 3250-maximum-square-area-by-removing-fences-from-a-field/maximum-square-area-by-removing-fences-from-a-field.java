class Solution {
    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {

        int[] x=new int[hFences.length+2];
        x[0]=1;
        for(int i=0; i<hFences.length; i++){
            x[i+1]=hFences[i];
        }
        x[hFences.length+1]=m;

        int[] y=new int[vFences.length+2];
        y[0]=1;
        for(int i=0; i<vFences.length; i++){
            y[i+1]=vFences[i];
        }
        y[vFences.length+1]=n;

        Arrays.sort(x);
        Arrays.sort(y);

        Set<Integer> st=new HashSet<>();
        for(int i=0; i<x.length; i++){
            for(int j=i+1; j<x.length; j++){
                int v=x[j]-x[i];
                st.add(v);
            }
        }

        int side=-1;
        for(int i=0; i<y.length; i++){
            for(int j=i+1; j<y.length; j++){
                int v=y[j]-y[i];
                
                if(st.contains(v)){
                    side=Math.max(side, v);
                }
            }
        }

        if(side==-1){
            return -1;
        }

        long area = 1L*side*side;

        return (int)(area % 1_000_000_007);
    }
}