package List_Node;

import sun.misc.LRUCache;

import java.util.HashMap;

/**
 * @Author: IIE
 * @name: Q146_LRUCahche
 * @Date: 2024/7/22
 */
public class Q146_LRUCache {
    private HashMap<Integer,DLinkedNode> cache;
    private DLinkedNode head;
    private DLinkedNode tail;
    private Integer capacity;
    private Integer size;

    public Q146_LRUCache(int capacity){
        cache=new HashMap<>();
        this.size=0;
        this.capacity=capacity;
    }

    //插入一个节点
    public void AddNewNode(int key,int value){
        DLinkedNode node = new DLinkedNode(value);
        if(size==0){
            this.head=node;
            this.tail=node;
        }else if(size<=capacity){
            node.pre=tail;
            tail.next=node;
            tail=tail.next;
        }
        size++;
        cache.put(key,node);
        if(size>capacity) RemoveNode(); //删除头节点
    }
    //删除头节点
    public void RemoveNode(){
        int headVal=head.val;
        head=head.next;
        cache.remove(headVal);
        if(head!=null) head.pre=null;
        size--;
    }

    //get函数
    public int get(int key){
        return cache.containsKey(key)?cache.get(key).val:-1;
    }

    //put函数
    public void put(int key,int value){
        if(cache.containsKey(key)){
            cache.get(key).val=value;
            cache.put(key, cache.get(key));
        }else{
            AddNewNode(key,value);
        }
    }
}

class DLinkedNode {
    DLinkedNode pre;
    DLinkedNode next;
    Integer val;
    DLinkedNode(){};
    DLinkedNode(Integer val){ this.val=val;}
}