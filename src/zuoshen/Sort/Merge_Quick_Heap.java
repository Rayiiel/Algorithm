package zuoshen.Sort;

import java.util.Random;

/**
 * @Author: IIE
 * @name: Merge_Quick_Heap
 * @Date: 2024/7/16
 */
public class Merge_Quick_Heap {
    public static void main(String[] args) {
        /**
         *归并排序
         */
        //求归并排序
        int[] nums={12,343,21,11,2,3532,3,11,23,21,8};
        //mergeSort(nums,0,nums.length-1);
        //quickSort(nums,0,nums.length-1);
        heapSort(nums);
        for (int num : nums) {
            System.out.println(num);
        }
        //求小和问题
        int[] nums2={1,3,4,2,5};
        System.out.println(getSmallSum(nums2,0,4));

        /**
         * 快排
         */

    }

    /**
     * 归并排序及其练习
     * @param nums
     * @param L
     * @param R
     */
    public static void mergeSort(int[] nums,int L,int R){
        if(L==R) return;
        int mid=L+((R-L)>>2);
        mergeSort(nums,L,mid);       //拆分
        mergeSort(nums,mid+1,R);  //拆分
        merge(nums,L,mid,R);         //合并
    }

    private static void merge(int[] nums, int l, int mid, int r) {
        int[] help=new int[r-l+1];
        int p1=l,p2=mid+1,i=0;
        while(p1<=mid&&p2<=r){
            help[i++]=nums[p1]>nums[p2]?nums[p2++]:nums[p1++];
        }
        while(p1<=mid){
            help[i++]=nums[p1++];
        }
        while(p2<=r){
            help[i++]=nums[p2++];
        }
        for(int j=0;j<help.length;j++){
            nums[l+j]=help[j];
        }
    }

    //归并排序的改建：求左侧的数小于等于这些数的和的问题 【1，3，4，2，5】 如右侧有比它大的数字，则该数为小和贡献该值一次
    public static int getSmallSum(int[] nums,int L,int R){
        if(L==R) return 0;
        int mid=L+((R-L)>>2);
        return getSmallSum(nums,L,mid)+getSmallSum(nums,mid+1,R)+mergeSmall(nums,L,mid,R);
    }

    public static int mergeSmall(int[] nums,int L,int M,int R){
        int[] help=new int[R-L+1];
        int p1=L,p2=M+1,i=0,sum=0;
        while(p1<=M&&p2<=R){
            //多一次比较更耗时间

            //左侧part的数值小于右侧part的数值，那么就要贡献最小和，一次，由于我们每次小的part的都是排好序的，所以
            //贡献值是nums[p1]*(R-p2+1)

            //归并排序的思想就是找到小的数值，进行拷贝，而不管是最小和还是逆序对，都是在比较之后，再加一个步骤，求一个sum
            if(nums[p1]<nums[p2]){
                help[i++]=nums[p1];
                sum+=nums[p1]*(R-p2+1);
                p1++;
            }else{
                help[i++]=nums[p2++];
            }
        }
        while(p1<=M){
            help[i++]=nums[p1++];
        }
        while(p2<=R){
            help[i++]=nums[p2++];
        }
        for(int j=0;j<help.length;j++){
            nums[L+j]=help[j];
        }
        return sum;
    }

    /**
     * 快排
     * @param nums
     * @param L
     * @param R
     */
    public static void quickSort(int[] nums,int L,int R){
        if(L<R){
            //1.当前区间的partition
            int[] p=partition(nums,L,R);
            //2.左、右部分进行partition,这里一定要进行递归
            quickSort(nums,L,p[0]-1);
            quickSort(nums,p[1]+1,R);
        }
    }
    //荷兰国旗问题
    private static int[] partition(int[] nums, int l, int r) {
        //1.随机生成一个数字
        int num=l+new Random().nextInt(r-l+1);
        swap(nums,num,r);
        //2.创建指针
        int left=l,right=r-1,index=l;
        while(index<=right){
            if(nums[index]>nums[r]) {
                swap(nums,index,right);
                right--;
            }else if(nums[index]<nums[r]){
                swap(nums,index,left);
                index++;
                left++;
            }else index++;
        }
        swap(nums,++right,r);
        //返回的是等于部分开始的位置，结束的位置
        return new int[]{left,right};
    }

    private static void swap(int[] nums, int num1, int num2) {
        int temp=nums[num1];
        nums[num1]=nums[num2];
        nums[num2]=temp;
    }


    public static void heapSort(int[] nums){
        //1.建立大根堆
        for(int i=0;i<nums.length;i++){
            heapInsert(nums,i);
        }
//          
        for(int i=1;i<nums.length;i++){
            swap(nums,0,nums.length-i);
            heapify(nums,nums.length-i,0);
        }
    }

    //要下顺那个节点，下顺的最大长度是哪里
    public static void heapify(int[] nums,int heapSize,int index){
        int left=index*2+1;
        while(left<heapSize){
            int largest=left+1<heapSize&&nums[left+1]>nums[left]?left+1:left;
            largest=nums[index]>nums[largest]?index:largest;
            if(largest==index) break;
            swap(nums,largest,index);
            index=largest;
            left=2*index+1;
        }
    }

    //上移，调整堆的顺序
    public static void heapInsert(int[] nums,int index){
        //确定好思路的判断条件是什么，如果父节点比当前节点大于或者等于，完成插入
        while((index-1)/2>=0&&nums[index]>nums[(index-1)/2]){
                swap(nums,index,(index-1)/2);
                index=(index-1)/2;
        }
    }
}
