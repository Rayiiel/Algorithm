package List_Node;

/**
 * @Author: IIE
 * @name: Q151_ReverseWord
 * @Date: 2024/1/30
 */
public class Q151_ReverseWord {
    public static void main(String[] args) {
        String s="hello world  ";
        String[] newString=new String[s.length()];
        String temp=null;
        char[] chars=s.toCharArray();
        int count=0;
        for (int i = 0; i <chars.length ; i++) {
            if(chars[i]!=' '){
                if(temp==null){
                    temp=String.valueOf(chars[i]);
                }else{
                    temp=temp.concat(String.valueOf(chars[i]));
                }

            }else{
                if(temp!=null){
                    newString[count]=temp;
                    temp=null;
                    count++;
                }
            }
        }
        //做一个trim处理就可以
        for (int i = count-1; i>=0; i--) {
            System.out.print(newString[i]+" ");
        }
        System.out.println();

        System.out.println( "   haisope".trim());
    }
}
