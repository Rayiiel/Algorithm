package String;

/**
 * @Author: IIE
 * @name: Q54k_ExchangeNumber
 * @Date: 2024/3/28
 */
public class Q54k_ExchangeNumber {
    public static void main(String[] args) {
        String s=new String("a1b2c3");
        String result="";
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)<97){
                result+="number";
            }else{
                result+=String.valueOf(s.charAt(i));
            }
        }
        System.out.println(result);
    }
}
