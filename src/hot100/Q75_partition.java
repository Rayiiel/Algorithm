package hot100;

/**
 * @Author: IIE
 * @name: Q75_partition
 * @Date: 2024/3/29
 */
public class Q75_partition {
    public static void main(String[] args) {

    }

    public static void partition(int[] nums,int left,int right) {
        //left是从0开始的,right=length
        int index=0;          //用于记录坑的位置
        int value=nums[index];//基准值初始化

        while(left!=right){
            if (nums[--right]<value){
                nums[index]=nums[right];
                index=right;
            }
            if(nums[++left]>=value){
                nums[index]=nums[left];
                index=left;
            }
        }
    }
}
