package Graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: IIE
 * @name: Q207_canFinish
 * @Date: 2024/6/11
 */
public class Q207_canFinish {
    public static void main(String[] args) {

    }
    public boolean canFinish(int numCourse,int[][] prerequisites){
        //广度优先搜索的方案
        //1.计算每一个节点的的入度
        List<List<Integer>> list=new ArrayList<>();
        int[] interNum=new int[numCourse];
        int count=0;
        for (int i = 0; i <numCourse ; i++) {
            list.add(new ArrayList<Integer>());
        }

        //list中每一个节点对应的列表是对应的指向的节点
        for (int[] pre : prerequisites) {
            list.get(pre[1]).add(pre[0]);
            interNum[pre[0]]++;
        }
        //2.入度为0的优先进入队列
        Queue<Integer> queue=new ArrayDeque<>();
        for (int i = 0; i < numCourse; i++) {
            if(interNum[i]==0){
                queue.offer(i);
            }
        }
        //3.出队列
        while(!queue.isEmpty()){
            //1.先修了该课程
            Integer q = queue.poll();
            count++;
            for (Integer integer : list.get(q)) {
                interNum[integer]--;
                if(interNum[integer]==0){
                    queue.offer(integer);
                }
            }
        }

        return count==numCourse;
    }
}
