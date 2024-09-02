package hot100;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: IIE
 * @name: Q128_longestConsecutive
 * @Date: 2024/3/29
 */
public class Q128_longestConsecutive {
    public static void main(String[] args) {
        int[] nums={0,3,7,2,5,8,4,6,0,1};
        System.out.println(longsetConsecutive(nums));
    }
    public static int longsetConsecutive(int[] nums){
        Map<Integer, Integer> map = new HashMap<>();
        int max=1;
        for (int i = 0; i <nums.length ; i++) {
            map.put(nums[i],1);
        }
        for (int i = 0; i <nums.length ; i++) {
            int currentNum=nums[i];
            int currentStreak=1;
            while(map.containsKey(currentNum+1)){
                currentNum=currentNum+1;
                currentStreak=currentStreak+1;
            }
            max=Math.max(currentStreak,max);
        }
        return max;
    }
}
