package algorithm.leetcode.problem_2044;

public class Solution {
    public int countMaxOrSubsets(int[] nums) {
        int max = 0;
        for (int num : nums) {
            max |= num;
        }
        return process(nums, 0, 0, max);
    }

    public int process(int[] nums, int index, int cur, int tar) {
        if (index == nums.length) {
            if (cur == tar) {
                return 1;
            } else {
                return 0;
            }
        }
        int cnt = 0;
        cnt += process(nums, index + 1, cur, tar);
        cnt += process(nums, index + 1, cur | nums[index], tar);
        return cnt;
    }
}
