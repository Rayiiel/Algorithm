package hot100.DP;

/**
 * @Author: IIE
 * @name: Q416_canPartition
 * @Date: 2024/5/15
 */
public class Q416_canPartition {
    public static void main(String[] args) {

    }
    public boolean canPartition(int[] nums){
        int target=0;
        for (int i = 0; i <nums.length ; i++) {
            target+=nums[i];
        }
        if(target%2!=0){
            return false;
        }
        target=target/2;

        //计算重量为target的背包所能承受的最大价值。
        int[] dp=new int[target+1];
        for (int i = 0; i < nums.length; i++) {
            for(int j=target;j>=nums[i];j++){
                dp[j]=Math.max(dp[j],dp[j-nums[i]]+nums[i]);
            }
        }
        //装了几个的承重恰好等于11
        if(dp[target]==target){
            return true;
        }else{
            return false;
        }
    }
}
