package Classic150;

import java.util.*;

/**
 * @Author: IIE
 * @name: Q15_threeSum
 * @Date: 2024/7/6
 */
public class Q15_threeSum {
    public static void main(String[] args) {
        int[] nums={-1,0,1,2,-1,-4};
        threeSum(nums);
    }
    static List<List<Integer>> result=new ArrayList<>();
    static Map<Integer,List<Integer>> map=new HashMap<>();
    static LinkedList<Integer> q = new LinkedList<>();
    public static List<List<Integer>> threeSum(int[] nums) {
        //回溯的方法
        backtracking(nums,0,0);
        return result;
    }

    public static void backtracking(int[] nums,int start,int sum){
        if(q.size()==3&&sum==0){
            List<Integer> list=new ArrayList<>(q);
            for(List<Integer> history:result){
                if(isEqual(list,history))return;
            }
            result.add(list);
            return;
        }
        for(int i=start;i<nums.length;i++){
            sum+=nums[i];
            q.add(nums[i]);
            backtracking(nums,i+1,sum);
            sum-=nums[i];
            q.removeLast();
        }
    }

    public static boolean isEqual(List<Integer> list1,List<Integer> list2){
        list1.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.intValue()-o2.intValue();
            }
        });

        list2.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.intValue()-o2.intValue();
            }
        });
       for(int i=0;i<list1.size();i++){
           if(list1.get(i)!=list2.get(i)) return false;
       }

       return true;
    }
}
