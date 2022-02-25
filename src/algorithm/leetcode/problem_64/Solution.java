package algorithm.leetcode.problem_64;

import java.util.HashMap;

public class Solution {
    public HashMap<Integer, Integer> map = new HashMap<>();

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        return process(grid, m, n, 0, 0);
    }

    public int process(int[][] grid, int m, int n, int x, int y) {
        int hashKey = hash(x, y);
        if (map.containsKey(hashKey)) {
            return map.get(hashKey);
        }
        if (x < 0 || x >= m || y < 0 || y >= n) {
            return Integer.MAX_VALUE;
        }
        if (x == m - 1 && y == n - 1) {
            return grid[x][y];
        }
        int val = grid[x][y] + Math.min(process(grid, m, n, x + 1, y), process(grid, m, n, x, y + 1));
        map.put(hashKey, val);
        return val;
    }

    public int hash(int x, int y) {
        return x * 1000 + y;
    }
}
