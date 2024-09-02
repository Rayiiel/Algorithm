package hot100.BackTracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: IIE
 * @name: Q17_letterCombinations
 * @Date: 2024/4/16
 */
public class Q17_letterCombinations {
    public static void main(String[] args) {
        List<String> list = letterCombinations("");
        System.out.println(list);
    }
    public static List<String> result=new ArrayList<>();
    public static String str="";
    public static List<String> letterCombinations(String digits) {
        HashMap<Character, Character[]> map = new HashMap<Character, Character[]>();
        map.put('2',new Character[]{'a','b','c'});
        map.put('3',new Character[]{'d','e','f'});
        map.put('4',new Character[]{'g','h','i'});
        map.put('5',new Character[]{'j','k','l'});
        map.put('6',new Character[]{'m','n','o'});
        map.put('7',new Character[]{'p','q','r','s'});
        map.put('8',new Character[]{'t','u','v'});
        map.put('9',new Character[]{'w','x','y','z'});
        char[] chars = digits.toCharArray();
        backtracking(map,chars,0);
        return result;
    }

    public static void backtracking(Map map, char[] chars, int startIndex) {
        if(str!=null&&str.length()==chars.length){
            result.add(str);
            return;
        }

            Character[] o = (Character[]) map.get(chars[startIndex]);
            for (int j = 0; j <o.length ; j++) {
                String temp=str;
                str=str+o[j];
                startIndex++;
                backtracking(map,chars,startIndex);
                str=temp;
                startIndex--;
            }

    }
}
