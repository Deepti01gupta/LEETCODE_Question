class Solution {
    public int minSwaps(int[] nums) {
        int n=nums.length;
        int[][] arr=new int[n][3];
        for(int i=0; i<n; i++){
            arr[i][0]=add(nums[i]);
            arr[i][1]=nums[i];
            arr[i][2]=i;
        }

        Arrays.sort(arr,(a,b)->{
            if(a[0]!=b[0])
                return Integer.compare(a[0],b[0]);
            return Integer.compare(a[1],b[1]);
        });

        int[] position=new int[n];
        for(int i=0; i<n; i++){
            position[arr[i][2]]=i;
        }

        boolean[] visited=new boolean[n];
        int swaps=0;

        for(int i=0; i<n; i++){
            if(visited[i] || position[i] == i ){
                continue;
            }

            int cyclesize=0;
            int j=i;
            while(!visited[j]){
                visited[j]=true;
                j=position[j];
                cyclesize++;
            }

            if(cyclesize>1){
                swaps+=(cyclesize-1);
            }
        }
        return swaps;
    }
    public int add(int n){
        int sum=0;
        while(n>0){
            int r=n%10;
            sum+=r;
            n=n/10;
        }
        return sum;
    }
}