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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null ){
            return null;
        }
        if(head.next == null){
            return head;
        }
        int size = 0;
        ListNode curr = head;
        while(curr != null){
            size++;
            curr = curr.next;
        }

        k = k%size;
        while(k-->0){
            head = reverse(head);
        }
        return head;

    }
    public ListNode reverse(ListNode head){
        ListNode curr = head;
        ListNode pre = null;
        while(curr.next != null){
            pre = curr;
            curr = curr.next;
        }
        pre.next = null;
        curr.next = head;
        head = curr;

        return head;

    }
}