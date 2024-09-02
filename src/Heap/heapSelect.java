package Heap;

/**
 * @Author: IIE
 * @name: heapSelect
 * @Date: 2024/6/5
 */
public class heapSelect {
    public static void main(String[] args) {
        heapselect();
    }

    public static  void heapselect(){
        int[] nums={3,2,3,1,2,4,5,5,6};
        //先创建大顶堆
        buildMaxHeap(nums,nums.length);
        for(int i=0;i<nums.length;i++){
            swap(nums,0,nums.length-1-i);
            maxHeapify(nums,0,nums.length-i-1);
        }
        for (int num : nums) {
            System.out.println(num);
        }
    }
    //建立大顶堆
    public static  void buildMaxHeap(int[] a,int heapSize){
        for(int i=heapSize/2;i>=0;i--){
            maxHeapify(a,i,heapSize);
        }
    }

    //小元素不断下坠
    public static void maxHeapify(int[] a, int i, int heapSize) {
        //按照下标来走的
        int l=i*2+1,r=i*2+2,largest=i;
        if(l<heapSize && a[l]>a[largest]){
            largest=l;
        }
        if(r<heapSize && a[r]>a[largest]){
            largest=r;
        }
        if(largest!=i){
            swap(a,i,largest);
            maxHeapify(a,largest,heapSize);
        }
    }

    public static void swap(int[] a, int i, int largest) {
        int temp=a[i];
        a[i]=a[largest];
        a[largest]=temp;
    }
}
