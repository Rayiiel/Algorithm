package hot100.Tree;

/**
 * @Author: IIE
 * @name: Q437_pathSum
 * @Date: 2024/4/15
 */
public class Q437_pathSum {
    public static void main(String[] args) {

    }
    public int pathSum(TreeNode root,int targetSum){
        return pathSubTreeSum(root,targetSum);
    }
    public int pathSubTreeSum(TreeNode root,int targetSum){
        if(root==null){
            return 0;
        }
        int count=rootSum(root,targetSum);
        //计算含有左子树根节点和含有右子树根节点的路径数目
        int countLeft = pathSubTreeSum(root.left, targetSum);
        int countRight = pathSubTreeSum(root.right,targetSum);
        return count+countLeft+countRight;
    }
    public int rootSum(TreeNode root, long targetSum) {
        int ret = 0;
        if (root == null) {
            return 0;
        }
        int val = root.value;
        if (val == targetSum) {
            ret++;
        }
        ret += rootSum(root.left, targetSum - val);
        ret += rootSum(root.right, targetSum - val);
        return ret;
    }
}
