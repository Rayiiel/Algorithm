package hot100.DP.SubSequence;

/**
 * @Author: IIE
 * @name: Q300_lengthOfLIS
 * @Date: 2024/5/18
 */
public class Q300_lengthOfLIS {
    public static void main(String[] args) {
        int[] nums={10,9,2,5,3,7,101,18};
        lengthOfLIS(nums);
    }
    public static int lengthOfLIS(int[] nums){
        int[] dp=new int[nums.length];
        for (int i = 0; i <nums.length ; i++) {
            dp[i]=1;
        }
        for(int i = 1;i<nums.length;i++){
            for (int j = 0; j < i ; j++) {
                if(nums[i]>nums[j]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }

            }
        }
        int result=1;
        for (int i = 1; i <nums.length ; i++) {
            result=Math.max(result,dp[i]);
        }
        return result;
    }
}
