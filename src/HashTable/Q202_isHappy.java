package HashTable;

import java.util.HashSet;

/**
 * @Author: IIE
 * @name: Q202_isHappy
 * @Date: 2024/3/25
 */
public class Q202_isHappy {
    public static void main(String[] args) {
        System.out.println(isHappy(19));
    }

    //用hashSet来检测是否存在循环
    public static boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        while(n!=1&&!set.contains(n)){
            set.add(n);
            n=getNextNumber(n);
        }
        return n==1;
    }

    public static int getNextNumber(int n) {
        int data=0;
        String strN=String.valueOf(n);
        char[] chars = strN.toCharArray();
        for (char aChar : chars) {
                int i=((int)aChar)-48;
                data+=i*i;
        }
        return data;
    }

//    public static boolean isHappy(int n) {
//        if(n>1&&n<9){
//            return false;
//        }
//        int data=n;
//        int cycle=10;
//        String strN=String.valueOf(n);
//        while(data!=1){
//            if(cycle==0){
//                return false;
//            }
//            //初始话strN,data数值
//            strN=String.valueOf(data);
//            data=0;
//            char[] chars = strN.toCharArray();
//            for (char aChar : chars) {
//                int i=((int)aChar)-48;
//                data+=i*i;
//            }
//            cycle--;
//        }
//        return true;
//    }
}
