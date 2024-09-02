package Test;

import java.util.*;

import static jdk.nashorn.internal.objects.NativeArray.reverse;

/**
 * @Author: IIE
 * @name: test
 * @Date: 2024/3/25
 */
public class test {
    public static void main(String[] args) {
//        Solution solution = new Solution();
//        System.out.println(solution.strStr("aabaabaaf","aabaaf"));
        System.out.println(Runtime.getRuntime().availableProcessors());
        int[] nums={1,3,4,2};
        Arrays.sort(nums);
        for (int i = 0; i <nums.length ; i++) {
            System.out.println(nums[i]);
        }

        System.out.println(Integer.MAX_VALUE+1);
        System.out.println(1/2);
        System.out.println(isPalindrome("abba"));
        System.out.println(repeatNum("14444112442aa44442244311222222244445444243334444ccc4444"));
    }
    public static boolean isPalindrome(String s){
        //特殊情况判断
        if(s.length()==0){
            return false;
        }
        return TwoSideCompare(s,0,s.length()-1);
    }

    public static boolean TwoSideCompare(String s, int left, int right) {
        if(left>=right){
            return true;
        }
        if(s.charAt(left)==s.charAt(right)){
            return TwoSideCompare(s,++left,--right);
        }
        return false;

    }

    public static Map<Character,Integer> repeatNum(String s){
        Map<Character,Integer> map=new HashMap<>();
        if(s.length()==0){
            return map;
        }
        char a=s.charAt(0);
        int numMax=1;
        for (int i = 0; i < s.length(); i++) {
            char b=s.charAt(i);
            int value=map.getOrDefault(b,0)+1;
            map.put(b,value);
            if(value>numMax){
                a=b;
                numMax=value;
            }
        }
        Map<Character,Integer> result=new HashMap<>();
        result.put(a,numMax);
        return result;
    }


}
class Solution {
    public void getNext(int[] next, String s){
        int j = -1;
        next[0] = j;
        for (int i = 1; i < s.length(); i++){
            while(j >= 0 && s.charAt(i) != s.charAt(j+1)){
                j=next[j];
            }

            if(s.charAt(i) == s.charAt(j+1)){
                j++;
            }
            next[i] = j;
        }
    }
    public int strStr(String haystack, String needle) {
        if(needle.length()==0){
            return 0;
        }

        int[] next = new int[needle.length()];
        getNext(next, needle);
        int j = -1;
        for(int i = 0; i < haystack.length(); i++){
            while(j>=0 && haystack.charAt(i) != needle.charAt(j+1)){
                j = next[j];
            }
            if(haystack.charAt(i) == needle.charAt(j+1)){
                j++;
            }
            if(j == needle.length()-1){
                return (i-needle.length()+1);
            }
        }

        return -1;
    }
}


