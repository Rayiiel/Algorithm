package hot100.BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: IIE
 * @name: Q39_combinationSum
 * @Date: 2024/4/20
 */
public class Q39_combinationSum {
    public static void main(String[] args) {
        int[] candidates={2,3,5};
        List<List<Integer>> lists = combinationSum(candidates, 7);
    }

    static List<List<Integer>> results=new ArrayList<>();
    static List<Integer> result=new ArrayList<>();
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        int sum=0;
        int startIndex=0;
        Arrays.sort(candidates);
        backTracking(candidates,startIndex,sum,target);
        return results;
    }

    public static void backTracking(int[] candidates, int startIndex, int sum, int target) {
        if(target-sum==0){
            results.add(new ArrayList<>(result));
            return;
        }
        for(int i=startIndex;i<candidates.length;i++){
            if(candidates[i]<=target-sum){
                result.add(candidates[i]);
                sum+=candidates[i];
                //根据最后一个数字i，进行不断的递归和回溯，而不是每一次都从startIndex开始
                if(i>startIndex){
                    startIndex++;
                }
                backTracking(candidates,startIndex,sum,target);
                sum-=result.get(result.size()-1);
                result.remove(result.size()-1);
            }else{
                return;
            }
        }
    }
}
