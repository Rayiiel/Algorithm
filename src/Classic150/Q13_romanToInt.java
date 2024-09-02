package Classic150;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: IIE
 * @name: Q13_romanToInt
 * @Date: 2024/7/3
 */
public class Q13_romanToInt {
    public static void main(String[] args) {
        System.out.println();
    }

    public int romanToInt(String s){
        Map<Character,Integer> map=new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        char[] chars = s.toCharArray();
        int num=0;

        for (int i = 0; i <s.length() ; i++) {
            switch(chars[i]){
                case 'I':
                    if(i+1<s.length()&&chars[i]=='V') { num+=4;i++; }
                    else num+=1;
                    break;
                case 'X':
                    if(i+1<s.length()&&chars[i]=='L') { num+=40;i++; }
                    else num+=10;
                    break;
                case 'C':
                    if(i+1<s.length()&&chars[i]=='D') { num+=400;i++; }
                    else num+=100;
                    break;
                default:
                    num+=map.get(chars[i]);
            }
        }

        return num;
    }
}
