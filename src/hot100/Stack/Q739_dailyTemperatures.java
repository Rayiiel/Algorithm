package hot100.Stack;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @Author: IIE
 * @name: Q739_dailyTemperatures
 * @Date: 2024/5/6
 */
public class Q739_dailyTemperatures {
    public static void main(String[] args) {

    }
    public int[] dailyTemperatures(int[] temperatures) {
        int[] ans=new int[temperatures.length];
        Deque<Integer> stack=new LinkedList<>();
        for (int i = 0; i < temperatures.length; i++) {
            int temperature=temperatures[i];
            while(!stack.isEmpty()&&temperature>temperatures[stack.peek()]){
                int prefix=stack.pop();
                ans[prefix]=i-prefix;
            }
            stack.push(i);
        }
        return ans;
    }
}
