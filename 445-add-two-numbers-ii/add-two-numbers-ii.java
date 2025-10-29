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
        Stack<Integer> st1=new Stack<>();
        while(l1!=null){
            st1.push(l1.val);
            l1=l1.next;
        }
        Stack<Integer> st2=new Stack<>();
        while(l2!=null){
            st2.push(l2.val);
            l2=l2.next;
        }
        Stack<Integer> st=new Stack<>();
        int carry=0;
        while(!st1.isEmpty() && !st2.isEmpty()){
            int sum=st1.pop()+st2.pop()+carry;
            carry=sum/10;
            int v=sum%10;
            st.push(v);
        }
        while(!st1.isEmpty()){
            int sum=st1.pop()+carry;
            carry=sum/10;
            int v=sum%10;
            st.push(v);
        }
        while(!st2.isEmpty()){
            int sum=st2.pop()+carry;
            carry=sum/10;
            int v=sum%10;
            st.push(v);
        }
        ListNode dummy=new ListNode();
        ListNode curr=dummy;
        if(carry!=0){
            ListNode nn=new ListNode(carry);
            curr.next=nn;
            curr=curr.next;
        }
        while(!st.isEmpty()){
            ListNode nn=new ListNode(st.pop());
            curr.next=nn;
            curr=curr.next;
        }
        
        curr.next=null;
        return dummy.next;

    }
}