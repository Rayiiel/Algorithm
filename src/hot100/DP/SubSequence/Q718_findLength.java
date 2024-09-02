package hot100.DP.SubSequence;

/**
 * @Author: IIE
 * @name: Q718_findLength
 * @Date: 2024/5/19
 */
public class Q718_findLength {
    public static void main(String[] args) {

    }
    public int findLength(int[] nums1,int[] nums2){
        //1.dp[i][j] 以i-1和j-1为结尾的元素的最长连续数组
        int[][] dp=new int[nums1.length+1][nums2.length+1];
        int ans=0;
        for (int i = 1; i <= nums1.length; i++) {
            for (int j = 1; j <=nums2.length ; j++) {
                if(nums1[i-1]==nums2[j-1]){
                    dp[i][j]=dp[i-1][j-1]+1;
                    ans=Math.max(ans,dp[i][j]);
                }
            }
        }
        return ans;
    }
}
