package String;

import java.util.Arrays;

/**
 * @Author: IIE
 * @name: Q27_removeElement
 * @Date: 2024/3/28
 */
public class Q27_removeElement {
    public static void main(String[] args) {

    }
    public static int removeElement(int[] nums, int val) {
        Arrays.sort(nums);
        int count=0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]==val){
                count++;
                nums[i]=nums[nums.length-count];
                nums[nums.length-count]=val+1;
                i--;
            }
        }
        return nums.length-count;
    }
}
