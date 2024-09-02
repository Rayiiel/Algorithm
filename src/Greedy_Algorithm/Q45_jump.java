package Greedy_Algorithm;

/**
 * @Author: IIE
 * @name: Q45_jump
 * @Date: 2024/5/29
 */
public class Q45_jump {
    public static void main(String[] args) {

    }
    public int jump(int[] nums){
        if(nums.length==1){
            return 0;
        }
        int curCover=0;
        int jump=0;
        int next=0;
        for (int i = 0; i <nums.length; i++) {
            next= Math.max(next,i+nums[i]);
            //当覆盖范围用完的时候再往前跳一步
            if(i==curCover){
                jump++;
                curCover=next;
                if(curCover>nums.length-1){
                    break;
                }
            }
        }
        return jump;
    }
}
