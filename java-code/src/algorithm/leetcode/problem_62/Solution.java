package algorithm.leetcode.problem_62;

import java.util.HashMap;

public class Solution {
    public HashMap<Integer, Integer> map = new HashMap<>();

    public int uniquePaths(int m, int n) {
        return process(m, n, 0, 0);
    }

    public int process(int m, int n, int x, int y) {
        int hashKey = hash(x, y);
        if (map.containsKey(hashKey)) {
            return map.get(hashKey);
        }
        if (x >= m || y >= n) {
            return 0;
        }
        if (x == m - 1 && y == n - 1) {
            return 1;
        }
        int val = process(m, n, x + 1, y) + process(m, n, x, y + 1);
        map.put(hashKey, val);
        return val;
    }

    public int hash(int x, int y) {
        return x * 1000 + y;
    }
}
