package OQPD;

/**
 * @Author: IIE
 * @name: Q1958_checkMove
 * @Date: 2024/7/7
 */
public class Q1958_checkMove {
    public boolean checkMove(char[][] board,int rMove,int cMove,char color){
        int[] dx={1,1,1,-1,-1,-1,0,0};
        int[] dy={0,-1,1,-1,1,0,1,-1};
        for(int i=0;i<8;i++){
            if(check(board,rMove,cMove,color,dx[i],dy[i])) return true;
        }
        return false;
    }
    public boolean check(char[][] board,int rMove,int cMove,char color,int dx,int dy){
        int x=rMove+dx;
        int y=cMove+dy;
        int step=1;
        while(x>=0&&y>=0&&x<8&&y<8){
            if (step==1 &&board[x][y]==color) return false;
            if(board[x][y]=='.')   return false;
            if(board[x][y]==color) return true;
            x=x+dx;
            y=y+dy;
            step++;
        }
        return false;
    }
}
