package RemoveElement;

public class Q26_RemoveElement {
    public static void main(String[] args) {
        int[] nums = {0,1,2,2,3,0,4,2};
        int val = 2;
        int[] newNums=baseSolution(nums,val);
        for (int i = 0; i <newNums.length ; i++) {
            System.out.println(newNums[i]);
        }
        System.out.println(newNums.length);
        int[] nums2 = {0,1,2,2,3,0,4,2};
        System.out.println(removeElement(nums2,2));

        //题目要求：请删除非严格递增数列重复的元素，使得当前的数组中每一个元素只出现一次

    }


    static public int[] baseSolution(int[] nums,int val){
        int size=nums.length;
        //最后一个数值用0来覆盖
        if(nums[nums.length-1]==val){
            nums[nums.length-1]=0;
            size--;
        }
        for (int i=0;i<nums.length-1;i++){
            if(nums[i]==val){
                //通过后面的覆盖前面的
                size--;
                for(int j=i;j<nums.length-1;j++){
                        nums[j]=nums[j+1];
                }
            }
            if(nums[i]==val){
                i=i-1;
            }

        }
        return nums;
    }

    //通过一个双指针的在一个for循环下完成双循环的方法
    static public int removeElement(int[] nums,int val){
        int size=nums.length;
        int slowIndex=0;
        for(int fastIndex=0;fastIndex<nums.length;fastIndex++){
            if(nums[fastIndex]!=val){

/*               nums[slowIndex]=nums[fastIndex];
                 slowIndex++;*/
                nums[slowIndex++]=nums[fastIndex];
            }

        }

        return slowIndex;
    }
    private static  int removeDuplicates(int[] nums) {
        int slowIndex=0;
        for(int fastIndex=0;fastIndex<nums.length-1;fastIndex++){
            //当前的数值和后一个数值不相同的时候，slowINdex++
            if(nums[fastIndex]!=nums[fastIndex+1]){
                nums[slowIndex++]=nums[fastIndex];
            }
        }
       return slowIndex++;
    }
}
