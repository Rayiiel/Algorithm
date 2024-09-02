package hot100.DP.stock;

/**
 * @Author: IIE
 * @name: Q121_maxProfix
 * @Date: 2024/5/18
 * 买卖股票的最佳时机I
 */
public class Q121_maxProfix {
    public static void main(String[] args) {

    }
    public int maxProfix(int[] prices){
        int[][] dp=new int[prices.length][2];
        //0表示持有这支股票所得到的最大金额
        //1表示不持有这只股票所得到的最大金额
        dp[0][0]=-prices[0];
        dp[0][1]=0;
        for(int i=1;i<prices.length;i++){
            dp[i][0]=Math.max(dp[i-1][0],-prices[i]);
            dp[i][1]=Math.max(dp[i-1][1],dp[i-1][0]+prices[i]);
        }
        return Math.max(dp[prices.length-1][0],dp[prices.length][1]);
    }
}
