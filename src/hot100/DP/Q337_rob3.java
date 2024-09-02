package hot100.DP;



/**
 * @Author: IIE
 * @name: Q337_rob3
 * @Date: 2024/5/18
 */
public class Q337_rob3 {
    public static void main(String[] args) {

    }
    public int rob(TreeNode root){
        int[] dp = robTree(root);
        return Math.max(dp[0],dp[1]);
    }
    public int[] robTree(TreeNode cur){
        int[] dp=new int[2];
        if(cur==null){
            dp[0]=0;
            dp[1]=0;
            return dp;
        }
        int[] left = robTree(cur.left);
        int[] right = robTree(cur.right);
        //不偷当前节点
        dp[0]=Math.max(left[0],left[1])+Math.max(right[0],right[1]);
        dp[1]=cur.val+left[0]+right[0];
        return dp;
    }
}


class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
