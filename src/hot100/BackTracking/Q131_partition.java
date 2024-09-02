package hot100.BackTracking;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: IIE
 * @name: Q131_partition
 * @Date: 2024/5/6
 */
public class Q131_partition {
    public static void main(String[] args) {

    }
    public static List<List<String>> result=new ArrayList<>();
    public static Deque<String> path=new LinkedList<>();
    public List<List<String>> partition(String s){
        traceBacking(s,0);
        return result;
    }
    public void traceBacking(String s,int startIndex){
        if(startIndex>=s.length()){
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i <s.length() ; i++) {
            //判断当前是否是回文串
            String sub=s.substring(startIndex,i+1);
            if(isPalindrome(sub)){
                path.addLast(sub);
                //切割的字符串不能重复
                traceBacking(s,i+1);
            }else{
                continue;
            }
            //回溯
            path.pollLast();
        }
    }
    public boolean isPalindrome(String s){
        char[] chars = s.toCharArray();
        int right=s.length()-1;
        int left=0;
        while(left<right){
            if(chars[left]!=chars[right]){
                return false;
            }else{
                left++;
                right--;
            }
        }
        return true;
    }
}
