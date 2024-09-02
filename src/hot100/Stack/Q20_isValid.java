package hot100.Stack;

import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

/**
 * @Author: IIE
 * @name: Q20_isValid
 * @Date: 2024/4/25
 */
public class Q20_isValid {
    public static void main(String[] args) {
        System.out.println(idValid("()("));
    }
    public static boolean idValid(String s){
        char[] chars = s.toCharArray();
        Stack<Character> stack=new Stack();

        for (int i = 0; i <chars.length ; i++) {
            if(chars[i]=='('||chars[i]=='{'||chars[i]=='['){
                stack.push(chars[i]);
            }else {
                if(chars[i]==(stack.peek()+1)||chars[i]==(stack.peek()+2)){
                   stack.pop();
                }else{
                    return false;
                }
            }
        }

        if(stack.isEmpty()){
            return true;
        }else{
            return false;
        }
    }
}
