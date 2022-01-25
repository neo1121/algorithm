package algorithm.leetcode.problem_2148;

import java.util.*;

public class Solution {
    public int countElements(int[] nums) {
        if (nums.length < 3) {
            return 0;
        }
        Arrays.sort(nums);
        int first = nums[0];
        int last = nums[nums.length - 1];
        if (first == last) {
            return 0;
        }
        int ret = nums.length;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != first) {
                ret -= i;
                break;
            }
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] != last) {
                ret -= nums.length - i - 1;
                break;
            }
        }
        return ret;
    }
}
