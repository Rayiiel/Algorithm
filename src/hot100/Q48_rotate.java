package hot100;

/**
 * @Author: IIE
 * @name: Q48_rotate
 * @Date: 2024/4/1
 * 旋转图像：输入一个n*n的数组，将数组旋转90度，原地进行旋转
 */
public class Q48_rotate {
    public static void main(String[] args) {
        int[][] matrix={{1}};
        rotate(matrix);
        for(int i=0;i<1;i++){
            for(int j=0;j<1;j++){
                System.out.println(matrix[i][j]);
            }
        }
    }
    public static void rotate(int[][] matrix){
        int n=matrix.length,cycle=matrix.length/2;
        for(int i=0;i<cycle;i++){
            //j表示偏移量
            for(int j=0;j<n-2*i-1;j++){
                int temp=matrix[i][i+j];
                matrix[i][i+j]=matrix[n-i-1-j][i];
                matrix[n-i-1-j][i]=matrix[n-i-1][n-i-1-j];
                matrix[n-i-1][n-i-1-j]=matrix[i+j][n-i-1];
                matrix[i+j][n-i-1]=temp;
            }
        }
        return;
    }
}
