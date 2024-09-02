package hot100;

/**
 * @Author: IIE
 * @name: Q148_sortList
 * @Date: 2024/4/8
 */
public class Q148_sortList {
    public static void main(String[] args) {

    }
    public static ListNode sortList(ListNode head){
        //递归的截止条件
        if(head==null || head.next==null){
            return head;
        }
        //寻找快慢指针
        ListNode slow=head;
        ListNode fast=head;
        while(fast.next!=null&&fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        //打断链表
        ListNode temp=slow.next;
        slow.next=null;
        ListNode left=sortList(head);
        ListNode right=sortList(temp);
        //记住头元素
        ListNode h=new ListNode(0);
        ListNode res=h;
        while(left!=null&&right!=null){
            if(left.val<right.val){
                h.next=left;
                left=left.next;
            }else{
                h.next=right;
                right=right.next;
            }
            h=h.next;
        }
        h.next=left==null?right:left;
        return res.next;
    }
}
