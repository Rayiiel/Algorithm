package hot100.Tree;

/**
 * @Author: IIE
 * @name: Q543_diameterOfBinaryTree
 * @Date: 2024/4/10
 */
public class Q543_diameterOfBinaryTree {
    public static void main(String[] args) {

    }
    int ans;
    public int diameterOfBinaryTree(TreeNode root){
        ans=1;
        depth(root);
        return ans-1;
    }

    public  int depth(TreeNode root) {
        if(root==null){
            return 0;
        }
        int L=depth(root.left);
        int R=depth(root.right);
        ans=Math.max(L+R-1,ans);
        return Math.max(L,R);
    }
}
