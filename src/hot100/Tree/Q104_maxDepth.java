package hot100.Tree;

import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: IIE
 * @name: Q104_maxDepth
 * @Date: 2024/4/10
 */
public class Q104_maxDepth {
    public static void main(String[] args) {

    }
    public int maxDepth(TreeNode root){
        int depth=0;
        if(root==null){return depth;}
        Queue<TreeNode> que=new LinkedList<>();
        que.add(root);
        while(!que.isEmpty()){
            int size=que.size();
            while(size>0){
                TreeNode node = que.poll();
                size--;
                //在这里加入下一层的节点
                if(node.left!=null) que.add(node.left);
                if(node.right!=null) que.add(node.right);

            }
            depth++;
        }
        return depth;
    }

    public int MaxDepth(TreeNode root){
        if(root==null){
            return 0;
        }else{
            int leftHeight = MaxDepth(root.left);
            int rightHeight= MaxDepth(root.right);
            return Math.max(leftHeight,rightHeight)+1;
        }
    }
}
class TreeNode{
    int value;
    TreeNode left;
    TreeNode right;

    public TreeNode() { }

    public TreeNode(int value) {
        this.value = value;
    }
    public TreeNode(int value, TreeNode left, TreeNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}