package hot100;

/**
 * @Author: IIE
 * @name: Q25_reverseKGroup
 * @Date: 2024/6/22
 */
public class Q25_reverseKGroup {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5};
        ListNode head=new ListNode(1);
        head.next=new ListNode(2);
        head.next.next=new ListNode(3);
        head.next.next.next=new ListNode(4);
        head.next.next.next.next=new ListNode(5);

        ListNode listNode = reverseKGroup(head,2);
        return;
    }
    public static ListNode reverseKGroup(ListNode head,int k){
        int count=k,flag=0;
        ListNode curNode=head,preTail=head;
        while(curNode!=null){
            count=k;
            ListNode groupHead=curNode;
            //1.选出k个节点
            while(count>1){
                if(curNode==null){
                    break;
                }
                curNode=curNode.next;
                count--;
            }
            if(curNode==null){
                preTail.next=groupHead;
                break;
            }
            ListNode groupTail=curNode;
            curNode=curNode.next;
            if(groupTail!=null){
                groupTail.next=null;
                //上一次的尾巴连接这次的头部
               ListNode[] result=reverseListNode(groupHead);
               groupHead=result[0];
               groupTail=result[1];
               if(flag==0){
                   head=groupHead;
                   flag=1;
               }else{
                   preTail.next=groupHead;
               }
                preTail=groupTail;
            }


        }

        //第一次的头部
        return head;
    }

    public  static ListNode[] reverseListNode(ListNode head){
        ListNode tail=head;
        ListNode preNode=null;
        ListNode curNode=head;
        while(curNode!=null){
            ListNode temp=curNode.next;
            curNode.next=preNode;
            preNode=curNode;
            curNode=temp;
        }
        return new ListNode[]{preNode,tail};
    }
}
