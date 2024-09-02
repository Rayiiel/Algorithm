package String;

import java.util.Arrays;

/**
 * @Author: IIE
 * @name: Q344_reverseString
 * @Date: 2024/3/25
 */
public class Q541_reverseString {
    public static void main(String[] args) {
        System.out.println(reverseStr("abcd",2));
    }
    public static String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        int index=0;
        int left=0;
        int right=0;
        while(index<chars.length){
            if(chars.length-index>=2*k){
                //翻转前k的字符，index=index+2*k;
                left=index;
                right=index+k-1;
                while(left<right){
                    char temp=chars[left];
                    chars[left]=chars[right];
                    chars[right]=temp;
                    left++;
                    right--;
                }
                index=index+2*k;

            }else if(chars.length-index>k){
                //翻转前k的字符，结束
                left=index;
                right=index+k-1;
                while(left<right){
                    char temp=chars[left];
                    chars[left]=chars[right];
                    chars[right]=temp;
                    left++;
                    right--;
                }
                break;
            }else{
                //翻转剩下的字符，结束
                left=index;
                right=chars.length-1;
                while(left<right){
                    char temp=chars[left];
                    chars[left]=chars[right];
                    chars[right]=temp;
                    left++;
                    right--;
                }
                break;
            }
        }
        return String.valueOf(chars);
    }

}
