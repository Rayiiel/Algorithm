package Greedy_Algorithm;

import java.util.Arrays;

/**
 * @Author: IIE
 * @name: Q455_findConrentChildren
 * @Date: 2024/5/8
 */
public class Q455_findContentChildren {
    public static void main(String[] args) {

    }
    public int findContentChildren(int[] g,int[] s){
        Arrays.sort(g);  //从小到大排列
        Arrays.sort(s);  //
        int index=s.length-1,result=0;
        if(index<0){
            return 0;
        }
        for (int i = g.length-1; i >=0; i--) {
            if(s[index]>=g[i]){
                index--;
                result++;
            }
        }
        return result;
    }
}
