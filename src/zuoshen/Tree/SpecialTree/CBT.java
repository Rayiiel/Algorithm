package zuoshen.Tree.SpecialTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @Author: IIE
 * @name: CBT
 * @Date: 2024/8/14
 */
class CBT {
    public boolean isCBT(TreeNode root){
        Queue<TreeNode> st=new LinkedList<>();
        if(root==null) return true;
        st.add(root);
        boolean leaf=false;
        while(!st.isEmpty()){
            int size=st.size();
            while(size>0){
                TreeNode pop = st.poll();
                TreeNode l=pop.left;
                TreeNode r=pop.right;
                if(leaf&&!(r==null&&l==null)) return false;
                if(r!=null && l==null) return false;
                if(r==null || l==null) leaf=true;
                if(l!=null) st.add(l);
                if(r!=null) st.add(r);
            }
        }
        return true;
    }
}
