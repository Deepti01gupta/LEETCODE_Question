class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        Stack<Integer> st=new Stack<>();
        for(int i:happiness){
            st.add(i);
        }

        long max=0;
        int c=0;
        while(k-- !=0 && !st.isEmpty()){
            int curr=st.pop();
            if((curr-c)>0){
                max+=(curr-c);
            }
            c++;
        }
        return max;
    }
}