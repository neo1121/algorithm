package algorithm.leetcode.problem_1765;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int m = isWater.length;
        int n = isWater[0].length;
        int[][] used = new int[m][n];
        Queue<int[]> queue = new LinkedList<>();
        int[][] ret = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isWater[i][j] == 1) {
                    used[i][j] = 1;
                    queue.add(new int[]{i, j});
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int val = ret[cur[0]][cur[1]] + 1;
            if (cur[0] - 1 >= 0 && used[cur[0] - 1][cur[1]] != 1) {
                ret[cur[0] - 1][cur[1]] = val;
                used[cur[0] - 1][cur[1]] = 1;
                queue.add(new int[]{cur[0] - 1, cur[1]});
            }
            if (cur[1] - 1 >= 0 && used[cur[0]][cur[1] - 1] != 1) {
                ret[cur[0]][cur[1] - 1] = val;
                used[cur[0]][cur[1] - 1] = 1;
                queue.add(new int[]{cur[0], cur[1] - 1});
            }
            if (cur[0] + 1 < m && used[cur[0] + 1][cur[1]] != 1) {
                ret[cur[0] + 1][cur[1]] = val;
                used[cur[0] + 1][cur[1]] = 1;
                queue.add(new int[]{cur[0] + 1, cur[1]});
            }
            if (cur[1] + 1 < n && used[cur[0]][cur[1] + 1] != 1) {
                ret[cur[0]][cur[1] + 1] = val;
                used[cur[0]][cur[1] + 1] = 1;
                queue.add(new int[]{cur[0], cur[1] + 1});
            }
        }
        return ret;
    }
}
