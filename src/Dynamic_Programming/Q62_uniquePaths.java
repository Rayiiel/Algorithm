package Dynamic_Programming;

/**
 * @Author: IIE
 * @name: Q62_uniquePaths
 * @Date: 2024/5/14
 */
public class Q62_uniquePaths {
    public static void main(String[] args) {

    }
    public int uniquePaths(int m,int n){
        //dp[i][j] 走到i+1行，j+1列的路径有多少个
        int[][] dp=new int[m][n];
        dp[0][0]=1;
        //初始化，每行每列只有一种走法
        for (int i = 1; i <m ; i++) {
            dp[i][0]=1;
        }
        for (int i = 1; i <n ; i++) {
            dp[0][i]=1;
        }
        for (int i = 1; i <m ; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}
