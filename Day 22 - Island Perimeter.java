class Solution {
    int[][] diff = {{-1,0},{1,0},{0,-1},{0,1}};
    
    private int dfs(int row, int col, int[][] grid, int i, int j) {
        if (i < 0 || i >= row || j < 0 || j >= col || grid[i][j] == 0) {
            return 1;//comment
        }
        if (grid[i][j] == -1) {
            return 0;
        }
        grid[i][j] = -1;
        
        int perimeter = 0;
        for (int[] d : diff) {
            perimeter += dfs(row, col, grid, i + d[0], j + d[1]);
        }
        
        return perimeter;
    }
    
    public int islandPerimeter(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    return dfs(row, col, grid, i, j);
                }
            }
        }
        
        return 0; 
    }
}
