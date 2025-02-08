class Solution {

    int diff[][]=new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
    private boolean dfs(int row, int col,int i, int j, char[][] board,String word,boolean[][] visited,int wi){
        if(wi==word.length()){
            return true;
        }
        visited[i][j]=true;
        for(int k=0;k<4;k++){
            int adjR=i+diff[k][0];
            int adjC=j+diff[k][1];
            if(adjR>=0 && adjR<row && adjC>=0 && adjC<col){
                if(board[adjR][adjC]==word.charAt(wi) && !visited[adjR][adjC]){
                    boolean found=dfs(row,col,adjR,adjC,board,word, visited,wi+1);
                    if(found){
                        return true;
                    }
                }
            }
        }
        visited[i][j]=false;
        return false;
    }

    public boolean exist(char[][] board, String word) {
        int row=board.length;
        int col=board[0].length;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(board[i][j]==word.charAt(0)){
                    boolean visited[][]=new boolean[row][col];
                    boolean found=dfs(row,col,i,j,board,word,visited,1);
                    if(found){
                        return true;
                    }
                }
            }
        }
        return false;
        
    }
}
