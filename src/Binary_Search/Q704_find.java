package Binary_Search;

public class Q704_find {
    public static void main(String[] args) {
        int[] nums={1,4,7,8,10};
        System.out.println(search(nums,7));
    }
    static public int search(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        while(left<=right){
            int middle=left+(right-left)/2;
            //***************************
            //这里的mid 每次需要加上left 的值
            if(target>nums[middle]){
                left=middle+1;
            }else if(target<nums[middle]){
                right=middle-1;
            }else{
                return middle;
            }
        }
        return -1;

    }

}

