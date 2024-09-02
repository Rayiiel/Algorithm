package Graph;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @Author: IIE
 * @name: Q994_orangeRotting
 * @Date: 2024/6/9
 */
public class Q994_orangeRotting {
    public static void main(String[] args) {
        int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};
        System.out.println(orangeRotting(grid));
    }
    public static int orangeRotting(int[][] grid){
        int m=grid.length,n=grid[0].length,cnt=0,minMin=0,flag=0;
        Queue<int[]> queue=new ArrayDeque<>();
        int[] curNode=new int[2];
        int[] nextNode=new int[2];
        //计算新鲜橘子的数量
        for (int i = 0; i < m ; i++) {
            for (int j = 0; j <n ; j++) {
                if(grid[i][j]==1){
                    cnt++;
                }else if(grid[i][j]==2){
                    curNode[0]=i;
                    curNode[1]=j;
                    queue.offer(new int[]{curNode[0],curNode[1]});
                }
            }
        }
        int[][] dir={{1,0},{-1,0},{0,1},{0,-1}};
        while(!queue.isEmpty()){
            //size参数表示这一层的节点，depth表示这一层有没有继续腐烂下一个
            int size=queue.size();
            flag=0;
            while(size>0){
                curNode=queue.poll();
                size--;
                for(int i=0;i<4;i++){
                    nextNode[0]=curNode[0]+dir[i][0];
                    nextNode[1]=curNode[1]+dir[i][1];
                    if(nextNode[0]<m&&nextNode[0]>=0&&nextNode[1]>=0&&nextNode[1]<n&&grid[nextNode[0]][nextNode[1]]==1){
                        cnt--;
                        grid[nextNode[0]][nextNode[1]]=2;
                        queue.offer(new int[]{nextNode[0],nextNode[1]});
                        flag=1;
                    }
                }
            }
            minMin+=flag;
        }
        if(cnt!=0){
            return -1;
        }
        return minMin;
    }

}
