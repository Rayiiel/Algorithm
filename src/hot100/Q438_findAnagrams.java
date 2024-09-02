package hot100;

import jdk.nashorn.internal.ir.CallNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: IIE
 * @name: Q438_findAnagrams
 * @Date: 2024/3/29
 */
public class Q438_findAnagrams {
    public static void main(String[] args) {
        System.out.println(isDiffererntCharactorString("abc","cba"));
        System.out.println(findAnagrams("abab", "ab"));
    }
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> integers = new ArrayList<Integer>();
        for (int i = 0; i <=s.length()-p.length() ; i++) {
            if(i==s.length()-p.length()){
               if(isDiffererntCharactorString(s.substring(i),p)){
                   integers.add(i);
               }
            }else{
            if(isDiffererntCharactorString(s.substring(i,i+p.length()),p)){
                integers.add(i);
            }
            }
        }
        return integers;
    }
    public static boolean isDiffererntCharactorString(String a,String b){
        int[] records=new int[26];
        for (int i = 0; i <a.length() ; i++) {
            records[a.charAt(i)-'a']++;
        }
        for (int i = 0; i <b.length() ; i++) {
            records[b.charAt(i)-'a']--;
        }
        for (int i = 0; i <records.length ; i++) {
            if(records[i]!=0){
                return false;
            }
        }
        return true;
    }
}
