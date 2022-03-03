package algorithm.leetcode.problem_258;

public class Solution {
    public int addDigits(int num) {
        while (num > 9) {
            int temp = 0;
            while (num > 0) {
                temp += num % 10;
                num /= 10;
            }
            num = temp;
        }
        return num;
    }

    // O(1) method
    // 数学: https://zh.wikipedia.org/wiki/%E6%95%B8%E6%A0%B9
    public int addDigits2(int num) {
        return num - 9 * ((num - 1) / 9);
    }
}
