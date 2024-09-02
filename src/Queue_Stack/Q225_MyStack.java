package Queue_Stack;

import jdk.nashorn.internal.ir.CallNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: IIE
 * @name: Q225_MyStack
 * @Date: 2024/3/26
 */
public class Q225_MyStack {

    Queue<Integer> QueueIn;
    Queue<Integer> QueueOut;

    public Q225_MyStack() {
        QueueIn=new LinkedList<>();
        QueueOut=new LinkedList<>();
    }

    public void push(int x) {
        QueueOut.offer(x);
        while(!(QueueIn.isEmpty())){
            QueueOut.offer(QueueIn.poll());
        }
        Queue<Integer> queueTemp;
        queueTemp=QueueIn;
        QueueIn=QueueOut;
        QueueOut=queueTemp;

    }

    public int pop() {
        return QueueIn.poll();
    }

    public int top() {
        return QueueIn.peek();
    }

    public boolean empty() {
        return QueueIn.isEmpty()&&QueueOut.isEmpty();
    }
}
