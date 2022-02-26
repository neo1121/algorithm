package algorithm.leetcode.problem_260;

import java.util.Arrays;

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

    // for test
    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 3, 2, 5};
        System.out.println(Arrays.toString(new Solution().singleNumber(nums)));
    }
}
