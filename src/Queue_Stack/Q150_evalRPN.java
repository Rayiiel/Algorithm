package Queue_Stack;

import java.util.Stack;

/**
 * @Author: IIE
 * @name: Q150_evalRPN
 * @Date: 2024/3/26
 * 逆波兰表达式求值：所谓逆波兰表达式就是运算符号写在数字后面
 */
public class Q150_evalRPN {
    public static void main(String[] args) {
        String[] strings={"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(evalRPN(strings));
    }

    public static int evalRPN(String[] tokens){
        //先设置一个返回值
        int value=0;
        int frist=0;
        int second=0;
        Stack<Integer> records = new Stack<>();
        for (String token : tokens) {
            switch (token){
                case "+":
                    if(!(records.isEmpty())){
                        second=records.pop();
                        frist=records.pop();
                    value=frist+second;
                    records.push(value);
                    }
                    break;
                case "-":
                    if(!(records.isEmpty())){
                        second=records.pop();
                        frist=records.pop();
                        value=frist-second;
                    records.push(value);}
                    break;
                case "*":
                    if(!(records.isEmpty())){
                        second=records.pop();
                        frist=records.pop();
                        value=frist*second;
                    records.push(value);}
                    break;
                case "/":
                    if(!(records.isEmpty())){
                        second=records.pop();
                        frist=records.pop();
                        value=frist/second;
                    records.push(value);}
                    break;
                default:
                    records.push(Integer.parseInt(token));
                    break;
            }
        }
        return records.pop();
    }
}
