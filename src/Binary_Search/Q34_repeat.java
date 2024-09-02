public class Q34_repeat {
    public static void main(String[] args) {

        int[] nums={5,7,7,8,8,10};

        System.out.println(searchRange(nums,8)[0]+" "+searchRange(nums,8)[1]);




    }
    //进入误区，直接进行线性查找
    static public int[] searchRange(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        int[] results={-1,-1};
        int flag1=left;
        int flag2=right;
        while(left<=right){
            int middle=left+(right-left)/2;
            if(nums[middle]==target){
                //查找到的第一个数值
                for(int j=middle;j>=0;j--)
                {
                    if(nums[j]!=target){
                        flag1=j+1;
                        break;
                    }
                }
                for(int j=middle;j<nums.length;j++)
                {
                    if(nums[j]!=target){
                        flag2=j-1;
                        break;
                    }
                }
                results[0]=flag1;
                results[1]=flag2;
                return results;
            }else if(target<nums[middle]){
                right=middle-1;
            }else{
                left=middle+1;
            }
        }
        return results;
    }
}
class Solution {
    public int[] searchRange(int[] nums, int target) {
        return new int[]{findFirstPosition(nums,target),findLastPosition(nums,target)};
    }
    //查找第一个出现的元素
    private int findFirstPosition(int[] nums,int target){
        int left=0;
        int right=nums.length-1;
        int flag1=-1;
        while(left<=right){

            int middle=(left+right)/2;
            if(target<nums[middle]){
                //查找区间变为了【left,middle-1】
                right=middle-1;
            } else if (target == nums[middle]) {
                //凡是找到的，我都做了标记，要是退出循环了，那就是没有找到或者再没有了
                flag1=middle;
                right=middle-1;
            }else{
                //查找区间变为了【middle+1,right】
                left=middle+1;
            }
        }

        return flag1;

    }

    private int findLastPosition(int[] nums,int target){
        int left=0;
        int right=nums.length-1;
        int flag2=-1;
        while(left<=right) {
            int middle=(left+right)/2;
            if(target>nums[middle]){
                //查找区间变为了【left,middle-1】
                left=middle+1;
            } else if (target == nums[middle]) {
                left = middle+1;
                flag2=middle;
            }else{
                //查找区间变为了【middle+1,right】
                right=middle-1;
            }
        }
        return flag2;

    }
}
