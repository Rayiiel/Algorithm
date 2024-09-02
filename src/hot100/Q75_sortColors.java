package hot100;

/**
 * @Author: IIE
 * @name: Q75_sortColors
 * @Date: 2024/5/15
 */
public class Q75_sortColors {
    public static void main(String[] args) {

    }
    public void sortColors(int[] nums){
        //[0,p0)==0,[p0,i)==1,(p2,length-1]==2;
        int p0=0,i=0,p2=nums.length-1;
        while(i<=p2){
            if(nums[i]==0){
                //换回来的数字一定是1，所以要i++;
                swap(nums,i,p0);
                p0++;
                i++;
            }else if(nums[i]==1){
                i++;
            }else{
                //此时换回来的数字还不知道，所以不需要i++;
                swap(nums,i,p2);
                p2--;
            }
        }
    }

    public void swap(int[] nums,int m,int n){
        int temp= nums[m];
        nums[m]=nums[n];
        nums[n]=temp;
    }
}
