package hot100;

/**
 * @Author: IIE
 * @name: Q24_swapPairs
 * @Date: 2024/4/9
 * 虚拟节点是用来记住头节点的，因为头节点有可能被操作
 */
public class Q24_swapPairs {
    public static void main(String[] args) {

    }
    public static ListNode swapPairs(ListNode head){
        ListNode dummy=new ListNode(-1);
        ListNode pre=dummy;
        pre.next=head;
        while(pre.next!=null&&pre.next.next!=null){
            ListNode left=pre.next;
            ListNode right=pre.next.next;
            ListNode temp=right.next;
            pre.next=right;
            right.next=left;
            pre=left;
            pre.next=temp;
        }
        return dummy.next;
    }
}
