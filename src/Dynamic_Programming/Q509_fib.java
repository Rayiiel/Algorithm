package Dynamic_Programming;

/**
 * @Author: IIE
 * @name: Q509_fib
 * @Date: 2024/5/14
 */
public class Q509_fib {
    public static void main(String[] args) {

    }

    public int fib(int n){
        //1.创建dp数组
        int[] dp=new int[n];
        //2.初始化dp数组
        dp[0]=0;dp[1]=1;
        //3.遍历
        for(int i=2;i<n;i++){
            //4.递推公式
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n-1];
    }
}
