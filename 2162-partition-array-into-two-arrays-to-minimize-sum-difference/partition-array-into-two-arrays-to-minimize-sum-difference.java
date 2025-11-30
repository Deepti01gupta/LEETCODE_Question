import java.util.*;

class Solution {

    private int solve(List<Integer> sum1, List<Integer> sum2, int tot) {
        int minDiff = Integer.MAX_VALUE;

        for (int x : sum1) {
            int target = tot / 2 - x;

            int lb = Collections.binarySearch(sum2, target);
            if (lb < 0) lb = -lb - 1;

            if (lb == sum2.size()) {
                minDiff = Math.min(minDiff, Math.abs(tot - 2 * (x + sum2.get(lb - 1))));
            } else if (lb == 0) {
                minDiff = Math.min(minDiff, Math.abs(tot - 2 * (x + sum2.get(lb))));
            } else {
                minDiff = Math.min(minDiff, Math.abs(tot - 2 * (x + sum2.get(lb - 1))));
                minDiff = Math.min(minDiff, Math.abs(tot - 2 * (x + sum2.get(lb))));
            }
        }

        return minDiff;
    }

    public int minimumDifference(int[] nums) {
        int n = nums.length / 2;
        int tot = 0;
        int[] nums1 = new int[n];
        int[] nums2 = new int[n];

        for (int i = 0; i < n; i++) {
            nums1[i] = nums[i];
            nums2[i] = nums[i + n];
            tot += nums[i] + nums[i + n];
        }

        List<Integer>[] sum1 = new ArrayList[n + 1];
        List<Integer>[] sum2 = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            sum1[i] = new ArrayList<>();
            sum2[i] = new ArrayList<>();
        }

        for (int mask = 0; mask < (1 << n); mask++) {
            int tot1 = 0, tot2 = 0, count = 0;
            for (int j = 0; j < n; j++) {
                if ((mask & (1 << j)) != 0) {
                    tot1 += nums1[j];
                    tot2 += nums2[j];
                    count++;
                }
            }
            sum1[count].add(tot1);
            sum2[count].add(tot2);
        }

        for (int i = 0; i <= n; i++) Collections.sort(sum2[i]);

        int minDiff = Integer.MAX_VALUE;

        for (int i = 0; i <= n; i++) {
            minDiff = Math.min(minDiff, solve(sum1[i], sum2[n - i], tot));
        }

        return minDiff;
    }
}
