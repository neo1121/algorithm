package algorithm.leetcode.problem_2001;

import java.util.HashMap;

public class Solution {

    public long interchangeableRectangles(int[][] rectangles) {
        HashMap<Double, Long> ratios = new HashMap<>();
        for (int[] data : rectangles) {
            double width = data[0];
            double height = data[1];
            double ratio = width / height;
            if (!ratios.containsKey(ratio)) {
                ratios.put(ratio, 1L);
            } else ratios.put(ratio, ratios.get(ratio) + 1L);
        }
        long count = 0;
        for (Long num : ratios.values())
            count += getCount(num);
        return count;
    }

    public long getCount(long num) {
        return num * (num - 1) / 2;
    }

}
