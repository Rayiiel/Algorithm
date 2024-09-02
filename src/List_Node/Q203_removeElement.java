package List_Node;

public class Q203_removeElement {
    public static void main(String[] args) {

    }
    private static ListNode removeElements(ListNode head, int val) {
        if(head==null){
            return head;
        }
        //设置前置节点
        ListNode dump=new ListNode(-1,head);
        ListNode pre=dump;
        ListNode cur=head;
        while(cur!=null){
            if(cur.val==val){
                pre.next=cur.next;
            }else{
                pre=cur;
            }
            cur=cur.next;
        }
        return dump.next;
    }
}
class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
