package hot100;

/**
 * @Author: IIE
 * @name: Q240_searchMatrix
 * @Date: 2024/4/2
 */
public class Q240_searchMatrix {
    public static void main(String[] args) {

    }
    public boolean searchMatrix(int[][] matrix,int target){
        int m=0,n=matrix[0].length-1;
        int num=0;
        while(m<matrix.length&&n>=0){
            num=matrix[m][n];
            if(num==target){
                return true;
            }else if(num>target){
                n--;
            }else{
                m++;
            }
        }
        return false;
    }


}
