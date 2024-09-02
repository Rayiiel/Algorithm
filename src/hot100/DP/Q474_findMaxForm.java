package hot100.DP;

/**
 * @Author: IIE
 * @name: Q474_findMaxForm
 * @Date: 2024/5/15
 */
public class Q474_findMaxForm {
    public static void main(String[] args) {
        String[] strs = {"10", "0", "1"};
        System.out.println(findMaxForm(strs,1,1));
    }
    public static int findMaxForm(String[] strs,int m,int n){
        int[][] records=new int[strs.length][2];
        for (int i = 0; i <strs.length ; i++) {
            for (int j = 0; j < strs[i].length(); j++) {
                if(strs[i].charAt(j)=='0'){
                    records[i][0]++;
                }else{
                    records[i][1]++;
                }
            }
        }

        //装i个0，j个1，所能承载的最大子集的个数
        int[][] dp=new int[m+1][n+1];

        for (int k = 0; k < strs.length; k++) {
            for (int i = m; i>=records[k][0]; i--) {
                for (int j = n; j>=records[k][1]; j--) {
                   // dp[i][j]=Math.max(dp[i][j],++dp[i-records[k][0]][j-records[k][1]]);
                    // 错误分析：这里不是自增，自增的话它的本身也会变，我们这里是不变
                    dp[i][j]=Math.max(dp[i][j],dp[i-records[k][0]][j-records[k][1]]+1);
                }
            }
        }

        return dp[m][n];
    }
}
