package Classic150;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * @Author: IIE
 * @name: Q14_longestCommonPrefix
 * @Date: 2024/7/3
 */
public class Q14_longestCommonPrefix {
    public static void main(String[] args) {
        String[] str={"aa","sdfas","qwd","aweqwa"};
        longestCommonPrefix(str);
        for (String s : str) {
            System.out.println(s);
        }
    }

    public static String longestCommonPrefix(String[] strs) {
        //重写sort方法
        Collections.sort(Arrays.asList(strs),new Comparator<String>(){
            @Override
            public int compare(String o1, String o2) {
                return o1.length()-o2.length();
            }
        });
        return "";
    }
}
