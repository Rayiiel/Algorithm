package hot100;

import jdk.nashorn.internal.ir.CallNode;

import java.util.HashMap;

/**
 * @Author: IIE
 * @name: Q146_LRU
 * @Date: 2024/4/9
 * 创建LRU缓存--最近最少使用约束的数据结构
 */
public class Q146_LRU {
    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(1);
        lruCache.put(2,1);
        System.out.println(lruCache.get(2));

    }
}
//创建双向链表节点
class DLinkedNode{
    DLinkedNode pre;
    DLinkedNode next;
    int value;
    int key;
    public DLinkedNode(int key, int value) {
        this.value = value;
        this.key = key;
    }
    public DLinkedNode(){}
}
class LRUCache{
    private HashMap<Integer,DLinkedNode> cache=new HashMap<>();
    private DLinkedNode head;
    private DLinkedNode tail;
    private int capacity;
    private int size;

    public LRUCache(int capacity){
        this.capacity=capacity;
        this.head=new DLinkedNode();
        this.tail=new DLinkedNode();
        this.size=0;
        head.next=tail;
        tail.pre=head;
    }

    public int get(int key) {
        if(!cache.containsKey(key)){
            return -1;
        }else{
            //删除节点
            DLinkedNode node = cache.get(key);
            RemoveNode(node);
            AddNewHead(node);
            return node.value;
        }
    }
    public void put(int key,int value){
        DLinkedNode node = new DLinkedNode(key, value);
        //插入节点
        if(!cache.containsKey(key)){
            AddNewHead(node);
            cache.put(key,node);
            if(size>capacity){
                RemoveNode(tail);
                cache.remove(tail.key);
            }
            //更新节点
        }else{
            get(key);
            cache.get(key).value=value;
        }
    }

    public void RemoveNode(DLinkedNode node){
        //删除尾节点
        if(node.next==null){
            node.pre.next=null;
            tail=node.pre;
            node.pre=null;
        }else if(node.pre==null){
            node.next.pre=null;
            head=node.next;
            node.next=null;
        }else{
            node.pre.next=node.next;
            node.next.pre=node.pre;
            node.next=null;
            node.pre=null;
        }
        size--;
    }
    public void AddNewHead(DLinkedNode node){
        if(head==null){
            head=node;
            tail=node;
        }else{
            head.pre=node;
            node.next=head;
            head=node;
        }
        size++;
    }
}
