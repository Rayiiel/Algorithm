package zuoshen.Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * @Author: IIE
 * @name: Graph
 * @Date: 2024/8/14
 */
public class Graph {
    public HashMap<Integer,Node> nodes;
    public HashSet<Edge> edges;

    public Graph(){
        nodes=new HashMap<>();
        edges=new HashSet<>();
    }
}

class Node{
    //节点编号,出度、入度
    int value;
    int in,out;
    List<Node> nexts;
    List<Edge> edges;

    public Node(int value) {
        this.value = value;
        nexts = new ArrayList<Node>();
        edges = new ArrayList<Edge>();
        in=0;
        out=0;
    }
}

class Edge{
    int weight;
    Node from;
    Node to;

    public Edge(int weight, Node from, Node to) {
        this.weight = weight;
        this.from = from;
        this.to = to;
    }
}
