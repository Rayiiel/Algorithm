package hot100.Tree;

import sun.reflect.generics.tree.Tree;

import javax.xml.soap.Node;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: IIE
 * @name: Q105_buildTree
 * @Date: 2024/4/15
 */
public class Q105_buildTree {
    public static void main(String[] args) {
        int[] preorder={1,2,3};
        int[] inorder={3,2,1};
        buildTree(preorder,inorder);
    }
    public static TreeNode buildTree(int[] preorder,int[] inorder){
        int lengthA=preorder.length;
        int lengthB=inorder.length;
        if(lengthA!=lengthB){
            return null;
        }
        HashMap<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i <inorder.length ; i++) {
            map.put(inorder[i],i);
        }
        TreeNode root=findSubTree(0,lengthA-1,0,lengthB-1,map,preorder,inorder);
        return root;
    }
    public static TreeNode findSubTree(int preLeft, int preRight, int inLeft, int inRight, HashMap<Integer,Integer> map,int[] preorder,int[] inorder){
        if(preLeft>preRight||inLeft>inRight){
            return null;
        }
        TreeNode root=new TreeNode(preorder[preLeft]);
        Integer index = map.get(preorder[preLeft]);
        root.left=findSubTree(preLeft+1,preLeft+index-inLeft,inLeft,index-1,map,preorder,inorder);
        root.right=findSubTree(preLeft+index-inLeft+1,preRight,index+1,inRight,map,preorder,inorder);
        return root;
    }
}
