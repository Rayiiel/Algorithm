package hot100.BackTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: IIE
 * @name: Q78_subsets
 * @Date: 2024/4/16
 */
public class Q78_subsets {
    public static void main(String[] args) {

    }
    List<List<Integer>> result=new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums){
        for(int k=0;k<=nums.length;k++){
            ArrayList<Integer> path = new ArrayList<>();
            backtracking(nums,0,k,path);
        }
        return result;
    }

    public void backtracking(int[] nums, int starIndex,int k,ArrayList<Integer> path) {
        if(path.size()==k){
            result.add(new ArrayList<>(path));
        }
        for(int i=starIndex;i<=nums.length-(k-path.size());i++){
            path.add(nums[i]);
            backtracking(nums,i+1,k,path);
            path.remove(path.size()-1);
        }
    }
}
