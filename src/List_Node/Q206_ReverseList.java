package List_Node;

/**
 * @Author: IIE
 * @name: Q206_ReverseList
 * @Date: 2024/1/8
 */
public class Q206_ReverseList {
    public static void main(String[] args) {

    }

    class Solution {
        public ListNode reverseList(ListNode head) {
            //这种写法没有办法设置出头结点
            ListNode cur = head;
            ListNode temp = new ListNode();
            ListNode pre=null;
            while(cur!=null){
                temp=cur.next;
                cur.next=pre;
                pre=cur;
                cur=temp;
            }
            return temp;
        }
    }
    //递归的方法解决该问题
    class Solution2{
        public ListNode reverseList2(ListNode head) {
           return reverse(null,head);
            }
        public ListNode reverse(ListNode preNod,ListNode curNod){
            if(curNod==null){
                return preNod;
            }
            ListNode temp = new ListNode();
            temp=curNod.next;//先保存下一个节点
            curNod.next=preNod;//反转
            //下移节点时，前置节点指向curNod位置，curNod指向temp位置，pre和cur都后移
            return reverse(curNod,temp);
        }
    }
}
