package algorithm.leetcode.problem_1748;

public class Solution {
    public int sumOfUnique(int[] nums) {
        int[] record = new int[101];
        for (int num : nums) {
            record[num] += 1;
        }
        int ans = 0;
        for (int i = 0; i < record.length; i++) {
            if (record[i] == 1) {
                ans += i;
            }
        }
        return ans;
    }
}
