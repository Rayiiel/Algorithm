package Dynamic_Programming;

/**
 * @Author: IIE
 * @name: Q96_numTress
 * @Date: 2024/5/14
 */
public class Q96_numTress {

    public int numTrees(int n){
        //1.创建dp数组
        int[] dp=new int[n+1];
        //2.初始化为0
        dp[0]=1;dp[1]=1;
        for(int i=2;i<=n;i++){
            for (int j = 1; j <=n ; j++) {
                //3.遍历和递推公式；这里是乘法
                dp[i]+=dp[j-1]*dp[i-j];
            }
        }
        return dp[n];
    }
}
