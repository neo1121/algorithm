package algorithm.leetcode.problem_506;

import java.util.Arrays;
import java.util.HashMap;

public class Solution {
    public String[] findRelativeRanks(int[] score) {
        Integer[] sortedScore = new Integer[score.length];
        for (int i = 0; i < score.length; i++) {
            sortedScore[i] = score[i];
        }
        Arrays.sort(sortedScore, (o1, o2) -> o2 - o1);
        HashMap<Integer, String> hashMap = new HashMap<>();
        String[] rank = new String[]{"Gold Medal", "Silver Medal", "Bronze Medal"};
        for (int i = 0; i < sortedScore.length; i++) {
            hashMap.put(sortedScore[i], i <= 2 ? rank[i] : (i + 1) + "");
        }
        String[] ret = new String[score.length];
        for (int i = 0; i < score.length; i++) {
            ret[i] = hashMap.get(score[i]);
        }
        return ret;
    }
}
