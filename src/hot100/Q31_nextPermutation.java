package hot100;

/**
 * @Author: IIE
 * @name: Q31_nextPermutation
 * @Date: 2024/5/20
 */
public class Q31_nextPermutation {
    public static void main(String[] args) {

    }
    public void nextPermutation(int[] nums) {
        int begin=0,end=nums.length-1;
        for(int i=end;i>0;i--){
            if(nums[i-1]<nums[i]){
                begin=i-1;
                for(int j=end;j>begin;j--){
                    if(nums[j]>nums[begin]){
                        int temp=nums[j];
                        nums[j]=nums[begin];
                        nums[begin]=temp;
                        reverse(nums,i,end);
                        return ;
                    }
                }
            }
        }
        //如果没有在上述中翻转列表并返回
        reverse(nums,0,nums.length-1);
        return;
    }
    public void reverse(int[] nums,int begin,int end){
        while(begin<end){
            int temp=nums[begin];
            nums[begin]=nums[end];
            nums[end]=temp;
            begin++;
            end--;
        }
    }
}
