package Spiral_Order;

import java.util.ArrayList;
import java.util.List;

public class Q54_spiralOrder {
    public static void main(String[] args) {
        int[][] matrix={{1,2},{3,4}};
        System.out.println(spiralOrder(matrix));
    }
    private static List<Integer> spiralOrder(int[][] matrix) {
        List lists=new ArrayList();
        //m行 n列的矩阵
        int m=matrix.length;
        int n=matrix[0].length;
        int offset=1;
        int count=0;
        int startx=0;
        int starty=0;
        while(m-offset>startx&&n-offset>starty){
            //实质上可以在每一个边界做以保障  while（true）然后你来想到底在哪一步可能会跳出这个循环
            for(int j=starty;j<n-offset;j++){
                lists.add(matrix[startx][j]);
                count++;
            }
            for(int i=startx;i<m-offset;i++){
                lists.add(matrix[i][n-offset]);
                count++;
            }
            for(int j=n-offset;j>starty;j--){
                lists.add(matrix[m-offset][j]);
                count++;
            }
            for(int i=m-offset;i>startx;i--){
                lists.add(matrix[i][starty]);
                count++;
            }
            startx++;
            starty++;
            offset++;
            if(m-offset==startx||n-offset==starty) break;
        }
        if(m-offset==startx){
            //只剩下一行
            for(int j=starty;j<=n-offset;j++){
                lists.add(matrix[startx][j]);
            }
        }else if(n-offset==starty){
            //只剩下一行
            for(int i=startx;i<=m-offset;i++){
                lists.add(matrix[i][starty]);
            }
        }

        return lists;
    }
}

