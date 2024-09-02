package hot100.DP;

/**
 * @Author: IIE
 * @name: Q198_rob
 * @Date: 2024/5/17
 */
public class Q198_rob {
    public static void main(String[] args) {

    }
    public int rob(int[] nums){
        if(nums.length==1){
            return nums[0];
        }else if(nums.length==2){
            return Math.max(nums[0],nums[1]);
        }
        int dp[]=new int[nums.length-1];
        dp[0]=nums[0];
        dp[1]=Math.max(nums[0],nums[1]);
        for(int i=2;i<nums.length-1;i++){
            dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i]);
        }

        int dp1=dp[nums.length-2];
        int dp2[]=new int[nums.length-1];
        dp2[0]=nums[1];
        dp[2]=Math.max(nums[1],nums[2]);
        for(int i=2;i<nums.length;i++){
            dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i+1]);
        }

        return Math.max(dp1,dp2[nums.length-1]);
    }
}
