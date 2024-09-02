package hot100;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author: IIE
 * @name: Q136_singleNumber
 * @Date: 2024/3/28
 */
public class Q136_singleNumber {
    public static void main(String[] args) {
        int[] nums={4,1,2,1,2};
        System.out.println(singleNumber(nums));
    }
    public static int singleNumber(int[] nums) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for (int i = 0; i <nums.length ; i++) {
            if(!(map.containsKey(nums[i]))){
                    map.put(nums[i],1);
                }else{
                    map.replace(nums[i],2);
            }
        }
        for (Integer i : map.keySet()) {
            Integer count = map.get(i);
            if (count == 1) {
                return i;
            }
        }
        return -1;




    }
}
