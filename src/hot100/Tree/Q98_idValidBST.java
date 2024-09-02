package hot100.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: IIE
 * @name: Q98_idValidBST
 * @Date: 2024/4/11
 */
public class Q98_idValidBST {
    public static void main(String[] args) {

    }
    public boolean isValidBST(TreeNode root) {
        if(root==null||(root.left==null&&root.right==null)){
            return true;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        midTravel(root,arrayList);
        for (int i = 0; i < arrayList.size()-1; i++) {
            if(arrayList.get(i)>arrayList.get(i+1)){
                return false;
            }
        }
        if(arrayList.get(arrayList.size()-2)<=arrayList.get(arrayList.size()-1)){
            return true;
        }else{
            return false;
        }
    }
    //中序遍历
    public void midTravel(TreeNode root, List<Integer> result){
        if(root==null){
            return;
        }else{
            midTravel(root.left,result);
            result.add(root.value);
            midTravel(root.right,result);

        }
    }
}
