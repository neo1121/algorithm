package algorithm.leetcode.problem_220;

import java.util.TreeSet;

public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (k == 0) {
            return false;
        }
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            long cur = nums[i];
            // abs(i-j) <= t
            // -t <= i-j <= t
            // j-t <= i <= j+t
            Long ceiling = set.ceiling(cur - t);
            if (ceiling != null && ceiling <= cur + t) {
                return true;
            }
            set.add(cur);
            if (i >= k) {
                set.remove((long) (nums[i - k]));
            }
        }
        return false;
    }
}
