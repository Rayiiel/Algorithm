package zuoshen.Tree.Recur;

import java.util.Stack;

/**
 * @Author: IIE
 * @name: UnRecur
 * @Date: 2024/7/23
 */
public class UnRecur {
    public void preOrderUnRecur(TreeNode head){
        if(head==null) return;
        Stack<TreeNode> st= new Stack<>();
        st.push(head);
        while(!st.isEmpty()){
            TreeNode p = st.pop();
            System.out.println(p.val);
            //注意栈先入后出的顺序
            if(p.right!=null) st.push(p.right);
            if(p.left!=null) st.push(p.left);
        }
    }
    public void midOrderUnRecur(TreeNode head){
         Stack<TreeNode> st= new Stack<>();
         while(head!=null || !st.isEmpty()) {
            if(head!=null){
                st.push(head);
                head=head.left;
            }else{
                head= st.pop();
                System.out.println(head.val);
                head=head.right;
            }
         }
    }

    public void posOrderUnRecur(TreeNode head){
        if(head==null) return;
        Stack<TreeNode> st1= new Stack<>();
        Stack<TreeNode> st2= new Stack<>();
        st1.push(head);
        while(!st1.isEmpty()){
            TreeNode p = st1.pop();
            st2.push(p);
            if(p.left!=null) st1.push(p.left);
            if(p.right!=null) st1.push(p.right);
        }
        while(!st2.isEmpty()){
            System.out.println(st2.pop().val);
        }
    }
}
