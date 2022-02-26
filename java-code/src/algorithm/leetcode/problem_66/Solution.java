package algorithm.leetcode.problem_66;

public class Solution {
    public int[] plusOne(int[] digits) {
        int index = digits.length - 1;
        int temp = digits[index] + 1;
        digits[index] = temp % 10;
        temp /= 10;
        while (temp > 0 && --index >= 0) {
            temp += digits[index];
            digits[index] = temp % 10;
            temp /= 10;
        }
        if (temp > 0) {
            int[] ret = new int[digits.length + 1];
            ret[0] = temp;
            System.arraycopy(digits, 0, ret, 1, digits.length);
            return ret;
        }
        return digits;
    }
}
