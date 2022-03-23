package algorithm.leetcode.problem_2206;

public class Solution {
    public boolean divideArray(int[] nums) {
        int[] r = new int[501];
        for (int num : nums) {
            r[num] += 1;
        }
        for (int i : r) {
            if (i % 2 != 0) {
                return false;
            }
        }
        return true;
    }
}
