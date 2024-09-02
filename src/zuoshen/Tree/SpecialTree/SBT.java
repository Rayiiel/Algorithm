package zuoshen.Tree.SpecialTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: IIE
 * @name: SBT  搜索树
 * @Date: 2024/8/14
 */
//判断当前树是否是二叉搜索树  层序遍历一定是从小到大的结构
class SBT {
    //通过迭代形式实现层序遍历
    double preValue=-Double.MAX_VALUE;
    public boolean isValidBST(TreeNode root) {
        if(root==null) return true;
        if(!isValidBST(root.left)) return false;
        if(root.val<=preValue) return false;
        preValue=root.val;
        return isValidBST(root.right);
    }
}
class TreeNode {
    TreeNode left;
    TreeNode right;
    int val;
    TreeNode(){}
    TreeNode(int val){
        this.val=val;
    }
}