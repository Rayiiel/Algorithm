package Queue_Stack;

import java.util.Stack;

/**
 * @Author: IIE
 * @name: Q232_MyQueue
 * @Date: 2024/3/26
 * 使用两个栈实现先入先出队列。支持以下方法
 */
public class Q232_MyQueue {

    Stack<Integer> stackIn;
    Stack<Integer> stackOut;

    public Q232_MyQueue() {
        stackIn=new Stack<>();
        stackOut=new Stack<>();
    }

    //将元素x添加到队列的末尾
    public void push(int x) {
        stackIn.push(x);
    }
    //将最先存入的数据出栈
    public int pop() {
        if(stackOut.empty()){
            while(!(stackIn.empty())){
                stackOut.push(stackIn.pop());
            }
        }
        return stackOut.pop();
    }
    //输出最先存入的数据
    public int peek() {
        if(stackOut.empty()){
        while(!(stackIn.empty())){
            stackOut.push(stackIn.pop());
        }
        }
        return stackOut.peek();
    }
    //判断当前队列是否为空
    public boolean empty() {
        return stackIn.empty()&&stackOut.empty();
    }
}
