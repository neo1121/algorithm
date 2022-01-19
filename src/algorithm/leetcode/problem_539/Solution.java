package algorithm.leetcode.problem_539;

import java.util.List;

public class Solution {
    public int findMinDifference(List<String> timePoints) {
        int ret = Integer.MAX_VALUE;
        for (int i = 0; i < timePoints.size() - 1; i++) {
            String pre = timePoints.get(i);
            for (int j = i + 1; j < timePoints.size(); j++) {
                String cur = timePoints.get(j);
                ret = Math.min(count(pre, cur), ret);
                if (ret == 0) {
                    return 0;
                }
            }
        }
        return ret;
    }

    public int count(String time1, String time2) {
        String[] split1 = time1.split(":");
        String[] split2 = time2.split(":");
        int t1 = Integer.parseInt(split1[0]) * 60 + Integer.parseInt(split1[1]);
        int t2 = Integer.parseInt(split2[0]) * 60 + Integer.parseInt(split2[1]);
        int ret1 = Math.abs(t1 - t2);
        int ret2 = t1 > t2 ? 24 * 60 - t1 + t2 : 24 * 60 - t2 + t1;
        return Math.min(ret1, ret2);
    }
}
