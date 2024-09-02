package Queue_Stack;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @Author: IIE
 * @name: Q20_isValid
 * @Date: 2024/3/26
 */
public class Q20_isValid {
    public static void main(String[] args) {
        System.out.println(isValid("{[()())]}"));
    }

    public static boolean isValid(String s) {

        char[] chars = s.toCharArray();
        Stack<Character> record=new Stack<>();

        record.push(chars[0]);
        for (int i = 1; i <chars.length ; i++) {
            if(record.isEmpty()){
                record.push(chars[i]);
            }else{
                if(chars[i]>record.peek()+3){
                    break;
                }else{
                    //判断是否可以进行括号的匹配
                    if(chars[i]==(record.peek()+1)||chars[i]==(record.peek()+2)){
                        record.pop();
                    }else{
                        record.push(chars[i]);
                    }
                }
            }
        }

        if(record.isEmpty()){
            return true;
        }else{
            return false;
        }
    }
}
