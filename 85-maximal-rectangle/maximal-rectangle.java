class Solution {
    public int maximalRectangle(char[][] matrix) {
        int[] arr=new int[matrix[0].length];
        int ans=0;
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                arr[j]=(matrix[i][j]=='0')? 0:arr[j]+1;
            }
            int val=solve(arr);
            ans=Math.max(ans, val);
        }
        return ans;
    }
    public int solve(int[] arr){
        Stack<Integer> st=new Stack<>();
        int ans=0;
        int n=arr.length;
        for(int i=0; i<n; i++){
            while(!st.isEmpty() && arr[st.peek()]>arr[i]){
                int h=arr[st.pop()];
                int r=i;
                int l=(!st.isEmpty())? st.peek():-1;
                ans=Math.max(ans, h * (r-l-1));
            }
            st.push(i);
        }
        while(!st.isEmpty()){
            int h=arr[st.pop()];
            int r=n;
            int l=(!st.isEmpty())? st.peek():-1;
            ans=Math.max(ans, h * (r-l-1));
        }
        return ans;
    }
}