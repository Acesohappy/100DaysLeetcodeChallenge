class Solution {
    public boolean isValidSudoku(char[][] board) {
        int size=board.length,r=board.length, c=board[0].length;
        int smsize=3;
        int rowf[]=new int[size];
        int colf[]=new int[size];
        int submatf[]=new int[size];
        for(int row=0;row<r;row++)
        {
            for(int col=0;col<c;col++){
                if(board[row][col]!='.'){
                int dig=board[row][col]-'0';
                int subidx=smsize*(row/smsize)+col/smsize;
                if((rowf[row]&(1<<dig))!=0 || (colf[col]&(1<<dig))!=0 || (submatf[subidx]&(1<<dig))!=0){
                    return false;
                }
                rowf[row]|=(1<<dig);
                colf[col]|=(1<<dig);
                submatf[subidx]|=(1<<dig);
            }
            }
        }
        return true;
    }
}
