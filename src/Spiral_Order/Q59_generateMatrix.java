package Spiral_Order;

import java.util.ArrayList;
import java.util.List;

public class Q59_generateMatrix {
    public static void main(String[] args) {
       int[][] matrix={{1,2,3},{4,5,6},{7,8,9}};
        List list=spiralOrder(matrix);
        System.out.println(list);
    }
    private static List<Integer> spiralOrder(int[][] matrix) {
        List list=new ArrayList();
        int startx=0;
        int starty=0;
        int offset=1;
        int n=matrix.length;
        int cycle=n/2;
        int count=1;
        while(cycle>0){
            for(int j=startx;j<n-offset;j++){
                matrix[startx][j]=count++;
            }
            for(int i=starty;i<n-offset;i++){
                matrix[i][n-offset]=count++;
            }
            for(int j=n-offset;j>startx;j--){
                matrix[n-offset][j]=count++;
            }
            for(int i=n-offset;i>starty;i--){
                matrix[i][starty]=count++;
            }
            startx++;
            starty++;
            cycle--;
            offset++;   //这里的偏移量也减少2
        }
        if(n*n%2!=0){
            matrix[n/2][n/2]=n*n;
        }
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j < n; j++) {
                list.add(matrix[i][j]);
            }
        }
        return list;

    }
}
