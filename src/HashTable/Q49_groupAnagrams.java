package HashTable;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @Author: IIE
 * @name: Q49_groupAnagrams
 * @Date: 2024/3/13
 */
public class Q49_groupAnagrams {
    public static void main(String[] args) {

    }
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map=new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key,list);
        }
        return new ArrayList<List<String>>(map.values());
    }

}
