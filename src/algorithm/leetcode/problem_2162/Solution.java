package algorithm.leetcode.problem_2162;

public class Solution {
    public int minCostSetTime(int startAt, int moveCost, int pushCost, int targetSeconds) {
        int min = targetSeconds / 60;
        int sec = targetSeconds % 60;
        int ret = 0;
        if (min > 99) {
            sec += 60 * (min - 99);
            min -= min - 99;
            ret = count(min, sec, startAt, moveCost, pushCost);
        } else if (sec + 60 < 100) {
            ret = Math.min(count(min, sec, startAt, moveCost, pushCost), count(min - 1, sec + 60, startAt, moveCost, pushCost));
        } else {
            ret = count(min, sec, startAt, moveCost, pushCost);
        }
        return ret;
    }

    public int count(int min, int sec, int startAt, int moveCost, int pushCost) {
        int[] nums = new int[]{min / 10, min % 10, sec / 10, sec % 10};
        int ret = 0;
        int pre = startAt;
        boolean f = false;
        for (int i = 0; i < 4; i++) {
            int cur = nums[i];
            if (cur != 0) {
                f = true;
            }
            if (!f) {
                continue;
            }
            if (pre != cur) {
                ret += moveCost;
                pre = cur;
            }
            ret += pushCost;
        }
        return ret;
    }
}
