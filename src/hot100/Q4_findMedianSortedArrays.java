package hot100;

/**
 * @Author: IIE
 * @name: Q4_findMedianSortedArrays
 * @Date: 2024/4/20
 */
public class Q4_findMedianSortedArrays {
    public static void main(String[] args) {

    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] array=new int[nums1.length+nums2.length];
        int left=0,right=0,i=0;
        while(left<nums1.length&&right<nums2.length){
            if(nums1[left]<nums2[right]){
                array[i++]=nums1[left++];
            }else{
                array[i++]=nums2[right++];
            }
        }
        while(left<nums1.length){
            array[i++]=nums1[left++];
        }
        while(right<nums2.length){
            array[i++]=nums2[right++];
        }
        if(array.length%2==0){
            return (double)(array[array.length/2]+array[array.length/2-1])/2;
        }else{
            return (double)array[array.length/2];
        }
    }
}
