class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        Set<Integer> s1=new HashSet<>();
        Set<Integer> s2=new HashSet<>();
        int[] ans=new int[A.length];
        int k=0;
        for(int i=0; i<A.length; i++){
            s1.add(A[i]);
            s2.add(B[i]);
            if(A[i]==B[i]){
                k++;
            }
            else{
                if(s1.contains(B[i])){
                    k++;
                }
                if(s2.contains(A[i])){
                    k++;
                }
            }
            ans[i]=k;
        }
        return ans;
    }
}