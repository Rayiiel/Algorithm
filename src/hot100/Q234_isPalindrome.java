package hot100;


/**
 * @Author: IIE
 * @name: Q234_isPalindrome
 * @Date: 2024/4/2
 */
public class Q234_isPalindrome {
    public static void main(String[] args) {

    }
    public boolean isPalindrome(ListNode head) {
        //求前半部分的尾节点
        ListNode firstHalfEnd=endOfFirstHalf(head);
        //翻转后半部分列表
        ListNode secondHalfBegin=reverseList(firstHalfEnd.next);

        ListNode headA=head;
        ListNode headB=secondHalfBegin;
        while(headB!=null){
            if(headA.val!=headB.val){
                return false;
            }
            headA=headA.next;
            headB=headB.next;
        }
        //还原链表
        ListNode listNode = reverseList(secondHalfBegin);
        firstHalfEnd.next=listNode;
        if(headA==secondHalfBegin){
            return true;
        }else{
            return false;
        }

    }
    public ListNode reverseList(ListNode head){
        ListNode prev=null;
        ListNode curr=head;
        while(curr!=null){
            // 每次记录前置节点和当前节点
            // 记录后面的节点；反转当前节点指向；
            // 前置节点后移，当前节点后移
            ListNode tempList=curr.next;
            curr.next=prev;
            prev=curr;
            curr=tempList;
        }
        return prev;
    }
    public ListNode endOfFirstHalf(ListNode head){
        ListNode slow=head;
        ListNode fast=head;
        while(fast.next!=null&&fast.next.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}