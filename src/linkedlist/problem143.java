/*
package linkedlist;

public class problem143 {
    public void recorderList(ListNode head){
        if (head==null||head.next==null) return;
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode fast=dummy,slow=dummy;
        int i;
        for (i=0;fast.next!=null;i++){
            fast=fast.next;
        }
        int length=i;
        for(;i>length/2;i--)
            for (int j = 0; j < i - 1; j++) {
                ListNode sloww = dummy;
                sloww = sloww.next;
            }
        }

    }
    //找到中间点，断开，后半部分翻转，然后合并两个链表

    public void recorderList1(ListNode head){
        if (head==null||head.next==null||head.next.next==null) return;//直接return就可以
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode fast=dummy,slow=dummy;
        int i;
        for (i=0;fast.next!=null;i++) {
            fast = fast.next;
        }//计算总长度
        for (int j=i/2;j==0;j--){
            slow=slow.next;
        }
        ListNode newhead=slow.next;
        slow.next=null;
        ListNode newreverse=reverse(newhead);
        ListNode new2=dummy;
        while(newreverse.next==null&&head.next==null){
            if(i%2==0){
                new2.next=newreverse;
                newreverse=newreverse.next;
            }else{
                new2.next=head;
                head=head.next;
            }
        }


    }

    public ListNode reverse(ListNode head){//链表反转
            ListNode prev=null;
            ListNode next=null;
            while (head!=null){
                next=head.next;
                head.next=prev;
                prev=head;
                head=next;
            }
            return prev;
        }
    }
}
*/
