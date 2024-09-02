package hot100.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: IIE
 * @name: Q230_kthSmallest
 * @Date: 2024/4/11
 */
public class Q230_kthSmallest {
    public static void main(String[] args) {

    }

    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        midTravel(root,list);
        return list.get(k-1);
    }

    public void midTravel(TreeNode root, List<Integer> list) {
        if(root==null){
            return ;
        }else{
            midTravel(root.left, list);
            list.add(root.value);
            midTravel(root.right, list);
        }

    }
}
