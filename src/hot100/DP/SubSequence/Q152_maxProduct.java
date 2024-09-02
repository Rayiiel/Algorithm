package hot100.DP.SubSequence;

/**
 * @Author: IIE
 * @name: Q152_maxProduct
 * @Date: 2024/5/18
 */
public class Q152_maxProduct {
    public static void main(String[] args) {
        int[] nums={-2,0,-1};
        int i = maxProduct(nums);
        System.out.println(i);
    }
    public static int maxProduct(int[] nums){
        int ans=nums[0];
        int max=nums[0],min=nums[0];
        for (int i = 1; i <nums.length ; i++) {
            int mx=max,mn=min;
            max=Math.max(Math.max(nums[i],nums[i]*mx),nums[i]*mn);
            min=Math.min(Math.min(nums[i],nums[i]*mx),nums[i]*mn);
            ans=Math.min(max,ans);
        }
        return ans;
    }
}
