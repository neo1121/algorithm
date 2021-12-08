package algorithm.leetcode.problem_435;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    static class MyComparator implements Comparator<int[]> {
        @Override
        public int compare(int[] t1, int[] t2) {
            return t2[1] - t1[1];
        }
    }

    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length <= 1) {
            return 0;
        }
        Arrays.sort(intervals, new MyComparator());
        System.out.println(Arrays.deepToString(intervals));
        int end = Integer.MIN_VALUE;
        int count = 0;
        for (int[] interval : intervals) {
            if (interval[0] >= end) {
                end = interval[1];
            } else {
                count += 1;
            }
        }
        return count;
    }

}
