package Dynamic_Programming;

/**
 * @Author: IIE
 * @name: Q343_integerBreak
 * @Date: 2024/5/14
 */
public class Q343_integerBreak {
    public static void main(String[] args) {
        System.out.println(integerBreak(10));
    }
    public static int integerBreak(int n){
        int[] dp=new int[n+1];
        dp[0]=1;dp[1]=1;
        for (int i = 2; i <= n ; i++) {
            for (int j = 1; j < i ; j++) {
                //两个数，两个数以上的数，取最大值
                int value=Math.max(j*dp[i-j],j*(i-j));
                dp[i]=Math.max(value,dp[i]);
            }
        }
        return dp[n];
    }
}
