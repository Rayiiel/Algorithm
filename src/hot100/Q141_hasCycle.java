package hot100;

/**
 * @Author: IIE
 * @name: Q141_hasCycle
 * @Date: 2024/4/2
 */
public class Q141_hasCycle {
    public static void main(String[] args) {

    }

    public boolean hasCycle(ListNode head) {
        ListNode newListNode=head,pre=null,curr=head;
        while(curr!=null){
            ListNode temp=curr.next;
            curr.next=pre;
            pre=curr;
            curr=temp;
        }
        if(pre==head){
            return true;
        }else{
            return false;
        }
    }
}
