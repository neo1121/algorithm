package algorithm.leetcode.problem_540;

public class Solution {
    // 位运算
    // 相同数亦或结果为0
    public int singleNonDuplicate(int[] nums) {
        int n = 0;
        for (int num : nums) {
            n ^= num;
        }
        return n;
    }

    // 二分
    // 偶数位时, 若该位的数与下一个数相等, 则单独数在右边; 若该位的数与上一个数相等, 则单独数在左边;
    // 奇数位时, 若该位的数与上一个数相等, 则单独数在右边; 若该位的数与下一个数相等, 则单独数在左边;
    public int singleNonDuplicate2(int[] nums) {
        for (int l = 0, r = nums.length - 1; l <= r; ) {
            if (l == r) {
                return nums[l];
            }
            int m = l + (r - l) / 2;
            // 是否与下一个数相等
            boolean f1 = m + 1 < nums.length && nums[m] == nums[m + 1];
            // 是否与上一个数相等
            boolean f2 = m - 1 >= 0 && nums[m] == nums[m - 1];
            if (!f1 && !f2) {
                return nums[m];
            }
            if (m % 2 == 0) {
                if (f1) {
                    // 偶数位的数与下一个数相等, 单独数在右边
                    l = m + 2;
                } else {
                    // 偶数位的数与上一个数相等, 单独数在左边
                    r = m - 2;
                }
            } else {
                if (f2) {
                    // 奇数位的数与上一个数相等, 单独数在右边
                    l = m + 1;
                } else {
                    // 奇数位的数与下一个数相等, 单独数在左边
                    r = m - 1;
                }
            }
        }
        return -1;
    }
}
