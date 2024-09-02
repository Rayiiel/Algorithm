package List_Node;

/**
 * @Author: IIE
 * @name: getintersectionnode
 * @Date: 2024/1/13
 *
 * 说明：相交不是数值相等，而是指针相同
 */
public class Q0207_getintersectionnode {
    public static void main(String[] args) {
        ListNode dummyNodeA=new ListNode(-1);
        ListNode dummyNodeB=new ListNode(-1);
        ListNode dummyNodeC=dummyNodeA;
        System.out.println(dummyNodeA==dummyNodeB);
        System.out.println(dummyNodeA.equals(dummyNodeB));
    }
    class Solution{
        public ListNode getIntersectionNode(ListNode headA,ListNode headB){

            ListNode dummyNodeA=new ListNode(-1);
            ListNode dummyNodeB=new ListNode(-1);

            dummyNodeA.next=headA;
            dummyNodeB.next=headB;

            ListNode curNodeA=dummyNodeA;
            ListNode curNodeB=dummyNodeB;

            ListNode result=null;
            int skipA=0;
            int skipB=0;

            for(skipA=0;curNodeB.next!=null;skipA++){
                for(skipB=0;curNodeA.next!=null;skipB++){
                    if(curNodeA.equals(curNodeB)){
                        result=curNodeA;
                        break;
                    }else{
                        curNodeA=curNodeA.next;
                    }
                }
                if (result != null) {
                   break;
                }else{
                    curNodeB=curNodeB.next;
                }
            }
            return result;
        }
    }
}
