package Graph;

/**
 * @Author: IIE
 * @name: minDistance
 * @Date: 2024/6/12
 */
public class minDistance {
    public static void main(String[] args) {

    }
    public int minDistance(String word1,String word2){
        int n = word1.length();
        int m = word2.length();

        // 有一个字符串为空串
        if(n*m==0){
            return n+m;
        }

        // DP数组：以i-1,j-1下标相同的子串最少操作的个数
        int[][] D = new int[n+1][m+1];

        // 边界状态初始化
        for(int i=0;i<n+1;i++){
            D[i][0]=i;
        }
        for(int j=0;j<m+1;j++){
            D[0][j]=j;
        }

        // 计算所有DP值
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                //1.删除与i相关的字符串
                int left = D[i - 1][j] + 1;
                //2.删除与j相关的字符串
                int down = D[i][j - 1] + 1;
                //3.替换左右处字符的数值
                int left_down = D[i - 1][j - 1];
                if (word1.charAt(i - 1) != word2.charAt(j - 1)) {
                    left_down += 1;
                }
                //4.求最小值
                D[i][j] = Math.min(left, Math.min(down, left_down));
            }
        }
        return D[n][m];
    }
}
