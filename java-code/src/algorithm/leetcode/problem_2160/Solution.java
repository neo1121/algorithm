package algorithm.leetcode.problem_2160;

public class Solution {
    public int minimumSum(int num) {
        int[] nums = new int[10];
        while (num > 0) {
            nums[num % 10] += 1;
            num /= 10;
        }
        int ret = 0;
        int count = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            while (nums[i] > 0) {
                ret += count < 2 ? i : i * 10;
                count += 1;
                nums[i] -= 1;
            }
        }
        return ret;
    }
}
