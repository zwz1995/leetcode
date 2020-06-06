package linkedlist;

public class problem61 {
    //超出内存限制，出现错误--已改正
    public  ListNode rotateRight(ListNode head,int k){
        if (head==null) return null;
        ListNode dummy=new ListNode(0);
        ListNode count=new ListNode(0);
        dummy.next=head;
        count=head;
        int length=1;//求出链表长度,并将count标记为链尾节点
        while (count.next!=null){
            count=count.next;
            length++;
        }
        int l=k%length;
        int m=length-l;
        ListNode pre=dummy;
        for (int i=0;i<=l;i++) pre=pre.next;
        ListNode start=pre.next;
        count.next=dummy.next;
        dummy.next=start;
        pre.next=null;

        return dummy.next;
    }
    //最优题解，思路是一模一样的
    public ListNode rotateRight1(ListNode head, int n) {
        if (head==null||head.next==null) return head;
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode fast=dummy,slow=dummy;

        int i;
        for (i=0;fast.next!=null;i++)//Get the total length
            fast=fast.next;

        for (int j=i-n%i;j>0;j--) //Get the i-n%i th node
            slow=slow.next;

        fast.next=dummy.next; //Do the rotation
        dummy.next=slow.next;
        slow.next=null;

        return dummy.next;
    }
}
