package algorithm.leetcode.problem_507;

public class Solution {
    public boolean checkPerfectNumber(int num) {
        int[] ret = new int[]{6, 28, 496, 8128, 33550336};
        for (int i : ret) {
            if (i == num) {
                return true;
            }
        }
        return false;
    }
}
