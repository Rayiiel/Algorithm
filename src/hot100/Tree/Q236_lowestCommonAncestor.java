package hot100.Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: IIE
 * @name: Q236_lowestCommonAncestor
 * @Date: 2024/4/15
 */
public class Q236_lowestCommonAncestor {
    public static void main(String[] args) {

    }
    public TreeNode lowestCommonAncestor(TreeNode root,TreeNode p,TreeNode q) {
        if(root==null||root==p||root==q){
            return root;
        }
        TreeNode left=lowestCommonAncestor(root.left,p,q);
        TreeNode right=lowestCommonAncestor(root.right,p,q);
        if(left==null) return right;
        if(right==null) return left;
        return root;
    }
}
