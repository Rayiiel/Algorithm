package RemoveElement;

public class Q977_sortedSquares {
    public static void main(String[] args) {
        int[] nums ={-2,0,2,3,4};
        for (int i = 0; i <nums.length ; i++) {
            System.out.println(nums[i]);
        }
        int[] newNums=sortedSquares(nums);
        for (int i = 0; i <newNums.length ; i++) {
            System.out.println(newNums[i]);
        }
    }

    private static int[] sortedSquares(int[] nums){
        int left=0;
        int right=nums.length-1;
        int[] result=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            if(nums[left]*nums[left]>nums[right]*nums[right]){
                result[nums.length-1-i]=nums[left]*nums[left];
                left++;
            }else if(nums[left]*nums[left]==nums[right]*nums[right]) {
                if(right==left){
                    result[nums.length-1-i] = nums[right] * nums[right];
                    break;
                }else{
                    result[nums.length-1-i] = nums[left] * nums[left];
                    left++;
                    i++;
                    result[nums.length-1-i] = nums[right] * nums[right];
                    right--;
                }

            }else{
                result[nums.length-1-i]=nums[right]*nums[right];
                right--;
            }
        }
        return result;
    }
}
