package Greedy_Algorithm;

/**
 * @Author: IIE
 * @name: Q376_wiggleMaxLength
 * @Date: 2024/5/8
 */
public class Q376_wiggleMaxLength {
    public static void main(String[] args) {

    }
    public int wiggleMaxLength(int[] nums){
        if(nums.length==1){
            return 1;
        }
        //定义上两个数的差值和当前两个数的超时，判断是否是数字跳跃
        int prediff=0;
        int curdiff=0;
        //进行结果计数
        int count=1;
        for (int i = 0; i <nums.length ; i++) {
            curdiff=nums[i+1]-nums[i];
            if(prediff<=0&&curdiff>0||prediff>=0&&curdiff<0){
                count++;
            }
        }
        return count;
    }
}
