package algorithm.leetcode.problem_2399;

import java.util.Arrays;

public class Solution {
    public boolean checkDistances(String s, int[] distance) {
        int[] preIndex = new int[26];
        Arrays.fill(preIndex, -1);
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int letteri = chars[i] - 'a';
            if (preIndex[letteri] == -1) {
                preIndex[letteri] = i;
            } else {
                int dist = i - preIndex[letteri] - 1;
                if (dist != distance[letteri]) {
                    return false;
                }
            }
        }
        return true;
    }
}
