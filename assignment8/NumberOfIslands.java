package assignment8;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {
    class Position {
        int r;
        int c;

        public Position() {}

        public Position(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public int numIslands(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int count = 0;

        int[] rDir = {-1, 0, 1, 0};
        int[] cDir = {0, -1, 0, 1};

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    grid[i][j] = '0';
                    Queue<Position> q = new LinkedList<>();
                    q.add(new Position(i, j));
                    while (!q.isEmpty()) {
                        Position curr = q.remove();
                        int currR = curr.r;
                        int currC = curr.c;

                        for (int k = 0; k < 4; k++) {
                            int nextR = currR + rDir[k];
                            int nextC = currC + cDir[k];
                            if (nextR >= 0 && nextR < row && nextC >= 0 && nextC < col && grid[nextR][nextC] == '1') {
                                q.add(new Position(nextR, nextC));
                                grid[nextR][nextC] = '0';
                            }
                        }
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        NumberOfIslands numberOfIslands1 = new NumberOfIslands();
        char[][] grid1 = {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        };
        System.out.println("Should be 1: " + numberOfIslands1.numIslands(grid1));

        NumberOfIslands numberOfIslands2 = new NumberOfIslands();
        char[][] grid2 = {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };
        System.out.println("Should be 3: " + numberOfIslands2.numIslands(grid2));
    }
}
