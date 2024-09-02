package hot100.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author: IIE
 * @name: Q99_rightSideView
 * @Date: 2024/4/12
 */
public class Q99_rightSideView {
    public static void main(String[] args) {

    }
    public List<Integer> rightSideView(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        if(root==null){
            return list;
        }
        stack.push(root);
        while(!stack.isEmpty()){
            int size=stack.size();
            List<Integer> newList = new ArrayList<>();
            while(size>0){
                TreeNode node = stack.pop();
                newList.add(node.value);
                size--;
                if(node.left!=null){ stack.add(node.left); }
                if(node.right!=null){ stack.add(node.right); }
            }
            list.add(newList.get(newList.size()-1));
        }
        return list;
    }
}
