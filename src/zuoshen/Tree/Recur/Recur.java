package zuoshen.Tree.Recur;

/**
 * @Author: IIE
 * @name: preOrderRecur
 * @Date: 2024/7/23
 */
public class Recur {
    public void preOrderRecur(TreeNode head){
        if(head==null) return;
        System.out.println(head.val);
        preOrderRecur(head.left);
        preOrderRecur(head.right);
    }
    public void midOrderRecur(TreeNode head){
        if(head==null) return;
        preOrderRecur(head.left);
        System.out.println(head.val);
        preOrderRecur(head.right);
    }

    public void posOrderRecur(TreeNode head){
        if(head==null) return;
        preOrderRecur(head.left);
        preOrderRecur(head.right);
        System.out.println(head.val);
    }
}

class TreeNode {
    TreeNode left;
    TreeNode right;
    int val;
    TreeNode(){}
    TreeNode(int val){
        this.val=val;
    }
}