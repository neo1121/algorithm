package algorithm.leetcode.problem_56;

import java.util.*;

public class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (t1, t2) -> t1[0] - t2[0]);
        List<int[]> list = new ArrayList<>();
        int i = 0;
        while (i < intervals.length) {
            int[] cur = intervals[i++];
            while (i < intervals.length && cur[1] >= intervals[i][0]) {
                cur[1] = Math.max(cur[1], intervals[i][1]);
                i++;
            }
            list.add(cur);
        }
        return list.toArray(new int[list.size()][]);
    }
}
