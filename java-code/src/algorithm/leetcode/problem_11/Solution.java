package algorithm.leetcode.problem_11;

public class Solution {
    public int maxArea(int[] height) {
        int ans = 0;
        int l = 0;
        int r = height.length - 1;
        while (l < r) {
            ans = Math.max(ans, (r - l) * Math.max(height[l], height[r]));
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return ans;
    }
}
