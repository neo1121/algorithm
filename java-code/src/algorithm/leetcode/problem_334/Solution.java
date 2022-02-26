package algorithm.leetcode.problem_334;

public class Solution {
    public boolean increasingTriplet(int[] nums) {
        int min = Integer.MAX_VALUE;
        int mid = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num < min) {
                min = num;
            } else if (num < mid) {
                mid = num;
            } else {
                return true;
            }
        }
        return false;
    }
}
