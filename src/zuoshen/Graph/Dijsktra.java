package zuoshen.Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Author: IIE
 * @name: Dijsktra
 * @Date: 2024/8/14
 */
public class Dijsktra {
    public static void main(String[] args) {

    }

    public HashMap<Node,Integer> dijkstra2(Node head, int size){
        NodeHeap nodeHeap=new NodeHeap(size);
        nodeHeap.addOrUpdateOrIgnore(head,0);
        HashMap<Node,Integer> result=new HashMap<>();
        while(!nodeHeap.isEmpty()){
            NodeRecord record=nodeHeap.pop();
            Node cur=record.node;
            int dis=record.distance;
            for(Edge edge:cur.edges){
                nodeHeap.addOrUpdateOrIgnore(edge.to,edge.weight+dis);
            }
            result.put(cur,dis);
        }
        return result;
    }
}



class NodeRecord{
    Node node;
    Integer distance;

    public NodeRecord(Node node, Integer distance) {
        this.node = node;
        this.distance = distance;
    }
}
class NodeHeap{
    private Node[] nodes;
    private HashMap<Node,Integer> headIndexMap;
    private HashMap<Node,Integer> distanceMap;
    private int size;

    public NodeHeap(int size){
        nodes=new Node[size];
        headIndexMap=new HashMap<>();
        distanceMap=new HashMap<>();
        this.size=0;
    }

    public void addOrUpdateOrIgnore(Node node,int distance){
        if(inheap(node)){
            distanceMap.put(node,Math.min(distanceMap.get(node),distance));
            insertHeapify(node,headIndexMap.get(node));
        }
        if(!isEntered(node)){
            nodes[size]=node;
            headIndexMap.put(node,size);
            distanceMap.put(node,distance);
            insertHeapify(node,size++);
        }
    }
    //插入一个节点，不断向上调整
    public void insertHeapify(Node node,Integer index){
        while(index!=0 && distanceMap.get(nodes[index-1/2])>distanceMap.get(nodes[index])){
            swap(index-1/2,index);
            index=index-1/2;
        }
    }

    public void heapify(int index,int size){
        int left=index*2+1;
        while(left<size){
            int smallest=left+1<size && distanceMap.get(left+1)<distanceMap.get(left)?left+1:left;
            smallest=distanceMap.get(smallest)<distanceMap.get(index)?smallest:index;
            if(smallest==index) break;
            swap(smallest,index);
            index=smallest;
            left=index*2+1;
        }
    }
    public NodeRecord pop(){
        NodeRecord nodeRecord=new NodeRecord(nodes[0],distanceMap.get(nodes[0]));
        swap(0,size-1);
        headIndexMap.put(nodes[size-1],-1);
        distanceMap.remove(nodes[size-1]);
        nodes[size-1]=null;
        heapify(0,--size);
        return nodeRecord;
    }
    public boolean isEmpty(){
        return this.size==0;
    }

    public boolean isEntered(Node node){
        return this.headIndexMap.containsKey(node);
    }
    public boolean inheap(Node node){
        return isEntered(node)&&headIndexMap.get(node)!=-1;
    }
    public void swap(int index1,int index2){
        headIndexMap.put(nodes[index1],index2);
        headIndexMap.put(nodes[index2],index1);
        Node temp=nodes[index1];
        nodes[index1]=nodes[index2];
        nodes[index2]=temp;
    }
}

