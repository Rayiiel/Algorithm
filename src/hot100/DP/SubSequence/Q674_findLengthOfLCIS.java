package hot100.DP.SubSequence;

/**
 * @Author: IIE
 * @name: Q674_findLengthOfLCIS
 * @Date: 2024/5/19
 */
public class Q674_findLengthOfLCIS {
    public static void main(String[] args) {

    }
    public int findLengthOfLCIS(int[] nums){
        int[] dp=new int[nums.length-1];
        for (int i = 0; i < nums.length; i++) {
            dp[i]=1;
        }
        for (int i = 1; i <nums.length ; i++) {
            if(nums[i]>nums[i-1]){
                dp[i]=dp[i-1]+1;
            }
        }
        int maxF=1;
        for (int i = 0; i < nums.length; i++) {
            maxF=maxF>dp[i]?maxF:dp[i];
        }
        return maxF;
    }
}
