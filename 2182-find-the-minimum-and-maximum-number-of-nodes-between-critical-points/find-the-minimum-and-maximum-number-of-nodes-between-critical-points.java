/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        if (head == null || head.next == null || head.next.next == null)
            return new int[]{-1, -1};
        
        ListNode prev = head;
        ListNode curr = head.next;
        int index = 1;
        List<Integer> criticalIndices = new ArrayList<>();

        while (curr.next != null) {
            index++;
            int prevVal = prev.val;
            int currVal = curr.val;
            int nextVal = curr.next.val;

            // Check if curr is local minima or maxima
            if ((currVal > prevVal && currVal > nextVal) ||
                (currVal < prevVal && currVal < nextVal)) {
                criticalIndices.add(index);
            }

            prev = curr;
            curr = curr.next;
        }

        if (criticalIndices.size() < 2)
            return new int[]{-1, -1};

        int minDist = Integer.MAX_VALUE;
        for (int i = 1; i < criticalIndices.size(); i++) {
            minDist = Math.min(minDist, criticalIndices.get(i) - criticalIndices.get(i - 1));
        }

        int maxDist = criticalIndices.get(criticalIndices.size() - 1) - criticalIndices.get(0);

        return new int[]{minDist, maxDist};
    }
}