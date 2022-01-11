package algorithm.leetcode.problem_1036;

import java.util.*;

public class Solution {

    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        if (blocked.length == 0 || isEqual(source, target)) {
            return true;
        }
        // source和target都未被包围
        return bfs(blocked, source, target) && bfs(blocked, target, source);
    }

    // 题目中说明障碍最多200个
    // 即能包围的块数最多为: 200 * 199 / 2 = 19900
    // 未被包围source或target可达返回true
    public boolean bfs(int[][] blocked, int[] source, int[] target) {
        HashSet<Integer>[] graph = new HashSet[1000000];
        for (int[] item : blocked) {
            blocks(graph, item);
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.add(source);
        blocks(graph, source);
        int count = 0;
        while (!queue.isEmpty()) {
            if (count++ > 19900) {
                return true;
            }
            int[] cur = queue.poll();
            int y = cur[0];
            int x = cur[1];
            int[] up = new int[]{y - 1, x};
            if (y > 0 && !isBlocked(graph, up)) {
                if (isEqual(up, target)) {
                    return true;
                }
                queue.add(up);
                blocks(graph, up);
            }
            int[] right = new int[]{y, x + 1};
            if (x < 999999 && !isBlocked(graph, right)) {
                if (isEqual(right, target)) {
                    return true;
                }
                queue.add(right);
                blocks(graph, right);
            }
            int[] down = new int[]{y + 1, x};
            if (y < 999999 && !isBlocked(graph, down)) {
                if (isEqual(down, target)) {
                    return true;
                }
                queue.add(down);
                blocks(graph, down);
            }
            int[] left = new int[]{y, x - 1};
            if (x > 0 && !isBlocked(graph, left)) {
                if (isEqual(left, target)) {
                    return true;
                }
                queue.add(left);
                blocks(graph, left);
            }
        }
        return false;
    }

    public boolean isEqual(int[] a, int[] b) {
        return a[0] == b[0] && a[1] == b[1];
    }

    public boolean isBlocked(HashSet<Integer>[] graph, int[] t) {
        HashSet<Integer> row = graph[t[0]];
        return row != null && row.contains(t[1]);
    }

    public void blocks(HashSet<Integer>[] graph, int[] t) {
        HashSet<Integer> row = graph[t[0]];
        if (row == null) {
            row = new HashSet<>();
            row.add(t[1]);
            graph[t[0]] = row;
        } else {
            row.add(t[1]);
        }
    }
}
