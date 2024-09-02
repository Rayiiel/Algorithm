package hot100.DP;

import java.util.Arrays;

/**
 * @Author: IIE
 * @name: Q377_combinationSum4
 * @Date: 2024/5/16
 */
public class Q377_combinationSum4 {
    public static void main(String[] args) {

    }
    public int combinationSum4(int[] nums,int target){
        Arrays.sort(nums);
        int dp[]=new int[target+1];
        dp[0]=1;
        for (int j = 0; j <=target ; j++) {
            for (int i = 0; i <nums.length ; i++) {
                dp[j]+=dp[j-nums[i]];
            }
        }
        return dp[target];
    }
}
