class Solution {
    public long subArrayRanges(int[] nums) {
        return findMAX(nums) - findMIN(nums);
    }
    public long findMAX(int[] arr){
        int n=arr.length;
        int[] nge=findNGE(arr);
        int[] pge=findPGE(arr);
        long ans=0;
        for(int i=0; i<n; i++){
            long left=i-pge[i];
            long right=nge[i]-i;
            ans += right * left * (long)arr[i];
        }
        return ans;
    }
    public long findMIN(int[] arr){
        int n=arr.length;
        int[] nse=findNSE(arr);
        int[] pse=findPSE(arr);
        long ans=0;
        for(int i=0; i<n; i++){
            long left=i-pse[i];
            long right=nse[i]-i;
            ans += right * left * (long)arr[i];
        }
        return ans;
    }
    public int[] findNGE(int[] arr){
        int n=arr.length;
        int[] ans=new int[n];
        Stack<Integer> st=new Stack<>();
        for(int i=n-1; i>=0; i--){
            while(!st.isEmpty() && arr[st.peek()]<=arr[i]){
                st.pop();
            }
            ans[i]=(st.isEmpty())? n:st.peek();
            st.push(i);
        }
        return ans;
    }
    public int[] findPGE(int[] arr){
        int n=arr.length;
        int[] ans=new int[n];
        Stack<Integer> st=new Stack<>();
        for(int i=0; i<n; i++){
            while(!st.isEmpty() && arr[st.peek()]<arr[i]){
                st.pop();
            }
            ans[i]=(st.isEmpty())? -1:st.peek();
            st.push(i);
        }
        return ans;
    }
    public int[] findNSE(int[] arr){
        int n=arr.length;
        int[] ans=new int[n];
        Stack<Integer> st=new Stack<>();
        for(int i=n-1; i>=0; i--){
            while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
                st.pop();
            }
            ans[i]=(st.isEmpty())? n:st.peek();
            st.push(i);
        }
        return ans;
    }
    public int[] findPSE(int[] arr){
        int n=arr.length;
        int[] ans=new int[n];
        Stack<Integer> st=new Stack<>();
        for(int i=0; i<n; i++){
            while(!st.isEmpty() && arr[st.peek()]>arr[i]){
                st.pop();
            }
            ans[i]=(st.isEmpty())? -1:st.peek();
            st.push(i);
        }
        return ans;
    }

    
}