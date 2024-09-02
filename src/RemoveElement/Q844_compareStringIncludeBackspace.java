package RemoveElement;

public class Q844_compareStringIncludeBackspace {
    public static void main(String[] args) {
        String s = "a#c", t = "b";
        System.out.println(backspaceCompare(s,t));
    }
    private static boolean backspaceCompare(String s,String t){
        char[] sChars=s.toCharArray();
        char[] tChars=t.toCharArray();
        //转换含#的字符串最后结果
        int slowIndex1=0;  //即使新数组的元素下标，也表示数组的元素长度
        for(int fastIndex=0;fastIndex<sChars.length;fastIndex++){
            if(sChars[fastIndex]!='#'){
                sChars[slowIndex1++]=sChars[fastIndex];
            }else{
                if(slowIndex1!=0){
                    slowIndex1--;
                }
            }

        }
        int slowIndex2=0;
        for(int fastIndex=0;fastIndex<tChars.length;fastIndex++){
            if(tChars[fastIndex]!='#'){
                tChars[slowIndex2++]=tChars[fastIndex];
            }else{
                if(slowIndex2!=0){
                    slowIndex2--;
                }
            }
        }
        //判断字符串是否相等
        for(int i=0;i<Math.min(slowIndex1,slowIndex2);i++){
            if(sChars[i]!=tChars[i]){
                return false;
            }
        }
        //同等长度的数组才内容相同
        if(slowIndex1==slowIndex2){
            return true;
        }else{
            return false;
        }

    }
}
