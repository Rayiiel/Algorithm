package hot100;

import java.util.concurrent.Semaphore;

/**
 * @Author: IIE
 * @name: Q35_searchInsert
 * @Date: 2024/4/9
 */
public class Q35_searchInsert {
    public static void main(String[] args) {

    }
    public static int searchInsert(int[] nums,int target){
        int left=0;
        int right=nums.length-1;
        while(left<right){
            int mid=left+(right-left)/2;
            if(nums[mid]>target){
                right=mid-1;
            }else if(nums[mid]<target){
                left=mid+1;
            }else{
                return mid;
            }
        }
        if(target>nums[left]){
            return ++left;
        }else{
            return left;
        }

    }

}
