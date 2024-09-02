package zuoshen.Tree.Recur;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: IIE
 * @name: LevelCur
 * @Date: 2024/7/23
 */
public class LevelCur {
    //迭代形式
    public void levelCur(TreeNode root){
        if(root==null) return;
        List<List<Integer>> result=new ArrayList<>();
        Queue<TreeNode> que=new LinkedList<>();
        que.add(root);
        while(!que.isEmpty()){
            int size=que.size();
            ArrayList<Integer> list = new ArrayList<Integer>();
            while(size>0){
                TreeNode p = que.poll();
                list.add(p.val);
                if(p.left!=null) que.add(p.left);
                if(p.right!=null) que.add(p.right);
            }
            result.add(list);
        }
    }
    //递归形式
    List<List<Integer>> result=new ArrayList<List<Integer>>();
    public List<List<Integer>> levelCur2(TreeNode root){
        level(root,0);
        return result;
    }
    public void level(TreeNode root,int deep){
        if(root==null) return;
        deep++;
        if(deep>result.size()){
            List<Integer> list=new ArrayList<Integer>();
            result.add(list);
        }
        result.get(deep-1).add(root.val);
        level(root.left,deep);
        level(root.right,deep);
    }
}
