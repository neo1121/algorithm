package algorithm.leetcode.problem_260;

public class Solution {
    public int[] singleNumber(int[] nums) {
        int ret = 0;
        for (int num : nums) {
            ret ^= num;
        }
        int rightOne = ret & (~ret + 1);

        int theOne = 0;
        for (int num : nums) {
            if ((num & rightOne) != 0) {
                theOne ^= num;
            }
        }

        return new int[]{theOne, theOne ^ ret};
    }
}
