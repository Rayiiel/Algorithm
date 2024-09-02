package HashTable;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @Author: IIE
 * @name: Q1_twoSum
 * @Date: 2024/3/25
 */
public class Q1_twoSum {
    public static void main(String[] args) {
        int[] nums = {2,4,11,3};
        int[] ints = twoSum(nums, 6);
    }
    public static int[] twoSum(int[] nums, int target) {
        ArrayList<Object> arrayList = new ArrayList<>();
        for (int i = 0; i <nums.length ; i++) {
            arrayList.add(nums[i]);
        }
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (arrayList.contains(target - nums[i])) {
                result[0] = i;
                result[1] = arrayList.indexOf(target - nums[i]);
            }
        }
        return result;
    }

    public static int[] twoSum2(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i <nums.length ; i++) {
                if(map.containsKey(target-nums[i])){
                    return new int[]{map.get(target- nums[i]),i};
                } else{
                map.put(nums[i],i);
            }
        }
        return new int[0];
    }
}
