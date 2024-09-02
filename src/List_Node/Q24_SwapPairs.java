package List_Node;

import jdk.nashorn.internal.ir.CallNode;

/**
 * @Author: IIE
 * @name: SwapPairs
 * @Date: 2024/1/9
 */
public class Q24_SwapPairs {
    public static void main(String[] args) {

    }
}

class Solution4 {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next=head;
        ListNode left=head;
        ListNode cur=dummy;
        while(cur.next!=null||cur.next.next!=null){
            //交换数值
            cur.next=cur.next.next;
            left.next.next=left;
            cur=cur.next.next;
            left=cur.next;
        }

        return dummy.next;
    }
}