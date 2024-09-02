package hot100.DP.stock;

/**
 * @Author: IIE
 * @name: Q122_maxProfix2
 * @Date: 2024/5/18
 */
public class Q122_maxProfix2 {
    public static void main(String[] args) {

    }
    public int mxProfix(int[] prices){
        int n=prices.length;
        int[][] dp=new int[n][2];
        dp[0][0]=-prices[0];
        dp[0][1]=0;
        for(int i=1;i<n;i++){
            dp[i][0]=Math.max(dp[i-1][1]-prices[i],dp[i-1][0]);
            dp[i][1]=Math.max(dp[i-1][1],dp[i-1][0]+prices[i]);
        }
        return Math.max(dp[n-1][0],dp[n-1][1]);
    }
}
