package Back_Tracking;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: IIE
 * @name: Q77_combine
 * @Date: 2024/4/16
 */
public class Q77_combine {
    public static void main(String[] args) {
        combine(4,2);
    }
    public static List<List<Integer>> combine(int n,int k){
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        //遍历的起始位置
        int startIndex=1;
        backtracking(result,list,n,k,startIndex);
        return result;
    }

    public static void backtracking(List<List<Integer>> result, List<Integer> list, int n, int k, int startIndex) {
        //先写终止条件
        if(list.size()==k){
            //这里不能直接添加list，要不list的元素会一直变化
            result.add(new ArrayList<>(list));
            return;
        }
        /**   会相差7ms
        if(list.size()==k){
            //这里不能直接添加list，要不list的元素会一直变化的
            List<Integer> list1=new ArrayList<Integer>();
            for (int i = 0; i <k ; i++) {
                list1.add(list.get(i));
            }
            result.add(list1);
            return;
        }*/
        //开始当前层数据的遍历
        for(int i=startIndex;i<=n-(k-list.size())+1;i++){
            //数据处理
            list.add(i);
            //递归算法
            backtracking(result, list, n, k, i+1);
            //回溯
            list.remove(list.size()-1);
        }
    }
}
