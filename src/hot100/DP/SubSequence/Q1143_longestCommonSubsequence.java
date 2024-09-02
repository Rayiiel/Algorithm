package hot100.DP.SubSequence;

/**
 * @Author: IIE
 * @name: Q1143_longestCommonSubsequence
 * @Date: 2024/5/19
 */
public class Q1143_longestCommonSubsequence {
    public static void main(String[] args) {

    }
    public int longestCommonSubsequence(String text1,String text2){
        char[] chars1 = text1.toCharArray();
        char[] chars2 = text2.toCharArray();
        //以[0,i-1],[0,j-1]为结尾的最长子序列的长度
        int[][] dp=new int[chars1.length+1][chars2.length+1];
        int ans=0;
        for (int i = 1; i <=chars1.length ; i++) {
            for (int j = 1; j <=chars2.length ; j++) {
                if(chars1[i-1]==chars2[j-1]){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else{
                    //这种情况忽略的dp[i-1][j]和dp[i][j-1]的情况，要一步一步来
                    //  dp[i][j]=dp[i-1][j-1];
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
                ans=Math.max(ans,dp[i][j]);
            }
        }
        return dp[chars1.length][chars2.length];
    }
}
