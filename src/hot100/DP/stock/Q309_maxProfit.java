package hot100.DP.stock;

/**
 * @Author: IIE
 * @name: Q309_maxProfit
 * @Date: 2024/5/18
 * 含有冻结期的股票买卖交易
 * */
public class Q309_maxProfit {
    public static void main(String[] args) {

    }
    public int maxProfit(int[] prices,int fee){
        if(prices.length==1){
            return 0;
        }else if(prices.length==2){
            return Math.max(0,prices[1]-prices[0]);
        }
        int[][] dp=new int[prices.length][2];
        dp[0][0]=-prices[0];
        dp[0][1]=0;
        dp[1][0]=Math.max(-prices[0],-prices[1]);
        dp[1][1]=Math.max(0,prices[1]-prices[0]);
        for(int i=2;i<prices.length;i++){
            dp[i][0]=Math.max(dp[i-1][0],dp[i-2][1]-prices[i]);
            dp[i][1]=Math.max(dp[i-1][1],dp[i-1][0]+prices[i]);
        }
        return Math.max(dp[prices.length-1][0],dp[prices.length-1][1]);
    }
}
