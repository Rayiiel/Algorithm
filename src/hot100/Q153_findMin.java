package hot100;

/**
 * @Author: IIE
 * @name: Q153_findMin
 * @Date: 2024/4/19
 */
public class Q153_findMin {
    public static void main(String[] args) {
        int[] nums={3,4,5,1,2};
        System.out.println(findMin(nums));
    }
    public static int findMin(int[] nums){
        int left=0;
        int right=nums.length-1;
        int mid=left+(right-left)/2;;
        while(left<right){
            /**
             * 是不是取等号的问题：如果下下面是-1，+1，可以取等号，如果不是不能取可能造成死循环
             */
            mid=left+(right-left)/2;
            if(nums[mid]>nums[right]){
                //循环节点在右侧
                left=mid+1;
            }else{
                //循环节点在左侧
                /**
                 * 重点，是一定是还是可能是必须要区分清楚
                 */
                right=mid;
            }
        }

        return nums[left]<nums[right]?nums[left]:nums[right];
    }
}
