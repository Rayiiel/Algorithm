package Dynamic_Programming;

/**
 * @Author: IIE
 * @name: Q746_minCostClimbingStairs
 * @Date: 2024/5/14
 */
public class Q746_minCostClimbingStairs {
    public static void main(String[] args) {

    }
    public int minCostClimbingStairs(int[] cost){
        int length=cost.length;
        //1.dp数组，dp[i]表示爬上i+1个台阶的最小费用
        int[] dp=new int[length+1];
        dp[0]=0;dp[1]=0;
        for (int i = 2; i <dp.length ; i++) {
            dp[i]=Math.min(dp[i-1]+cost[i-1],dp[i-2]+cost[i-2]);
        }
        return dp[length];
    }
}
