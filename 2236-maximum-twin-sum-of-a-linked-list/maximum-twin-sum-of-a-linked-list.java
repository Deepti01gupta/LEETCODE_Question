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
    public int pairSum(ListNode head) {
        ListNode fast=head;
        ListNode slow=head;
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode right=reverse(slow.next);
        slow.next=null;
        ListNode left=head;
        int ans=0;
        while(left!=null && right!=null){
            int sum=left.val + right.val;
            ans=Math.max(ans,sum);
            left=left.next;
            right=right.next;
        }
        return ans;
    }

    public ListNode reverse(ListNode head){
        ListNode curr=head;
        ListNode prev=null;
        while(curr!=null){
            ListNode nn=curr.next;
            curr.next=prev;
            prev=curr;
            curr=nn;
        }
        return prev;
    }
}