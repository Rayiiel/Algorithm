package RemoveElement;

//简单
public class Q283_removeZero {
    public static void main(String[] args) {
        int[] nums={0,1,0,3,12,1};
        moveZeroes(nums);
        for (int i = 0; i <nums.length ; i++) {
            System.out.println(nums[i]);
        }
    }
    private static void moveZeroes(int[] nums){
        int slowIndex=0;
        for(int fastIndex=0;fastIndex<nums.length;fastIndex++){
            //slowIndex一定是处于前面的位置
            if(nums[fastIndex]!=0){
                nums[slowIndex++]=nums[fastIndex];
            }
        }
        //将后面的数值都赋值为0
        for(;slowIndex<nums.length;slowIndex++){
            nums[slowIndex]=0;
        }
    }
}
