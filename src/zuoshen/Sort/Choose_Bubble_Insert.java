package zuoshen.Sort;

/**
 * @Author: IIE
 * @name: Choose_Bubble_Insert
 * @Date: 2024/7/11
 */
public class Choose_Bubble_Insert {
    public static void main(String[] args) {
        int[] nums={12,343,21,11,2,3532,3};
        //choose(nums);
        //Bubble(nums);
        insert(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }
    //选择排序 i——n-1区间上元素的最小值放到nums[i]的位置上 区间的左侧
    public static void choose(int[] nums){
        int n=nums.length;
        for(int i=0;i<n;i++){
            int localMin=i;
            for(int j=i+1;j<n;j++){
                if(nums[j]<nums[localMin]){
                    localMin=j;
                }
            }
            swamp(nums,i,localMin);
        }
    }

    //冒泡排序
    public static void Bubble(int[] nums){
        int n=nums.length;
        //1.选定区间 未排序成功的区间 区间的右侧
        for(int i=n-1;i>0;i--){
            //2.开始从头遍历
            for(int j=0;j<i;j++){
                if(nums[j]>nums[j+1]) swamp(nums,j,j+1);
            }
        }
    }
    //插入排序 保证0-i区间的有序
    public static void insert(int[] nums){
        int n=nums.length;
        //1.先确定区间  已经有序的区间 区间的右侧
        for(int i=0;i<n-1;i++){
            //2.一点点插入保证数据数组的转移
            for(int j=i+1;j>0&&nums[j-1]>nums[j];j--){
                swamp(nums,j,j-1);
            }
        }

    }

    public static void swamp(int[] nums,int a,int b){
        int temp=nums[a];
        nums[a]=nums[b];
        nums[b]=temp;
    }
}
