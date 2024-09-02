package HashTable;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: IIE
 * @name: Q349_intersection
 * @Date: 2024/3/22
 */
public class Q349_intersection {
    public static void main(String[] args) {
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2,1};
        int[] intersection = intersection(nums1, nums2);
        for (int i : intersection) {
            System.out.println(i);
        }

    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        HashSet hashSet = new HashSet<Integer>();
        Set result=new HashSet<Integer>();
        for (int i = 0; i <nums1.length ; i++) {
            hashSet.add(nums1[i]);
        }
        for (int i = 0; i <nums2.length ; i++) {
            if(hashSet.contains(nums2[i])){
                result.add(nums2[i]);
            }
        }

        Object[] objects = result.toArray();
        int[] ints = new int[result.size()];

        for (int i = 0; i < objects.length; i++) {
            ints[i]=(Integer)objects[i];
        }
        return ints;
        }

}
