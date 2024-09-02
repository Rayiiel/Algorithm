package hot100;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: IIE
 * @name: Q560_subarraySum
 * @Date: 2024/3/30
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
 * 子数组是数组中元素的连续非空序列。
 * 解题思路：通过前缀和+两数相加的思路进行求解
 * pre[i]-pre[j]=k,即可
 */
public class Q560_subarraySum {
    public static void main(String[] args) {

    }
    public static int subarraySum(int[] nums,int k){
        //计算前缀和；这个数之前的所有数的和
        int pre=0;
        Map<Integer, Integer> map = new HashMap<>();
        int count=0;
        if(nums.length!=0){
            map.put(0,1);
        }
        for (int i = 0; i <nums.length ; i++) {
            pre=pre+nums[i];
            /**在之前的数组中查找是否有符合的选项；前缀理解前缀和*
             * 这三句的代码的顺序不能颠倒
             */
            count+=map.getOrDefault(pre-k,0);
            int value=map.getOrDefault(pre,0);
            map.put(pre,value++);
        }

        return count;
    }
}
