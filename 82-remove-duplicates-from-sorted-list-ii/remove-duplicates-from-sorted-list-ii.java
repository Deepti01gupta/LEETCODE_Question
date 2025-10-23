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
    public ListNode deleteDuplicates(ListNode head) {
        Map<Integer,Integer> mp=new HashMap<>();
        ListNode curr=head;
        while(curr!=null){
            mp.put(curr.val,mp.getOrDefault(curr.val,0)+1);
            curr=curr.next;
        }
        ListNode dummy=new ListNode();
        curr=dummy;
        while(head!=null){
            if(mp.get(head.val)== 1){
                curr.next=head;
                curr=curr.next;
            }
            head=head.next;
        }
        curr.next=null;
        return dummy.next;
    }
}