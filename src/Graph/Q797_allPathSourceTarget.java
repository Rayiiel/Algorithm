package Graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @Author: IIE
 * @name: Q797_allPathSourceTarget
 * @Date: 2024/6/7
 */
public class Q797_allPathSourceTarget {
}

class Solution {
    //递归和回溯都应该使用栈
    List<List<Integer>> result=new ArrayList<>();
    Deque<Integer> stack = new ArrayDeque<Integer>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        stack.offerLast(0);
        getPath(0,graph);
        return result;
    }
    public void getPath(int index,int[][] graph){
        if(index==graph.length-1){
            List<Integer> list=new ArrayList<Integer>(stack);
            result.add(list);
            return;
        }
        for(int i=0;i<graph[index].length;i++){
            stack.offerLast(graph[index][i]);
            getPath(graph[index][i],graph);
            stack.pollLast();
        }
    }
}