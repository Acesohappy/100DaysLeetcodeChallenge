 class Cell{
        int row,col;
        public Cell(int r, int c){
            this.row=r;
            this.col=c;
        }
    }
class Solution {
    public void solveSudoku(char[][] board) {
        int R=board.length,C=board[0].length;
        int size=board.length,submatsize=3;
        int rowflag[]=new int[size];
        int colflag[]=new int[size];
        int submatflag[]=new int[size];
        for(int row=0;row<R;row++){
            for(int col=0;col<C;col++){
                if(board[row][col]!='.'){
                    int dig=board[row][col]-'0';
                    int subidx=submatsize*(row/submatsize)+col/submatsize;
                    rowflag[row]|=(1<<dig);
                    colflag[col]|=(1<<dig);
                    submatflag[subidx]|=(1<<dig);
                }
            }
        }//End of matrix iteration to set initial state
        solve(R,C,submatsize,board,rowflag,colflag,submatflag);
    }
    private boolean solve(int R,int C,int submatsize,char board[][],int rowflag[],int colflag[],int submatflag[]){
        Cell toFill=getUnfilled(R,C,board);
        if(toFill==null){
            return true;
        }
        int subindex=submatsize*(toFill.row/submatsize)+toFill.col/submatsize;
        for(int dig=1;dig<=9;dig++){
            if((rowflag[toFill.row]&(1<<dig))==0 && (colflag[toFill.col]&(1<<dig))==0 && (submatflag[subindex]&(1<<dig))==0){
                board[toFill.row][toFill.col]=(char)('0'+dig);
                rowflag[toFill.row]|=(1<<dig);
                colflag[toFill.col]|=(1<<dig);
                submatflag[subindex]|=(1<<dig);
                boolean solved=solve(R,C,submatsize,board,rowflag,colflag,submatflag);
                if(solved){
                    return true;
                }
                board[toFill.row][toFill.col]='.';
                rowflag[toFill.row]^=(1<<dig);
                colflag[toFill.col]^=(1<<dig);
                submatflag[subindex]^=(1<<dig);
            }
        }
        return false;
    }
    private Cell getUnfilled(int R,int C,char board[][]){
        for(int row=0;row<R;row++){
            for(int col=0;col<C;col++){
                if(board[row][col]=='.'){
                    return new Cell(row,col);
                }
            }
        }
        return null;
    }   
}
