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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq=new PriorityQueue<>(new Comparator<ListNode>(){
            @Override
            public int compare(ListNode l1, ListNode l2){
                return l1.val-l2.val;
            }
        });

        for(int i=0; i<lists.length; i++){
            if(lists[i]!=null){
                pq.add(lists[i]);
            }
        }

        ListNode dummy=new ListNode();
        ListNode cur=dummy;
        while(!pq.isEmpty()){
            ListNode nn=pq.poll();
            cur.next=nn;
            cur=cur.next;

            if(nn.next!=null){
                pq.add(nn.next);
            }
        }

        return dummy.next;
    }
}