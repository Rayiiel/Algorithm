package hot100.BackTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: IIE
 * @name: Q22_generateParenthesis
 * @Date: 2024/4/22
 */
public class Q22_generateParenthesis {
    public static void main(String[] args) {
        List<String> strings = generateParenthesis(5);
        System.out.println(strings);

    }
    static List<String> results=new ArrayList<String>();
    public  static List<String> generateParenthesis(int n){
        int[] array=new int[2*(n-1)];
        int left=0;
        backtracking(0,array,left,n-1);
        return results;
    }
    public static void backtracking(int startIndex,int[] array,int left,int sum){
        if(left==sum){
            String result="(";
            for (int i = 0; i <array.length; i++) {
               if(array[i]==1){
                   result=result+"(";
               }else{
                   result=result+")";
               }
            }
            result=result+")";
            results.add(result);
            return;
        }
        for(int i=startIndex;i<array.length;i++){
            array[i]=1;
            left++;
            startIndex++;
            backtracking(startIndex,array,left,sum);
            array[i]=0;
            left--;
        }
    }
}
