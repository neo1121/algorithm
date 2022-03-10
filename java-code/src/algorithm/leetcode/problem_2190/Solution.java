package algorithm.leetcode.problem_2190;

public class Solution {
    public int mostFrequent(int[] nums, int key) {
        int[] record = new int[1001];
        int max = 0;
        int ans = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == key) {
                record[nums[i]] += 1;
                if (record[nums[i]] > max) {
                    max = record[nums[i]];
                    ans = nums[i];
                }
            }
        }
        return ans;
    }
}
