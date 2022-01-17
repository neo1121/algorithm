package algorithm.leetcode.problem_2139;

public class Solution {
    public int minMoves(int target, int maxDoubles) {
        int ret = 0;
        while (target != 1) {
            if (maxDoubles == 0) {
                ret += target - 1;
                break;
            } else if (target % 2 == 0 && maxDoubles > 0) {
                target /= 2;
                ret += 1;
                maxDoubles -= 1;
            } else {
                target -= 1;
                ret += 1;
            }
        }
        return ret;
    }
}
