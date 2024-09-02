package Classic150;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: IIE
 * @name: Q12_intToRoman
 * @Date: 2024/7/3
 */
public class Q12_intToRoman {
    public static void main(String[] args) {
        System.out.println(intToRoman(100));
    }
    public static String intToRoman(int num){
        //1.字母表映射
        Map<Integer,String> map=new HashMap<>();
        map.put(1,"I");
        map.put(5,"V");
        map.put(10,"X");
        map.put(50,"L");
        map.put(100,"C");
        map.put(500,"D");
        map.put(1000,"M");
        //2.将数字转换为数组，求出最大的小于该数的整数
        Integer Num=Integer.valueOf(num);
        char[] chars=Num.toString().toCharArray();
        String result="";
        int n=chars.length,zs=1;
        for(int i=1;i<n;i++){ zs=zs*10;}
        //3.开始判断数字并进行转换
        for(int i=0;i<n;i++){
            if(chars[i]==0){
                continue;
            }else if(chars[i]<'4'){
                for(int j=0;j<chars[i]-'0';j++){
                    result+=map.get(zs);
                }
            }else if(chars[i]=='4'){
                result+=map.get(zs);
                result+=map.get(5*zs);
            }else if(chars[i]>='5'&&chars[i]<'9'){
                result+=map.get(5*zs);
                for(int j=0;j<chars[i]-'5';j++){
                    result+=map.get(zs);
                }
            }else{
                result+=map.get(zs);
                result+=map.get(zs*10);
            }
            zs=zs/10;
        }
        return result;
    }
}
