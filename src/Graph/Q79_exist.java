package Graph;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @Author: IIE
 * @name: Q79_exist
 * @Date: 2024/6/11
 */
public class Q79_exist {
    public static void main(String[] args) {

    }
    public boolean exist(char[][] board,String word){
        int m=board.length,n=board[0].length;
        for (int i = 0; i <m ; i++) {
            for (int j = 0; j <n ; j++) {
                if(board[i][j]==word.charAt(0)){
                    if(findWord(board,i,j,word,1)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean findWord(char[][] board, int x, int y,String word,int s) {
        if(s==word.length()){return true;}
        int[] curNode={x,y};
        int[][] dir={{0,1},{0,-1},{1,0},{-1,0}};
        int m=board.length,n=board[0].length;
        int[] nextNode=new int[2];
        for(int i=0;i<4;i++){
            nextNode[0]=curNode[0]+dir[i][0];
            nextNode[1]=curNode[1]+dir[i][1];
            if(nextNode[0]<m&&nextNode[0]>=0&&nextNode[1]>=0&&nextNode[1]<n&&board[nextNode[0]][nextNode[1]]==word.charAt(s)){
                if(findWord(board, nextNode[0],  nextNode[1],word, ++s)){
                    return true;
                }
                s--;
            }
        }

        return false;
    }
}
