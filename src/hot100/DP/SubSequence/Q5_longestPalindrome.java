package hot100.DP.SubSequence;

/**
 * @Author: IIE
 * @name: Q5_longestPalindrome
 * @Date: 2024/5/20
 */
public class Q5_longestPalindrome {
    public static void main(String[] args){
        System.out.println(longestPalindrome("cbbd"));
    }
    public static String longestPalindrome(String s){
        char[] chars = s.toCharArray();
        if(s==""||s.length()<1){
            return s;
        }
        int begin=0,end=0;
        for (int i = 0; i < s.length(); i++) {
            //len1返回的偶数长度的回文子串
            int len1 = extendAroundChar(s, i, i);
            //len2返回的奇数长度的回文子串
            int len2= extendAroundChar(s,i,i+1);
            int len=Math.max(len1,len2);
            if(len>end-begin+1) {
                begin = i - (len-1)/ 2;
                end = i + len/ 2;
            }
        }
        return s.substring(begin,end+1);
    }
    public static int extendAroundChar(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            --left;
            ++right;
        }
        return right - left - 1;
    }

}
