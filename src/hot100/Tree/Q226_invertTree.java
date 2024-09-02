package hot100.Tree;

/**
 * @Author: IIE
 * @name: Q226_invertTree
 * @Date: 2024/4/10
 */
public class Q226_invertTree {
    public TreeNode invertTree(TreeNode root){
        if(root==null){
            return root;
        }else{
            //交换
            TreeNode temp=root.right;
            root.right = invertTree(root.left);
            root.left  = invertTree(temp);
            return root;
        }
    }
}
