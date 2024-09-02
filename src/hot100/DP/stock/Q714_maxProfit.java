package hot100.DP.stock;

/**
 * @Author: IIE
 * @name: Q714_maxProfit
 * @Date: 2024/5/18
 */
public class Q714_maxProfit {
    public int maxProfit(int[] prices,int fee){
        int[][] dp=new int[prices.length][2];
        dp[0][0]=-prices[0]-fee;
        dp[0][1]=0;
        for(int i=1;i<prices.length;i++){
            //1.持有这只股票
            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]-prices[i]-fee);
            //2.不持有这支股票
            dp[i][1]=Math.max(dp[i-1][1],dp[i-1][0]+prices[i]-fee);
        }
        return Math.max(dp[prices.length-1][0],dp[prices.length-1][1]);
    }
}
