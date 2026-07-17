import java.util.*;

class Solution {
    public long numberOfSubarrays(int[] nums) {
        int n = nums.length;
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> freq = new HashMap<>();
        long ans = 0;

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                int idx = stack.pop();
                freq.put(nums[idx], freq.get(nums[idx]) - 1);
            }

            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
            ans += freq.get(nums[i]);
            stack.push(i);
        }
        return ans;
    }
}
