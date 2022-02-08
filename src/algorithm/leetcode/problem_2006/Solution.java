package algorithm.leetcode.problem_2006;

public class Solution {
    public int countKDifference(int[] nums, int k) {
        int[] demand = new int[300];
        int ans = 0;
        for (int num : nums) {
            if (demand[num + 100] > 0) {
                demand[num + 100] -= 1;
                ans += 1;
            }
            demand[num - k + 100] += 1;
            demand[num + k + 100] += 1;
        }
        return ans;
    }
}
