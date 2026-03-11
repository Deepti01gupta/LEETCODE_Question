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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode cur=list1;

        while(a>1 && cur!=null){
            cur=cur.next;
            a--;
            b--;
        }

        ListNode temp=cur;
        while(b>=0 && temp!=null){
            temp=temp.next;
            b--;
        }

        cur.next=list2;

        ListNode tail=list2;
        while(tail.next!=null){
            tail=tail.next;
        }

        tail.next=temp;

        return list1;
        
    }
}