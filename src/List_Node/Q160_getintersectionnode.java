package List_Node;

/**
 * @Author: IIE
 * @name: Q160_getintersectionnode
 * @Date: 2024/1/13
 */
public class Q160_getintersectionnode {
    public static void main(String[] args) {

    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pA=headA;
        ListNode pB=headB;
        if(pA==null||pB==null){
            return null;
        }
        while(pA!=pB){
            pA=pA==null?pA.next:headB;
            pB=pB==null?pB.next:headA;
        }
        return pA;
    }

}
//节点结构
//class ListNode {
//    int val;
//    ListNode next;
//    ListNode() {}
//    ListNode(int val) { this.val = val; }
//    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//}