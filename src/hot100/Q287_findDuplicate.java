package hot100;

/**
 * @Author: IIE
 * @name: Q287_findDuplicate
 * @Date: 2024/5/20
 */
public class Q287_findDuplicate {
    public static void main(String[] args) {

    }
    public int findDuplicate(int[] nums){
        int slow=0,fast=0;
        do{
            slow=nums[slow];
            fast=nums[nums[fast]];
        }while(slow!=fast);
        slow=0;
        while(slow!=fast){
            slow=nums[slow];
            fast=nums[fast];
        }
        return slow;
    }
}
