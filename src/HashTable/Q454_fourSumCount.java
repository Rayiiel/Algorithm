package HashTable;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: IIE
 * @name: Q454_fourSumCount
 * @Date: 2024/3/25
 */
public class Q454_fourSumCount {
    public static void main(String[] args) {

    }

    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int count=0;
        for (int i = 0; i <nums1.length ; i++) {
            for (int j = 0; j < nums2.length; j++) {
                Integer value = map.getOrDefault(nums1[i] + nums2[j], 0);
                map.put(nums1[i] + nums2[j],++value);
            }
        }
        for (int i = 0; i <nums3.length ; i++) {
            for (int j = 0; j < nums4.length; j++) {
                Integer value = map.getOrDefault(0-(nums3[i] + nums4[j]), 0);
                count+=value;
            }
        }
        return count;
    }
}
