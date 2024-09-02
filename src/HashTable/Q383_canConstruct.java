package HashTable;

/**
 * @Author: IIE
 * @name: Q383_canConstruct
 * @Date: 2024/3/13
 */
public class Q383_canConstruct {
    public static void main(String[] args) {
        System.out.println(canConstruct("aa","ab"));
    }
    public static boolean canConstruct(String ransomNote, String magazine) {
        int[] record=new int[26];
        char[] ransom=ransomNote.toCharArray();
        char[] maga=magazine.toCharArray();
        for (int i = 0; i <maga.length ; i++) {
            record[maga[i]-'a']++;
        }
        for (int j = 0; j <ransom.length; j++) {
            record[ransom[j]-'a']--;
            if(record[ransom[j]-'a']<0){
                return false;
            }
        }
        return true;
    }
}
