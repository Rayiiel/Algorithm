package hot100.BackTracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: IIE
 * @name: Q46_permute
 * @Date: 2024/4/16
 * 排列问题
 */
public class Q46_permute {
    public static void main(String[] args) {
        int[] nums={1,2,3,4};
        permute(nums);
    }
    static List<List<Integer>> result=new ArrayList<>();
    static List<Integer> path=new ArrayList<>();
    public static List<List<Integer>> permute(int[] nums){
        int[] used=new int[nums.length];
        backTracking(nums,used);
        return result;
    }
    public static void backTracking(int[] nums,int[] used){
        if(path.size()==nums.length){
            result.add(new ArrayList<>(path));
            return;
        }
        for(int i=0;i<nums.length;i++){
            //只有这里要修改used的数值，其余与组合的题目一样
            if(used[i]==1){
                continue;
            }
            path.add(nums[i]);
            used[i]=1;
            backTracking(nums,used);
            used[i]=0;
            path.remove(path.size()-1);
        }
    }
}
