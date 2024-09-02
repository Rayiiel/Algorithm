package hot100.Tree;


import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: IIE
 * @name: Q114_flatten
 * @Date: 2024/4/12
 */
public class Q114_flatten {
    public static void main(String[] args) {

    }
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        List<TreeNode> list = new ArrayList<>();
        midTravel(root,list);
        for (int i = 0; i <list.size()-1 ; i++) {
            list.get(i).left=null;
            list.get(i).right=list.get(i+1);
        }

    }

    public void midTravel(TreeNode root, List list) {
        if(root==null){
            return;
        }
        list.add(new TreeNode(root.value));
        midTravel(root.left,list);
        midTravel(root,list);
    }
}

