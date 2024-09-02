package hot100.Stack;

import java.util.Stack;



/**
 * @Author: IIE
 * @name: Q394_decodeString
 * @Date: 2024/5/5
 */
public class Q394_decodeString {
    public static void main(String[] args) {
        System.out.println(decodeString("3[a]2[bc]"));
    }
    public static String decodeString(String s) {

        Stack<Character> stack = new Stack<>();

        for(char c : s.toCharArray())
        {
            if(c != ']')
                stack.push(c); // 把所有的字母push进去，除了]

            else
            {
                //step 1: 取出[] 内的字符串

                StringBuilder sb = new StringBuilder();
                while(!stack.isEmpty() && Character.isLetter(stack.peek()))
                    sb.insert(0, stack.pop());

                String sub = sb.toString(); //[ ]内的字符串
                stack.pop(); // 去除[


                //step 2: 获取倍数数字

                sb = new StringBuilder();
                while(!stack.isEmpty() && Character.isDigit(stack.peek()))
                    sb.insert(0, stack.pop());

                int count = Integer.valueOf(sb.toString()); //倍数


                //step 3: 根据倍数把字母再push回去

                while(count > 0)
                {
                    for(char ch : sub.toCharArray())
                        stack.push(ch);
                    count--;
                }
            }
        }

        //把栈里面所有的字母取出来，完事L('ω')┘三└('ω')｣
        StringBuilder retv = new StringBuilder();
        while(!stack.isEmpty())
            retv.insert(0, stack.pop());

        return retv.toString();
    }
}
