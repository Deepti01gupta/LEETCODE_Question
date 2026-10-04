class Solution {
    public int sumSubarrayMins(int[] arr) {
        int[] pse=previousSmallestElement(arr);
        int[] nse=nextSmallestElement(arr);
        long ans=0;
        int mod=1_000_000_007;
        for(int i=0; i<arr.length; i++){
            long left=i-pse[i];
            long right=nse[i]-i;
            ans=(ans + ((right*left) * arr[i])%mod)%mod;
        }
        return (int)ans;
    }
    public int[] previousSmallestElement(int[] arr){
        int[] ans=new int[arr.length];
        Stack<Integer> st=new Stack<>();
        for(int i=0; i<arr.length; i++){
            while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
                st.pop();
            }
            ans[i]=(st.isEmpty())? -1:st.peek();
            st.push(i);
        }
        return ans;
    }
    public int[] nextSmallestElement(int[] arr){
        int[] ans=new int[arr.length];
        Stack<Integer> st=new Stack<>();
        for(int i=arr.length-1; i>=0; i--){
            while(!st.isEmpty() && arr[st.peek()]>arr[i]){
                st.pop();
            }
            ans[i]=(st.isEmpty())? arr.length:st.peek();
            st.push(i);
        }
        return ans;
    }



    // public int sumSubarrayMins(int[] arr) {
    //     int sum=0;
    //     int MOD=1000000007;
    //     for(int i=0; i<arr.length; i++){
    //         int min=Integer.MAX_VALUE;
    //         for(int j=i; j<arr.length; j++){
    //             min=Math.min(min, arr[j]);
    //             sum+=min;
    //             if(sum>=MOD) sum-=MOD;
    //         }
    //     }
    //     return sum%MOD;
    // }
}