package hot100;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: IIE
 * @name: Q239_maxSlidingWindow
 * @Date: 2024/3/30
 * 单调队列
 * 思路：要是在窗口内部，后一个数字比前一个数字大的话，只需要记录后一个元素
 *      要是小的话，还需要留着，维持一个单调递减序列
 *      也就是说窗口里面不管有几个元素，总是头部的元素是最大的，它之前比它小的元素不需要记录
 *      再一个大的元素进入这个窗口时，那就记录当前元素就好了
 *
 * 队列函数使用说明：queue.offer(10)   队列尾部插入元素
 *               queue.peek()      获取队首的元素
 *               queue.poll()      移除队首元素
 *               queue.clear()
 */
public class Q239_maxSlidingWindow {
    public static void main(String[] args) {
        int[] nums={1,3,-1,-3,5,3,6,7};
        int[] ints = maxSlidingWindow(nums, 3);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
    //最大滑动窗口
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        //维持一个单调递减的序列
        for (int i=0;i<k;i++){
            while(!deque.isEmpty()&&nums[i]>deque.peekLast()){
                deque.pollLast();
            }
            deque.offerLast(nums[i]);
        }
        result[0]=deque.peekFirst();
        for(int j=1;j<nums.length-k+1;j++){
            if(nums[j-1]==deque.peekFirst()){
                deque.pollFirst();
            }
            /**这里特别要注意是大于，不是大于等于，因为要是等于弹出的话，比如有两个7，一个在后面位置，可能直接弹出
            实际上每次只能弹出一个数字*/
            while(!deque.isEmpty()&&nums[j+k-1]>deque.peekLast()){
                deque.pollLast();
            }
            deque.offerLast(nums[j+k-1]);
            result[j]=deque.peekFirst();
        }
        return result;
    }


}
