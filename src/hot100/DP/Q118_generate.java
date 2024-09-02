package hot100.DP;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: IIE
 * @name: Q118_generate
 * @Date: 2024/5/15
 */
public class Q118_generate {
    public static void main(String[] args) {
        System.out.println(generate(5));
    }
    public static List<List<Integer>> generate(int numRows){
        //创建dp
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> preList=new ArrayList<>();
        //初始化dp
        preList.add(1);
        result.add(preList);

        //1.遍历+递推公式
        for (int i = 2; i <=numRows ; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            for (int j = 1; j < i-1 ; j++) {
                list.add(preList.get(j)+preList.get(j-1));
            }
            list.add(1);
            result.add(list);
            preList=list;
        }
        return result;
    }
}
