class Solution {
    int diff[][]=new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
    private void dfs(int row,int col,char[][] grid,int i,int j){
        grid[i][j]='0';
        for(int k=0;k<4;k++){
            int adjR=i+diff[k][0];
            int adjC=j+diff[k][1];
            if(adjR>=0 && adjR<row && adjC>=0 && adjC<col){
                if(grid[adjR][adjC]=='1'){
                    dfs(row,col,grid,adjR,adjC);
                }
            }
        }
    }//comment 
    public int numIslands(char[][] grid) {
        int row=grid.length;
        int col=grid[0].length;
        int land=0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]=='1'){
                    land++;
                    dfs(row,col,grid,i,j);
                }
            }
        }
        return land;  
    }
}
