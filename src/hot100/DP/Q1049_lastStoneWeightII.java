package hot100.DP;

/**
 * @Author: IIE
 * @name: Q1049_lastStoneWeightII
 * @Date: 2024/5/15
 */
public class Q1049_lastStoneWeightII {
    public static void main(String[] args) {
        int[] stones={31,26,33,21,40};
        System.out.println(lastStoneWeightII(stones));
    }

    public  static int lastStoneWeightII(int[] stones){
        int sum=0;
        for (int i = 0; i <stones.length ; i++) {
            sum+=stones[i];
        }
        int target=sum/2;
        int[] dp=new int[target+1];
        for (int i = 0; i <stones.length ; i++) {
            for (int j = target; j >=stones[i]; j--) {
                dp[j]=Math.max(dp[j],dp[j-stones[i]]+stones[i]);
            }
        }
        return sum-dp[target]-dp[target];
    }
}
