package zuoshen.Tree.SpecialTree;

/**
 * @Author: IIE
 * @name: BalanceTree
 * @Date: 2024/8/14
 */
public class BalanceTree {
    public boolean isBalanced(TreeNode root){
        int depth=maxDepth(root);
        return depth>-1;
    }
    public int maxDepth(TreeNode root){
        if(root==null) return 0;
        int left=maxDepth(root.left);
        int right=maxDepth(root.right);
        if(left==-1||right==-1) return -1;
        if(Math.abs(left-right)>1) return -1;
        return Math.max(left,right)+1;
    }
}
