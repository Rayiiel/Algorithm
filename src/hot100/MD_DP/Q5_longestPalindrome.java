package hot100.MD_DP;

/**
 * @Author: IIE
 * @name: Q5_longestPalindrome
 * @Date: 2024/5/19
 * 待实现
 */
public class Q5_longestPalindrome {
    public static void main(String[] args) {
        String s = longestPalindrome("aacabdkacaa");
        System.out.println(s);
    }
    public static String longestPalindrome(String s){
        //需要一个翻转字符串，求两个字符串的最长重复子序列
        char[] chars1 = s.toCharArray();
        //
        int[][] dp=new int[s.length()+1][s.length()+1];
        int ans=0;
        int temp=0;
        for (int i = 1; i <=s.length() ; i++) {
            for (int j = 1; j <=s.length() ; j++) {
                if(chars1[i-1]==chars1[s.length()-j]){
                    dp[i][j]=dp[i-1][j-1]+1;
                    if(dp[i][j]>ans){
                        if(isPalindrome(s.substring(i-ans,i))){
                            ans=dp[i][j];
                            temp=i;
                        }

                    }
                }
            }
        }
        //ans的最大值和最后最长连续子序列的定位位置同时出现，如果在temp处出现最大值，则子序列为s.substring(temp-ans,temp)
        return s.substring(temp-ans,temp) ;
    }
    public static boolean isPalindrome(String str){
        for (int i = 0; i <str.length() ; i++) {
            if(str.charAt(i)!=str.charAt(str.length()-i-1)){
                return false;
            }
        }
        return true;
    }
}
