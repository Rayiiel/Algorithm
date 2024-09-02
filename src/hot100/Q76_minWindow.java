package hot100;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @Author: IIE
 * @name: Q76_minWindow
 * @Date: 2024/3/30
 */
public class Q76_minWindow {
    public static void main(String[] args) {
        String str=minWindow("ADOBECODEBANC","ABC");
        System.out.println(str);
    }

    public static String minWindow(String s, String t) {
        Map<Character,Integer> oMap=new HashMap<>();
        Map<Character,Integer> cMap=new HashMap<>();

        //统计原始字符串
        for(int i=0;i<t.length();i++){
            oMap.put(t.charAt(i),oMap.getOrDefault(t.charAt(i),0)+1);
        }

        int left=0,right=0,minLeft=-1,minRight=0,minLength=s.length();
        while(right<s.length()){
            while(!check(oMap,cMap)&&right<s.length()){
                cMap.put(s.charAt(right),cMap.getOrDefault(s.charAt(right),0)+1);
                right++;
            }
            while(check(oMap,cMap)&&left<=right){
                cMap.put(s.charAt(left),cMap.getOrDefault(s.charAt(left),0)-1);
                left++;
            }
            if(right-left+1<minLength){
                minLeft=left-1;
                minRight=right-1;
                minLength=minRight-minLeft+1;
            }
        }

        return minLeft==-1?"":s.substring(minLeft,minRight+1);

    }

    public static boolean check(Map<Character,Integer> oMap,Map<Character,Integer>cMap){
        //遍历oMap并查找cMap中对应的数值
        Iterator iter=oMap.entrySet().iterator();
        while(iter.hasNext()){
            Map.Entry entry=(Map.Entry) iter.next();
            Character key=(Character)entry.getKey();
            Integer val=(Integer)entry.getValue();
            if(cMap.getOrDefault(key,0)<val){
                return false;
            }
        }
        return true;
    }
}
