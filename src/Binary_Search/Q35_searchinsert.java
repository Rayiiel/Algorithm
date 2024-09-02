package Binary_Search;


public class Q35_searchinsert {
    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        System.out.println(searchInsert(nums,2));

    }


    static public int searchInsert(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        int result=-1;

        while(left<=right){
            //以左边的数据作为基准的，最后是两个数在比较--left+1=right or right=left-1;
            int mid=left+(right-left)/2;
            if(target==nums[mid]){
                result=mid;
                break;
            }else if(target>nums[mid]){
                left=mid+1;
            }else{
                right=mid-1;
            }
            //结束之时，恰好二者相等，为插入的位置
            //结束的条件：left=right 或者left>right;
            if(left==right){
                if (right==nums.length-1){
                    result=right+1;
                }else {
                    result=left;
                }
            }
//            else if(left>right){
//                result=left;
//            }
        }

        return result;

    }

}
