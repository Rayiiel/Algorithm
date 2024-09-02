package RemoveElement;

public class Q88_mergeArray {
    public static void main(String[] args) {
        int[] nums1={2,0};
        int[] nums2={1};
        merge(nums1,1,nums2,1);
        for (int i = 0; i < nums1.length; i++) {
            System.out.println(nums1[i]);
        }
    }
    private static void merge(int[] nums1, int m, int[] nums2, int n){
        int flag1=m-1;
        int flag2=n-1;
        //把大的数值放在后面才能保证nums1前面的数值不被冲突
        for(int i=0;flag1>=0&&flag2>=0;i++){
            if(nums1[flag1]>nums2[flag2]){
                nums1[m+n-i-1]=nums1[flag1];
                flag1--;
            }else if(nums1[flag1]==nums2[flag2]){
                nums1[m+n-i-1]=nums1[flag1];
                i++;
                nums1[m+n-i-1]=nums2[flag2];
                flag1--;
                flag2--;
            }else{
                nums1[m+n-i-1]=nums2[flag2];
                flag2--;
            }

        }
        //对剩下的数据进行处理
        if(flag1<0){
            for(int i=0;i<=flag2;i++){
                nums1[i]=nums2[i];
            }
        }
    }
}
