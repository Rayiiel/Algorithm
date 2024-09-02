package hot100.DP;

/**
 * @Author: IIE
 * @name: Q53_maxSubArray
 * @Date: 2024/5/19
 */
public class Q53_maxSubArray {
    public static void main(String[] args) {

    }
    public int maxSubArray(int[] nums){
        int ans=nums[0],maxF=nums[0],minF=nums[0];
        for (int i = 0; i <nums.length ; i++) {
            int mx=maxF,mn=minF;
            maxF=Math.max(nums[i],Math.max(mx+nums[0],mn+nums[0]));
            minF=Math.min(nums[i],Math.min(mx+nums[0],mn+nums[0]));
            ans=Math.max(ans,maxF);
        }
        return ans;

    }
}
