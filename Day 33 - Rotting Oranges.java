import java.util.*;

class Solution {
    public int orangesRotting(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int oranges = 0;
        int days = -1;
        Queue<int[]> que = new LinkedList<>();
        boolean visited[][] = new boolean[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] != 0) {
                    if (grid[i][j] == 2) {
                        que.add(new int[]{i, j});
                        visited[i][j] = true;
                    }
                    oranges++;
                }
            }
        }

        if (oranges == 0)
            return 0;

        int diff[][] = new int[][]{{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

        while (!que.isEmpty()) {
            days++;
            int qsize = que.size();
            for (int i = 1; i<=qsize; i++) {
                int cell[] = que.poll();
                oranges--;
                for (int ind = 0; ind < 4; ind++) {
                    int adjR = cell[0] + diff[ind][0];
                    int adjC = cell[1] + diff[ind][1];
                    if (adjR >= 0 && adjR < row && adjC >= 0 && adjC < col) {
                        if (grid[adjR][adjC] == 1 && !visited[adjR][adjC]) {
                            visited[adjR][adjC] = true;
                            que.add(new int[]{adjR,adjC});
                            
                        }
                    }
                }
            }
        }

        return (oranges > 0) ? -1 : days;
    }
}
