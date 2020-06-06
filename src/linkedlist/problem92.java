package linkedlist;

public class problem92 {
    //无法运行程序；
    public ListNode reverseBetween(ListNode head , int m,int n){
        ListNode newhead= head;
        int i=1;
        ListNode node_m_pre=null,node_m=null,node_n_pre=null,node_n=null;
        while (head!=null){
            if (i==m-1){
                node_m_pre=head;
            }
            if (i==m){
                node_m=head;
            }
            if(i==n-1){
                node_n_pre=head;
            }
            if(i==n){
                node_n=head;
            }
            head=head.next;
            i++;
        }
        ListNode temp =node_m;
        node_m.next=node_n.next;
        node_n.next=temp.next;
        node_m_pre.next=node_n;
        node_n_pre.next=node_m;
        return newhead;

    }

    //官方题解,将then插到pre和start中间就可以,then在不断的变化
    public ListNode reverseBetween1(ListNode head , int m,int n) {
        if (head == null) return null;
        ListNode dummy = new ListNode(0 ); // create a dummy node to mark the head of this list
        dummy.next = head;
        ListNode pre = dummy; // make a pointer pre as a marker for the node before reversing
        for (int i = 0; i < m - 1; i++) pre = pre.next;

        ListNode start = pre.next; // a pointer to the beginning of a sub-list that will be reversed
        ListNode then = start.next; // a pointer to a node that will be reversed

        // 1 - 2 -3 - 4 - 5 ; m=2; n =4 ---> pre = 1, start = 2, then = 3
        // dummy-> 1 -> 2 -> 3 -> 4 -> 5

        for (int i = 0; i < n - m; i++) {
            start.next = then.next;
            then.next = pre.next;
            pre.next = then;
            then = start.next;
        }

        // first reversing : dummy->1 - 3 - 2 - 4 - 5; pre = 1, start = 2, then = 4
        // second reversing: dummy->1 - 4 - 3 - 2 - 5; pre = 1, start = 2, then = 5 (finish)

        return dummy.next;
    }
}
