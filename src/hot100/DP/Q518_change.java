package hot100.DP;

/**
 * @Author: IIE
 * @name: Q518_change
 * @Date: 2024/5/15
 */
public class Q518_change {
    public static void main(String[] args) {

    }
    public int change(int amount,int[] coins){
        //1.dp[j]是j块钱有多少种兑换方式
        int[] dp=new int[amount+1];
        dp[0]=1;
        for (int i = 0; i <coins.length ; i++) {
            for (int j = coins[i]; j <=amount ; j++) {
                dp[j]+=dp[j-coins[i]];
            }
        }
        return dp[amount];
    }
}
