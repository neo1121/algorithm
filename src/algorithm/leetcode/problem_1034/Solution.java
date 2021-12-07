package algorithm.leetcode.problem_1034;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

class Coordinate {
    int row;
    int col;

    public Coordinate() {
    }

    public Coordinate(int row, int col) {
        this.row = row;
        this.col = col;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Coordinate)) {
            return false;
        }
        return ((Coordinate) obj).col == this.col && ((Coordinate) obj).row == this.row;
    }

    @Override
    public int hashCode() {
        return 1;
    }
}

public class Solution {
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        Queue<Coordinate> queue = new LinkedList<>();
        HashSet<Coordinate> set = new HashSet<>();
        int maxRow = grid.length;
        int maxCol = grid[0].length;
        int[][] flag = new int[maxRow][maxCol];
        int originalColor = grid[row][col];
        queue.add(new Coordinate(row, col));
        while (!queue.isEmpty()) {
            Coordinate coordinate = queue.poll();
            flag[coordinate.row][coordinate.col] = 1;
            if ((coordinate.row == 0 || coordinate.row == maxRow - 1)
                    || (coordinate.col == 0 || coordinate.col == maxCol - 1)) {
                // 数组边界
                set.add(coordinate);
            } else if (grid[coordinate.row - 1][coordinate.col] != originalColor
                    || grid[coordinate.row + 1][coordinate.col] != originalColor
                    || grid[coordinate.row][coordinate.col - 1] != originalColor
                    || grid[coordinate.row][coordinate.col + 1] != originalColor) {
                // 连通分量的边界
                set.add(coordinate);
            }
            // 上边
            int newRow = Math.max(coordinate.row - 1, 0);
            int newCol = coordinate.col;
            if (flag[newRow][newCol] == 0
                    && grid[newRow][newCol] == originalColor) {
                queue.add(new Coordinate(newRow, newCol));
            }
            // 下边
            newRow = Math.min(coordinate.row + 1, maxRow - 1);
            if (flag[newRow][newCol] == 0
                    && grid[newRow][newCol] == originalColor) {
                queue.add(new Coordinate(newRow, newCol));
            }
            // 左边
            newRow = coordinate.row;
            newCol = Math.max(coordinate.col - 1, 0);
            if (flag[newRow][newCol] == 0
                    && grid[newRow][newCol] == originalColor) {
                queue.add(new Coordinate(newRow, newCol));
            }
            // 右边
            newRow = coordinate.row;
            newCol = Math.min(coordinate.col + 1, maxCol - 1);
            if (flag[newRow][newCol] == 0
                    && grid[newRow][newCol] == originalColor) {
                queue.add(new Coordinate(newRow, newCol));
            }
        }
        set.forEach(coordinate -> {
            grid[coordinate.row][coordinate.col] = color;
        });
        return grid;
    }
}
