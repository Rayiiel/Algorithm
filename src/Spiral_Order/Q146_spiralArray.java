package Spiral_Order;

public class Q146_spiralArray {
    public static void main(String[] args) {
        int[][] array={{1,2,3},{8,9,4},{7,6,5}};
        int[] result=spiralArray(array);
        for (int i = 0; i <result.length ; i++) {
            System.out.println(result[i]);
        }
    }
    private static int[] spiralArray(int[][] array){
        //空数组判断
        if(array.length==0){
            int[] result={};
            return result ;
        }
        int m=array.length,n=array[0].length,startx=0,starty=0;
        int count=0,offset=1;
        int[] result=new int[m*n];
        while(startx<m-offset&&starty<n-offset){
            for(int j=starty;j<n-offset;j++){
                result[count++]=array[startx][j];
            }
            for(int i=startx;i<m-offset;i++){
                result[count++]=array[i][n-offset];
            }
            for (int j = n-offset; j >starty ; j--) {
                result[count++]=array[m-offset][j];
            }
            for (int i = m-offset; i >startx ; i--) {
                result[count++]=array[i][starty];
            }
            offset++;
            startx++;
            starty++;
        }
        if(startx==m-offset){
            //只剩一行了
            for(int j=starty;j<=n-offset;j++){
                result[count++]=array[startx][j];
            }
        }else if(starty==n-offset){
            for(int i=startx;i<=m-offset;i++){
                result[count++]=array[i][n-offset];
            }
        }
        return result;
    }
}
