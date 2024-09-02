package List_Node;

/**
 * @Author: IIE
 * @name: Q19_removenthfromend_
 * @Date: 2024/1/10
 * 删除倒数第n个节点
 */
public class Q19_removenthfromend_ {
    public static void main(String[] args) {

    }
}
class Solution3 {
    //普通方法两遍遍历删除
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //虚拟头结点
        ListNode visual = new ListNode(-1);
        visual.next=head;
        ListNode cur=visual;
        int sum=0,count=0;
        while(cur.next!=null){
            sum++;
            cur=cur.next;
        }
        cur=visual;
        //退出时指向的是前一个节点
        while(count<sum-n){
            count++;
            cur=cur.next;
        }
        ListNode temp=cur.next;
        cur.next=temp.next;

        return visual.next;
    }
}

class Solution2 {
    //双指针的方式删除
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //虚拟头结点
        ListNode dummy = new ListNode(-1);
        dummy.next=head;
        ListNode fast=dummy;
        ListNode slow=dummy;
        //fast指向最后一个节点结束
        while(fast.next!=null){
           fast=fast.next;
           n--;
           if(n<0){
               slow=slow.next;
           }
        }
        slow.next=slow.next.next;
        return dummy.next;
    }
}