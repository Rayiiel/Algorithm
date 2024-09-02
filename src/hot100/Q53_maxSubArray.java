package hot100;

/**
 * @Author: IIE
 * @name: Q53_maxSubArray
 * @Date: 2024/3/31
 * 应该使用动态规划的方案
 */
public class Q53_maxSubArray {
    public static void main(String[] args) {
        int[] array={-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(array));
    }
    public static int maxSubArray(int[] nums){
        int max=nums[0];
        int left=0;
        for (; left<nums.length;) {
            int sum=nums[left];
            int right=++left;
            while(right<nums.length){
                sum+=nums[right];
                max=Math.max(max,sum);
                right++;
            }

        }
        return max;
    }
}
