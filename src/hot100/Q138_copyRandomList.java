package hot100;

/**
 * @Author: IIE
 * @name: Q138_copyRandomList
 * @Date: 2024/4/8
 */
public class Q138_copyRandomList {
    public static void main(String[] args) {

    }
    public static Node copyRandomList(Node head){
        if(head==null){
            return null;
        }
        Node currNode=head;
        //将新链表与旧链表连接起来
        while(currNode!=null){
            Node temp=currNode.next;
            currNode.next=new Node(currNode.val);
            currNode.next.next=temp;
            currNode=temp;
        }
        Node currNode2=head;
        while(currNode2!=null){
            currNode2.next.random=currNode2.random.next;
            currNode2=currNode2.next.next;
        }
        //重点
        Node headNew = head.next;
        for (Node node = head; node != null; node = node.next) {
            Node nodeNew = node.next;
            node.next = node.next.next;
            nodeNew.next = (nodeNew.next != null) ? nodeNew.next.next : null;
        }
        return headNew;
        /**
        //这部分代码为什么错了
        Node newHead=head.next;
        Node newCurrHead=newHead;
        while(newCurrHead.next!=null){
            newCurrHead.next=newCurrHead.next.next;
            newCurrHead=newCurrHead.next==null;
        }
        return newHead;*/
    }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
