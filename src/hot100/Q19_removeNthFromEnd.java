package hot100;

/**
 * @Author: IIE
 * @name: Q19_removeNthFromEnd
 * @Date: 2024/4/9
 * 虚拟头节点，一次遍历
 */
public class Q19_removeNthFromEnd {
    public static void main(String[] args) {

    }
    public ListNode removeNthFromEnd(ListNode head,int n){
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode slow=dummy;
        ListNode fast=dummy;
        while(fast!=null){
            fast=fast.next;
            n--;
            if(n<0){
                slow=slow.next;
            }
        }
        slow.next=slow.next.next;
        //有可能把头节点删掉
        return dummy.next;
    }
}
