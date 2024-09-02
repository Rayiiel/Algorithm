package hot100;

/**
 * @Author: IIE
 * @name: Q74_searchMatrix
 * @Date: 2024/4/17
 */
public class Q74_searchMatrix {
    public static void main(String[] args) {
        int[][] matrix={{1}};
        searchMatrix(matrix,2);
    }
    public static boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length,n=matrix[0].length;
        int i;
        for(i=0;i<m;i++){
            if(matrix[i][n-1]>=target){
                break;
            }
        }
        for(int j=0;j<n;j++){
            if(matrix[i==m?m-1:i][j]==target){
                return true;
            }
        }
        return false;
    }
}
