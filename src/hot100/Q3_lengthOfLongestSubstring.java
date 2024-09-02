package hot100;

import java.util.HashMap;

/**
 * @Author: IIE
 * @name: Q3_lengthOfLongestSubstring
 * @Date: 2024/3/29
 */
public class Q3_lengthOfLongestSubstring {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }
    public static int lengthOfLongestSubstring(String s) {

        int left=0;
        int length=0;
        //key表示当前的字母、value是该字母对应的下标
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i <s.length() ; i++) {
            if(!(map.containsKey(s.charAt(i)))){
                map.put(s.charAt(i),i);
            }else{
                //重点
                left = Math.max(left,map.get(s.charAt(i))+1);
                //先滑动窗口在改变数字呐
                map.put(s.charAt(i),i);
            }
            length=Math.max(length,i-left+1);
        }
        return length;
    }
}
