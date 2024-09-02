package List_Node;

public class Q707_MyLinkedList {
    public static void main(String[] args) {

    }
}
class MyLinkedList {
    int size;
    Node head;

    //初始化链表
    public MyLinkedList() {
        size=0;
        head=new Node(0);  //当前节点数值为0，next为空，表示空节点
    }

    public int get(int index) {
    //查找
        if(index<0||index>=size){
            return -1;
        }
        //当前节点指向头结点
        Node cur=head;
        //未使用虚拟节点
        while(index>0){
            cur=cur.next;
            index--;
        }
        return cur.val;
    }

    public void addAtHead(int val) {
    //增加
        addAtIndex(0, val);
        size++;
    }

    public void addAtTail(int val) {
    //增加
        addAtIndex(size, val);
        size++;
    }

    public void addAtIndex(int index, int val) {
    //增加
        if(index>size||index<0){
            return;
        }
        //创建新节点
        Node newNode=new Node(val);
        //添加虚拟节点
        Node cur=new Node();
        cur.next=head;

        while(index>0){
            cur=cur.next;
            index--;
        }
        newNode.next=cur.next;
        cur.next=newNode;
        size++;
    }

    public void deleteAtIndex(int index) {
    //删除
        if(index>size||index<0){
            return;
        }
        //添加虚拟节点
        Node cur=new Node();
        cur.next=head;

        while(index>0){
            cur=cur.next;
            index--;
        }
        cur.next=cur.next.next;
        size--;
    }
}
//单链表--节点形式
class Node{
    int val;
    Node next;
    Node() {}
    Node(int val) {
        this.val = val;
    }
}