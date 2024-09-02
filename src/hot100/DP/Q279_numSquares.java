package hot100.DP;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: IIE
 * @name: Q279_numSquares
 * @Date: 2024/5/16
 */
public class Q279_numSquares {
    public static void main(String[] args) {
        List<Integer> list = getSquares(25);
        System.out.println(list);
        numSquares(2);
    }
    public static int numSquares(int n){
        if(n==1){
            return 1;
        }
        List<Integer> list = getSquares(n);
        int[] dp=new int[n+1];
        dp[0]=0;
        for (int i = 1; i <dp.length ; i++) {
            dp[i]=Integer.MAX_VALUE;
        }
        for (int i = 0; i <list.size() ; i++) {
            for (int j = list.get(i); j <= n ; j++) {
                if(dp[j]!=Integer.MAX_VALUE){
                    dp[j]=Math.min(dp[j],dp[j-list.get(i)+1]);
                }
            }
        }
        return dp[n];

    }

    public static List<Integer> getSquares(int n){
        List<Integer> list = new ArrayList<>();
        if(n==1){
            list.add(1);
        }
        for (int i = 1; i <= n/2&&i*i<=n; i++) {
            list.add(i*i);
        }
        return list;
    }
}
