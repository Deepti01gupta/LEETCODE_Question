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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans=new ListNode();
        ListNode dummy=ans;
        int cy=0;
        while( (l1!=null || l2!=null) || cy!=0){
            int v1=0;
            if(l1 != null){
                v1=l1.val;
                l1=l1.next;
            }

            int v2=0;
            if(l2 != null){
                v2=l2.val;
                l2=l2.next;
            }

            int sum=v1+v2+cy;
            cy=sum/10;
            ListNode temp=new ListNode(sum%10);
            ans.next=temp;
            ans=ans.next;
        }
        return dummy.next;
    }
}