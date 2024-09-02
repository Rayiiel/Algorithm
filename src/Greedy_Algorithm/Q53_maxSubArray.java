package Greedy_Algorithm;

/**
 * @Author: IIE
 * @name: Q53_maxSubArray
 * @Date: 2024/5/8
 */
public class Q53_maxSubArray {
    public static void main(String[] args) {

    }
    public int maxSubArray(int[] nums){
        int result=nums[0];
        int sum=0;
        for (int i = 0; i < nums.length; i++) {
            //计算当前局部和，记录数值
            sum=sum+nums[i];
            result=result>sum?result:sum;
            //当局部和小于0时，重新开始计数，0一定会在下一次迭代中被更新
            if(sum<0){
                sum=0;
            }
        }
        return result;
    }
}
