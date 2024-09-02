package hot100.Tree;

/**
 * @Author: IIE
 * @name: Q108_sortedArrayToBST
 * @Date: 2024/4/11
 * 平衡二叉树：
 * 有序二叉树：
 *
 */
public class Q108_sortedArrayToBST {
    public static void main(String[] args) {

    }
    public TreeNode sortedArrayToBST(int[] nums){
        return helper(nums,0,nums.length-1);
    }

    public TreeNode helper(int[] nums, int left, int right) {
        if(left>right){
            return null;
        }
        int mid=nums[left+(right-left)/2];
        TreeNode root = new TreeNode(mid);
        root.left=helper(nums,left,left+(right-left)/2-1);
        root.right=helper(nums,left+(right-left)/2+1,right);
        return root;
    }
}
