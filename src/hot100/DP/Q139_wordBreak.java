package hot100.DP;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author: IIE
 * @name: Q139_wordBreak
 * @Date: 2024/5/16
 */
public class Q139_wordBreak {
    public static void main(String[] args) {

    }
    public boolean wordBreak(String s, List<String> wordDict){
        Set<String> wordDictSet=new HashSet(wordDict);
        //创建并初始化数组
        boolean[] dp=new boolean[s.length()+1];
        dp[0]=true;
        //先遍历背包，再遍历物品
        for (int i = 1; i <=s.length(); i++) {
            for (int j = 0;j < i ; j++) {
                if(dp[j]&&wordDictSet.contains(s.substring(j,i))){
                    dp[i]=true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
