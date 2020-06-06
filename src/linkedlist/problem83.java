package linkedlist;

public class problem83 {

    public ListNode deleteDuplicates(ListNode head){
        if(head == null || head.next == null)return head;
        ListNode start=new ListNode(0);
        start.next=head;
        ListNode fast=start.next.next;
        ListNode slow=start.next;
        while (fast!=null){
            if (slow==fast){
                slow.next=slow.next.next;
            }
            slow=slow.next;
            fast=fast.next;
        }
        return start.next;

    }
    public ListNode deleteDuplicates1(ListNode head){
        ListNode current=head;
        while (current!=null&&current.next!=null){
            if (current.val==current.next.val){
                current.next=current.next.next;
            }else{
                current=current.next;
            }
        }
        return head;
    }


}

