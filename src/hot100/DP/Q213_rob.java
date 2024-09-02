package hot100.DP;

/**
 * @Author: IIE
 * @name: Q213_rob
 * @Date: 2024/5/18
 */
public class Q213_rob {
    public static void main(String[] args) {
        int[] nums={1,2,3};
        System.out.println(rob(nums));
    }
    public static int rob(int[] nums){
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
//        if(nums.length==3){
//            return Math.max(dp[1],nums[2]);
//        }
        int dp1=dp[nums.length-2];
        int dp2[]=new int[nums.length-1];
        dp2[0]=nums[1];
        dp2[1]=Math.max(nums[1],nums[2]);
        for(int i=2;i<nums.length-1;i++){
            dp2[i]=Math.max(dp2[i-1],dp2[i-2]+nums[i+1]);
        }

        return Math.max(dp1,dp2[nums.length-2]);
    }
}
