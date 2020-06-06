package linkedlist;

public class problem206 {
    public ListNode reverseList(ListNode head){
        ListNode current = head;
        while(current.next==null){
            current=current.next;
            ListNode temp = current;
            current.next=head;
            current=temp;
        }
        return head;
    }

   public ListNode reverseList1(ListNode head){
        if(head==null) return null;
        if(head.next==null) return head;
        ListNode p=reverseList(head.next);
        head.next.next=head;
        head.next=null;
        return p;
   }

   public ListNode reverseList2(ListNode head){
        if (head==null) return null;
        ListNode preHead=null;
        while(head!=null){
            ListNode next=head.next;
            head.next=preHead;
            preHead=head;
            head=next;
        }
        return preHead;
   }

}
