package String;

/**
 * @Author: IIE
 * @name: Q151_reverseWords
 * @Date: 2024/3/25
 */
public class Q151_reverseWords {
    public static void main(String[] args) {
        System.out.println(reverseWords("  hello world  "));
    }

    public static String reverseWords(String s) {
        //会对存在的空格逐一去除，两个空格则变成两个“”空
        String[] s1 = s.split(" ");
        String result="";
        for (int i =s1.length-1; i>=0; i--) {
            if(!(s1[i].equals(""))){
                result+=s1[i]+" ";
            }
        }


        return result.trim();
        }
}
