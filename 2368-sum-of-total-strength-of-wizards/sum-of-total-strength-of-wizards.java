class Solution {
    static final int mod=1_000_000_007;
    
    public int totalStrength(int[] strength) {
        int n=strength.length;

        int[] prefix=new int[n+1];
        for(int i=0; i<n; i++){
            prefix[i+1]=(prefix[i]+strength[i])%mod;
        }

        int[] prefixprefix=new int[n+2];
        for(int i=0; i<=n; i++){
            prefixprefix[i+1]=(prefixprefix[i]+prefix[i])%mod;
        }

        int[] left=new int[n];
        Stack<Integer> st=new Stack<>();
        for(int i=0; i<n; i++){
            while(!st.isEmpty() && strength[st.peek()]>=strength[i]){
                st.pop();
            }
            left[i]=st.isEmpty()? -1:st.peek();
            st.push(i);
        }

        int[] right=new int[n];
        st.clear();
        for(int i=n-1; i>=0; i--){
            while(!st.isEmpty() && strength[st.peek()]>strength[i]){
                st.pop();
            }
            right[i]=st.isEmpty()? n:st.peek();
            st.push(i);
        }

        long ans=0;
        for(int i=0; i<n; i++){
            int l=left[i], r=right[i];

            long leftsum=(prefixprefix[i+1]-prefixprefix[l+1]+mod)%mod;
            long rightsum=(prefixprefix[r+1]-prefixprefix[i+1]+mod)%mod;

            long leftcount=i-l;
            long rightcount=r-i;

            long total=((rightsum*leftcount)%mod - (leftsum*rightcount)%mod + mod)%mod;

            ans=(ans+total*strength[i])%mod;
        }

        return (int)ans;
    }
}