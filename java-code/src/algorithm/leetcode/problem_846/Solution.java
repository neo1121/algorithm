package algorithm.leetcode.problem_846;

import java.util.Arrays;

public class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false;
        }
        Arrays.sort(hand);
        System.out.println(Arrays.toString(hand));
        int[] flag = new int[hand.length];
        for (int i = 0; i < hand.length; i++) {
            if (flag[i] == 1) {
                continue;
            }
            int cur = i;
            flag[cur] = 1;
            for (int j = 0; j < groupSize - 1; j++) {
                int next = next(hand, cur, flag);
                if (next == -1 || hand[next] - 1 != hand[cur]) {
                    return false;
                }
                cur = next;
            }
        }
        return true;
    }

    public int next(int[] hand, int cur, int[] flag) {
        int next = cur + 1;
        while (next < hand.length && (hand[next] == hand[cur] || flag[next] == 1)) {
            next += 1;
        }
        if (next < hand.length) {
            flag[next] = 1;
            return next;
        }
        return -1;
    }
}
