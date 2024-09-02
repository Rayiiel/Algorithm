package Dynamic_Programming;

/**
 * @Author: IIE
 * @name: Q63_uniquePathWithObstacles
 * @Date: 2024/5/14
 */
public class Q63_uniquePathWithObstacles {
    public static void main(String[] args) {

    }
    public int uniquePathWithObstacles(int[][] obstacleGrid){
        int m=obstacleGrid.length,n=obstacleGrid[0].length;
        int[][] dp=new int[m][n];
        if(obstacleGrid[0][0]==1||obstacleGrid[m][n]==1){
            return 0;
        }
        //初始胡dp数组，需要考虑障碍物的情况
        dp[0][0]=1;
        for (int i = 1; i <m && obstacleGrid[i][0]!=1 ; i++) {
            dp[i][0]=1;
        }
        for (int i = 1; i <n && obstacleGrid[0][i]!=1 ; i++) {
            dp[0][i]=1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j <n ; j++) {
                //否则有障碍物，默认为0
                if(obstacleGrid[i][j]!=1){
                    dp[i][j]=dp[i-1][j]+dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];
    }
}
