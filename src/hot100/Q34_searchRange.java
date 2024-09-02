package hot100;

/**
 * @Author: IIE
 * @name: Q34_searchRange
 * @Date: 2024/4/19
 */
public class Q34_searchRange {
    public static void main(String[] args) {
        int[] nums={5,7,7,8,8,10};
        int[] result = searchRange(nums, 8);
        System.out.println(result[0]);
        System.out.println(result[1]);
    }

    public static int[] searchRange(int[] nums,int target){
        int[] result=new int[2];
        int left=0;
        int right=nums.length;
        result[0]=findFirstIndex(nums,target,left,right);
        result[1]=findSecondIndex(nums,target,left,right);
        return result;

    }
    public static int findFirstIndex(int[] nums,int target,int left,int right){
        int flag=-1;
        while(left<=right){
            int mid=left+right/2;
            if(nums[mid]>target){
                right=mid-1;
            }else if(nums[mid]<target){
                left=mid+1;
            }else{
               right=mid-1;
               flag=0;
            }
        }
        if(flag==0){
            return left;
        }else{
            return -1;
        }

    }
    public static int findSecondIndex(int[] nums,int target,int left,int right){
        int flag=-1;
        while(left<=right){
            int mid=left+right/2;
            if(nums[mid]>target){
                right=mid-1;
            }else if(nums[mid]<target){
                left=mid+1;
            }else{
                left=mid+1;
            }
        }
        if(flag==0){
            return left;
        }else{
            return -1;
        }
    }
}
