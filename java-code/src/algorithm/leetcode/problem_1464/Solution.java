package algorithm.leetcode.problem_1464;

public class Solution {
    public int maxProduct(int[] nums) {
        int a = 0;
        int b = 0;
        for (int num : nums) {
            if (num >= a) {
                b = a;
                a = num;
            } else if (num > b) {
                b = num;
            }
        }
        return (a - 1) * (b - 1);
    }
}
