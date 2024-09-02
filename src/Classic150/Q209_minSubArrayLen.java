package Classic150;

import java.util.Arrays;

/**
 * @Author: IIE
 * @name: Q209_minSubArrayLen
 * @Date: 2024/7/7
 */
public class Q209_minSubArrayLen {

    public static void main(String[] args) {
        int[] nums={12,28,83,4,25,26,25,2,25,25,25,12};
        minSubArrayLen(213,nums);
    }
    public static int minSubArrayLen(int target, int[] nums) {
        Arrays.sort(nums);
        for(int i=1;i<=nums.length;i++){
            int sum=0;
            for(int j=0;j<i;j++){
                sum+=nums[nums.length-j-1];
            }
            if(sum>=target) return i;
        }
        return 0;
    }
}
