package algorithm.leetcode.problem_2149;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int[] rearrangeArray(int[] nums) {
        Queue<Integer> positive = new LinkedList<>();
        Queue<Integer> negative = new LinkedList<>();
        for (int num : nums) {
            if (num > 0) {
                positive.add(num);
            } else {
                negative.add(num);
            }
        }
        int[] ret = new int[nums.length];
        int index = 0;
        while (!positive.isEmpty() || !negative.isEmpty()) {
            if (index % 2 == 0) {
                ret[index++] = positive.poll();
            } else {
                ret[index++] = negative.poll();
            }
        }
        return ret;
    }
}
