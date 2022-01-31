package algorithm.leetcode.problem_2155;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class Solution {
    public List<Integer> maxScoreIndices(int[] nums) {
        int score = 0;
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                score += 1;
            }
        }
        List<Integer> t = new ArrayList<>();
        t.add(0);
        map.put(score, t);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                score += 1;
            } else {
                score -= 1;
            }
            t = map.get(score);
            if (t == null) {
                t = new ArrayList<>();
                map.put(score, t);
            }
            t.add(i + 1);
        }
        return map.lastEntry().getValue();
    }
}
