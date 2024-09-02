package hot100.DP;

/**
 * @Author: IIE
 * @name: Q322_coinChange
 * @Date: 2024/5/16
 */
public class Q322_coinChange {
    public static void main(String[] args) {

    }
    public int coinChange(int[] coins,int amount){
        //1.创建数组并进行初始化
        int[] dp=new int[amount+1];
        dp[0]=0;
        for (int i = 1; i <dp.length ; i++) {
            dp[i]=Integer.MAX_VALUE;
        }
        //两层for循环
        for (int i = 0; i <coins.length ; i++) {
            for (int j = coins[i]; j <=amount ; j++) {
                //求一共多少种方法，需要将他们都相加;求装满的最大价值或者最小价值，就是Max、Min的问题
                //任何情况都需要考虑越界问题
                if(dp[j-coins[i]]!=Integer.MAX_VALUE){
                    dp[j]=Math.min(dp[j],dp[j-coins[i]]+1);
                }
            }
        }
        if(dp[amount]==Integer.MAX_VALUE){
            return -1;
        }
        return dp[amount];
    }
}
