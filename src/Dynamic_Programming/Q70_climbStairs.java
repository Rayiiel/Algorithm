package Dynamic_Programming;

/**
 * @Author: IIE
 * @name: Q70_climbStairs
 * @Date: 2024/5/14
 */
public class Q70_climbStairs {
    public static void main(String[] args) {

    }
    public int climbStairs(int n){
        if(n==1){
            return 1;
        }
        //1.确认dp数组  dp[i]表示爬到i+1层所需要的方式
        int[] dp=new int[n];
        //2.dp数组初始化
        dp[0]=1;dp[1]=2;
        for (int i = 2; i < n ; i++) {
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n-1];
    }
}
