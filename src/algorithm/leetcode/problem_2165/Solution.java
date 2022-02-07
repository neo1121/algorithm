package algorithm.leetcode.problem_2165;

public class Solution {
    public long smallestNumber(long num) {
        int[] nums = new int[10];
        boolean f = num < 0;
        if (f) {
            num *= -1;
        }
        while (num > 0) {
            nums[(int) (num % 10)] += 1;
            num /= 10;
        }
        long ans = 0;
        if (f) {
            for (int i = nums.length - 1; i >= 0; i--) {
                while (nums[i] > 0) {
                    ans = ans * 10 + i;
                    nums[i]--;
                }
            }
        } else {
            for (int i = 1; i < nums.length; i++) {
                while (nums[i] > 0) {
                    if (nums[0] > 0 && ans > 0) {
                        while (nums[0] > 0) {
                            ans = ans * 10;
                            nums[0]--;
                        }
                    }
                    ans = ans * 10 + i;
                    nums[i]--;
                }
            }
            while (nums[0] > 0) {
                ans = ans * 10;
                nums[0]--;
            }
        }
        return f ? -ans : ans;
    }
}
