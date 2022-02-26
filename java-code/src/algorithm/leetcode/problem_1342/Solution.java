package algorithm.leetcode.problem_1342;

public class Solution {
    public int numberOfSteps(int num) {
        int ret = 0;
        while (num != 0) {
            ret += 1;
            if (num % 2 == 0) {
                num /= 2;
            } else {
                num -= 1;
            }
        }
        return ret;
    }
}
