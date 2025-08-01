class Solution {
    public int matrixSum(int[][] nums) {

        int m = nums.length;
        int n = nums[0].length;
        for (int[] row : nums) {
            Arrays.sort(row);
        }
        int sum = 0;
        for (int j = 0; j < n; j++) {
            int max = 0;
            for (int i = 0; i < m; i++) {
                max = Math.max(max, nums[i][j]);
            }
            sum += max;
        }
        return sum;



        // int sum=0;
        // for(int j=0 ;j<nums[0].length; j++){
        //     int max=Integer.MIN_VALUE;
        //     for(int i=0; i<nums.length; i++){
        //         max=Math.max(max,nums[i][j]);
        //     }
        //     sum+=max;
        // }
        // return sum;
    }
}