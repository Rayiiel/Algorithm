package HashTable;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: IIE
 * @name: Q242_isAnagram
 * @Date: 2024/3/12
 */
public class Q242_isAnagram {
    public static void main(String[] args) {
        System.out.println(isAnagram("anagram",  "nagaram"));
        System.out.println(isAnagram("absa",  "saba"));
        System.out.println(isAnagram("abs",  "abc"));

    }

    public static boolean isAnagram(String s, String t) {
        char[] charsS = s.toCharArray();
        char[] charsT = t.toCharArray();
//        Map<String,Integer> maps=new HashMap<>();
//        Map<String,Integer> mapt=new HashMap<>();
//        if(charsS.length!=charsT.length){
//            return false;
//        }
//        for (int i = 0; i < charsS.length; i++) {
//            String c = String.valueOf(charsS[i]);
//            //加上一个数值
//            if(maps.containsKey(c)){
//                maps.put(c,maps.get(c)+1);
//            }else{
//                maps.put(c,1);
//            }
//
//        }
//
//        for (int i = 0; i < charsT.length; i++) {
//            String c = String.valueOf(charsT[i]);
//            //加上一个数值
//            if(mapt.containsKey(c)){
//                mapt.put(c,mapt.get(c)+1);
//            }else{
//                mapt.put(c,1);
//            }
//        }
//
//        if(maps.equals(mapt)){
//            return true;
//        }else{
//            return false;
//        }
        //数组就是Hash值，可以使用字符对应的ASCII码来进行索引，不需要记录字符的具体内容
        int[] record=new int[26];
        for (int i = 0; i <charsS.length ; i++) {
            record[charsS[i]-'a']++;
        }
        for (int i = 0; i <charsT.length ; i++) {
            record[charsT[i]-'a']--;
        }
        for (int r:record) {
            if(r!=0){
                return false;
            }
        }
        return true;
    }
}
