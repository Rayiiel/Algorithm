package String;

/**
 * @Author: IIE
 * @name: Q28_strStr
 * @Date: 2024/3/27
 */
public class Q28_strStr {
    public static void main(String[] args) {
        String text="aabaaf";
        int[] next = new int[text.length()];
        getNext(next, text.toCharArray());
        for (int i = 0; i < next.length; i++) {
            System.out.println(next[i]);
        }
        System.out.println(KMP("aabaabaaf","aabaaf"));
    }
    public static int strStr(String haystack, String needle) {


        for (int i = 0; i < haystack.length(); i++) {
            if(haystack.charAt(i)==needle.charAt(0)){
                for (int j=0;j<needle.length();j++){
                    if(!(haystack.charAt(i+j)==needle.charAt(j))){
                        break;
                    }else if(j==needle.length()-1){
                        return i;
                    }
                }
            }
        }
        return -1;
    }

    //KMP算法
    public static int KMP(String haystack,String needle){
        if(needle.length()==0){
            return 0;
        }

        //获取模式串的长度
        int[] next = new int[needle.length()];
        getNext(next, needle.toCharArray());
        int j = 0;
        for(int i = 0; i < haystack.length(); i++){
            while(j>0 && haystack.charAt(i) != needle.charAt(j)){
                j = next[j-1];
            }
            if(haystack.charAt(i) == needle.charAt(j)){
                j++;
            }
            if(j == needle.length()){
                return (i-needle.length()+1);
            }
        }
        return -1;
    }

    public static void getNext(int[] next,char[] chars){
        int j=0;                                   //j表示前缀的末尾元素
        next[0]=j;
        for (int i = 1; i <chars.length ; i++) {   //i表示后缀的末尾元素
            while(j>0&&chars[i]!=chars[j]){
                j=next[j-1];                       //回退到前一个next对应的位置
            }
            if(chars[i]==chars[j]){
                j++;                               //j+1表示前面元素的长度
            }
            next[i]=j;
        }
    }



}
