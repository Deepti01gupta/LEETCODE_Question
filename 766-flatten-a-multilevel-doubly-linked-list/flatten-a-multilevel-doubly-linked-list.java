/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        Node cur=head;
        Stack<Node> st=new Stack<>();

        while(cur!=null){
            if(cur.child!=null){
                if(cur.next!=null){
                    st.push(cur.next);
                }

                cur.next=cur.child;
                cur.next.prev=cur;
                cur.child=null;
            }

            if(!st.isEmpty() && cur.next==null){
                Node nn=st.pop();
                cur.next=nn;
                nn.prev=cur;
            }

            cur=cur.next;
        }

        return head;
    }
}