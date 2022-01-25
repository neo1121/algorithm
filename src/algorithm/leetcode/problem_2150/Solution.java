package algorithm.leetcode.problem_2150;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> findLonely(int[] nums) {
        int[] record = new int[1000001];
        for (int num : nums) {
            record[num] += 1;
        }
        List<Integer> ret = new ArrayList<>();
        for (int i = 0; i < record.length; i++) {
            if (record[i] != 1) {
                continue;
            }
            if (i == 0) {
                if (record[i + 1] == 0) {
                    ret.add(i);
                }
            } else if (i == record.length - 1) {
                if (record[i - 1] == 0) {
                    ret.add(i);
                }
            } else if (record[i - 1] == 0 && record[i + 1] == 0) {
                ret.add(i);
            }
        }
        return ret;
    }
}
