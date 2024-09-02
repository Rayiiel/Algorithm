package Queue_Stack;

import java.util.Stack;

/**
 * @Author: IIE
 * @name: Q1047_removeDyplicates
 * @Date: 2024/3/26
 */
public class Q1047_removeDyplicates {
    public static void main(String[] args) {

        System.out.println(removeDuplicates("abbaca"));
    }

        public static String removeDuplicates(String s) {
            char[] chars=s.toCharArray();
            Stack<Character> record=new Stack<>();
            record.push(chars[0]);
            for(int i=1;i<chars.length;i++){
                if(record.isEmpty()){
                    record.push(chars[i]);
                }else{
                    if(chars[i]==record.peek()){
                        record.pop();
                    }else{
                        record.push(chars[i]);
                    }
                }
            }
            int length=record.size();
            char[] result=new char[length];
            for(int j=0;j<length;j++){
                result[length-j-1]=record.pop();
            }
            return String.valueOf(result);
        }
}

