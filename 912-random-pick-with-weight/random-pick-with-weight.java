class Solution {

    private int[] prefixSum;
    private int totalSum;
    private Random random;

    public Solution(int[] w) {
        prefixSum = new int[w.length];
        prefixSum[0] = w[0];
        for (int i = 1; i < w.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + w[i];
        }
        totalSum = prefixSum[w.length - 1];
        random = new Random();
    }
    
    public int pickIndex() {
        int randWeight = random.nextInt(totalSum) + 1; // range [1, totalSum]
        int index = Arrays.binarySearch(prefixSum, randWeight);
        if (index < 0) {
            index = -index - 1;
        }
        return index;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
//  */