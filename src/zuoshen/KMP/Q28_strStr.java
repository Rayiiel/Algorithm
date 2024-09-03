package zuoshen.KMP;

/**
 * @Author: IIE
 * @name: Q28_strStr
 * @Date: 2024/9/3
 */
public class Q28_strStr {
    public static void main(String[] args) {
        System.out.println(strStr("leetcode","leeto"));
    }

    public static int[] getNext(String str){
        int length=str.length();
        int[] next=new int[length];
        char[] strs=str.toCharArray();
        if(length<2) {return next;}
        //初始化
        next[0]=-1;
        next[1]=0;
        int i=2;
        int cur=0;
        while(i<length) {
            if(strs[i-1]==strs[cur]){
                next[i++]=++cur;
            }else if(cur>0){
                cur=next[cur];
            }else{
                next[i++]=0;
            }
        }
        return next;
    }

    public static  int strStr(String str1,String str2){
        char[] chars1=str1.toCharArray();
        char[] chars2=str2.toCharArray();
        int[] next=getNext(str2);
        int i1=0,i2=0;
        while(i1<chars1.length&&i2<chars2.length){
            if(chars1[i1]==chars2[i2]){
                i1++;
                i2++;
            }else if(i2==0) {  //i2都已经回退到了0还是不相等，i1++，两个重新开始比较
                i1++;
            }else{
                i2=next[i2];
            }
        }
        return i2==chars2.length?i1-i2:-1;
    }
}
