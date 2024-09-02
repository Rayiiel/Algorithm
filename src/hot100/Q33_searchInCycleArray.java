package hot100;

/**
 * @Author: IIE
 * @name: Q33_searchInCycleArray
 * @Date: 2024/4/20
 */
public class Q33_searchInCycleArray {
    public static void main(String[] args) {

    }
    public int search(int[] nums,int target){
        int left=0;
        int right=nums.length-1;
        while (left<=right){
            int mid=left+(right-left)/2;
            if(nums[mid]==target){
                return mid;
            }else{
                //需要判断循环数组和升序数组是在左侧还是右侧
                if(nums[mid]>nums[right]){
                    //升序数组在左侧
                    //因为升序队列好控制
                    if(target>=nums[left]&&target<nums[mid]){   //如果在升序序列里，才这样
                        right=mid-1;
                    }else{
                        left=mid+1;
                    }
                }else{
                    //升序数组在右侧
                    if(nums[mid]<target&&nums[right]>=target){
                        left=mid+1;
                    }else{
                        right=mid-1;
                    }
                }
            }
        }
        return -1;
    }
}
