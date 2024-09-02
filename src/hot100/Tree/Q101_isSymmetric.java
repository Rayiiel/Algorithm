package hot100.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: IIE
 * @name: Q101_isSymmetric
 * @Date: 2024/4/10
 */
public class Q101_isSymmetric {
    public static void main(String[] args) {

    }
    public boolean isSymmetric(TreeNode root){
        if(root==null){
            return true;
        }
        Queue<TreeNode> que=new LinkedList<>();
        que.add(root.left);
        que.add(root.right);
        while(!que.isEmpty()){
            int size=que.size();
            while(size>0){
                TreeNode left = que.poll();
                size--;
                TreeNode right=que.poll();
                size--;
                if(left==null&&right==null){
                    continue;
                }else if(left==null||right==null){
                    return false;
                }else if(left.value!=right.value){
                    return false;
                }
                que.add(left.left);
                que.add(right.right);
                que.add(right.left);
                que.add(left.right);
            }
        }
        return true;
    }

    public boolean isSymmetric02(TreeNode root){
        if(root==null){
            return true;
        }
        return isSymmetricNodes(root.left,root.right);
    }

    public boolean isSymmetricNodes(TreeNode left, TreeNode right) {
        if(left==null&&right==null){
            return true;
        }
        if(left==null||right==null){
            return false;
        }
        if(left.value!=right.value){
            return false;
        }
        return isSymmetricNodes(left.left,right.right)&&isSymmetricNodes(left.right,right.left);
    }
}
